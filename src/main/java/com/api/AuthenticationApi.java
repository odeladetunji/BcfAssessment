package com.api;


import com.dto.ResponsePojo;
import com.dto.TokenDto;
import com.services.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationApi {

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/token")
    public ResponsePojo<TokenDto> getToken(){
        String token = jwtUtils.generateJwtAccessToken();

        TokenDto tokenDto = new TokenDto();
        tokenDto.setAccessToken(token);

        ResponsePojo<TokenDto> responsePojo = new ResponsePojo<>();
        responsePojo.setData(tokenDto);
        responsePojo.setMessage("Access Token");
        return responsePojo;
    }
}
