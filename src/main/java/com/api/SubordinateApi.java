package com.api;

import com.dto.ResponsePojo;
import com.dto.SubordinateDto;
import com.entity.Subordinates;
import com.services.BcfService;
import com.services.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/subordinate")
public class SubordinateApi {

    @Autowired
    private BcfService bcfService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/create")
    public ResponsePojo<Subordinates> createSubOrdinate(@RequestBody SubordinateDto subordinateDto, HttpServletRequest request){
        jwtUtils.validateAllToken(request);
        return bcfService.createSubOrdinate(subordinateDto);
    }

    @PutMapping("/update")
    public ResponsePojo<Subordinates> updateSubOrdinate(@RequestBody SubordinateDto subordinateDto, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.updateSubOrdinate(subordinateDto);
    }

    @GetMapping("/id/{id}")
    public ResponsePojo<Subordinates> getSubordinateById(@PathVariable(name = "id") Long id, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.getSubordinateById(id);
    }

    @GetMapping("/all")
    public ResponsePojo<List<Subordinates>> fetchAllSubordinates(Pageable pageable, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.fetchAllSubordinates(pageable);
    }

}
