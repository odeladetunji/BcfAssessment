package com.services;

import com.dto.EmployeeDetailsImpl;
import com.entity.Employees;
import com.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employees> optionalUser = employeeService.findByFirstName(username);
        optionalUser.orElseThrow(() -> new ApiException("Bcf User not found"));

        return EmployeeDetailsImpl.build(optionalUser.get());
    }

}
