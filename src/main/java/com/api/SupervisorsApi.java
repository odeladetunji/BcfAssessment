package com.api;

import com.dto.ResponsePojo;
import com.dto.SupervisorDto;
import com.entity.Supervisors;
import com.services.BcfService;
import com.services.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/supervisors")
public class SupervisorsApi {

    @Autowired
    private BcfService bcfService;
    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/all")
    public ResponsePojo<List<Supervisors>> fetchAllSupervisors(Pageable pageable, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.fetchAllSupervisors(pageable);
    }

    @PostMapping("/create")
    public ResponsePojo<Supervisors> createSuperVisor(@RequestBody SupervisorDto supervisorDto, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.createSuperVisor(supervisorDto);
    }

    @GetMapping("/id/{id}")
    public ResponsePojo<Supervisors> getSupervisorById(@PathVariable(name = "id", required = true) Long id, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.getSupervisorById(id);
    }

    @PutMapping("/update")
    public ResponsePojo<Supervisors> updateSuperVisor(@RequestBody SupervisorDto supervisorDto, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.updateSuperVisor(supervisorDto);
    }
}




















