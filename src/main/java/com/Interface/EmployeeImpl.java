package com.Interface;


import com.entity.Employees;

import java.util.Optional;

public interface EmployeeImpl {
    Employees saveOrUpdate(Employees emp);
    Optional<Employees> findByFirstName(String firstName);
    Optional<Employees> findById(Long id);
}
