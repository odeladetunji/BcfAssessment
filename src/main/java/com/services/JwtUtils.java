package com.services;

import com.exception.AuthenticationError;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${villo.app.jwtSecret}")
    private String jwtSecret;

    @Value("${villo.app.jwtExpirationAccessMs}")
    private int jwtExpirationAccessMs;

    public String generateJwtAccessToken() {
        String token = Jwts.builder().setSubject("bcf").setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationAccessMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        return token;

    }

    public boolean validateAllToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Boolean tokenIsValid = validateJwtToken(token);
        if (tokenIsValid) return true;

        throw new AuthenticationError("Invalid Token");
    }

    public boolean validateJwtToken(String authToken) {
        if (ObjectUtils.isEmpty(authToken))
            throw new AuthenticationError("Invalid token");
        try {
            String token = authToken.split("Bearer")[1].trim();
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
            throw new AuthenticationError("Invalid token");
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
            throw new AuthenticationError("Invalid token");
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
            throw new AuthenticationError("Invalid token");
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
            throw new AuthenticationError("Invalid token");
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Invalid Jwt {}", e.getMessage());
            throw new AuthenticationError("Invalid token");
        }

        return false;

    }
}
