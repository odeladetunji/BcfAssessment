package com.services;

import com.Interface.EmployeeImpl;
import com.entity.Employees;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employees saveOrUpdate(Employees emp){
        return employeeRepository.save(emp);
    }

    @Override
    public Optional<Employees> findByFirstName(String firstName){
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<Employees> findById(Long id){
        return employeeRepository.findById(id);
    }

}
