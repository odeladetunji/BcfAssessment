package com.api;


import com.dto.EmployeeDto;
import com.dto.ResponsePojo;
import com.entity.Employees;
import com.services.BcfService;
import com.services.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeApi {

    @Autowired
    private BcfService bcfService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/create")
    public ResponsePojo<Employees> createEmployee(@RequestBody EmployeeDto employeeDto, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.createEmployee(employeeDto);
    }

    @PutMapping("/update")
    public ResponsePojo<Employees> updateEmployee(@RequestBody EmployeeDto employeeDto, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.updateEmployee(employeeDto);
    }

    @GetMapping("/id/{id}")
    public ResponsePojo<Employees> GetEmployeeById(@PathVariable(name = "id", required = true) Long id, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.GetEmployeeById(id);
    }

    @GetMapping("/all")
    public ResponsePojo<List<Employees>> fetchEmployees(Pageable pageable, HttpServletRequest request) {
        jwtUtils.validateAllToken(request);
        return bcfService.fetchEmployees(pageable);
    }
}