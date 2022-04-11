package com.repository;

import com.entity.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employees, Long> {
    Optional<Employees> findByFirstName(String firstName);
    Optional<Employees> findById(Integer id);
}
