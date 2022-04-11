package com.services;

import com.dto.EmployeeDto;
import com.dto.ResponsePojo;
import com.dto.SubordinateDto;
import com.dto.SupervisorDto;
import com.entity.*;
import com.exception.ApiException;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BcfService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private SubordicateService subordicateService;

    @Autowired
    private SupervisorsServices supervisorsServices;

    @Autowired
    private EmployeeService employeeService;

    public ResponsePojo<Employees> createEmployee(EmployeeDto employeeDto){

        Assert.notNull(employeeDto.getFirstName(), "FirstName cannot be null");
        Assert.notNull(employeeDto.getLastName(), "LastName cannot be null");
        Assert.notNull(employeeDto.getLevel(), "Level cannot be null");
        Assert.hasText(employeeDto.getFirstName(), "FirstName is required");
        Assert.hasText(employeeDto.getLastName(), "LastName is required");
        Assert.hasText(employeeDto.getLevel().toString(), "Employee level is required");

        Employees employees = new Employees();
        employees.setFirstName(employeeDto.getFirstName());
        employees.setLastName(employeeDto.getLastName());
        employees.setLevel(employeeDto.getLevel());
        employees.setCreatedBy("Admin");
        employees.setCreatedDate(new Date());
        employees.setLast_modified_by("Admin");
        employees.setLast_modified_date(new Date());

        Employees newEmployee = employeeService.saveOrUpdate(employees);

        ResponsePojo<Employees> responsePojo = new ResponsePojo<>();
        responsePojo.setData(newEmployee);
        responsePojo.setMessage("Employee saved successfully");

        return responsePojo;

    }

    public ResponsePojo<Employees> updateEmployee(EmployeeDto employeeDto){

        Assert.notNull(employeeDto.getFirstName(), "FirstName cannot be null");
        Assert.notNull(employeeDto.getLastName(), "LastName cannot be null");
        Assert.notNull(employeeDto.getLevel(), "Level cannot be null");
        Assert.notNull(employeeDto.getId(), "Id cannot be null");
        Assert.hasText(employeeDto.getId().toString(), "Id is required to update an employee");
        Assert.hasText(employeeDto.getFirstName(), "FirstName is required");
        Assert.hasText(employeeDto.getLastName(), "LastName is required");
        Assert.hasText(employeeDto.getLevel().toString(), "Employee level is required");

        Optional<Employees> employeesOptional = employeeService.findById(employeeDto.getId());
        employeesOptional.orElseThrow(() ->
                new ApiException(String.format("Employee with id : %s not found", employeeDto.getId())));

        Employees employees = new Employees();
        employees.setFirstName(employeeDto.getFirstName());
        employees.setLastName(employeeDto.getLastName());
        employees.setLevel(employeeDto.getLevel());
        employees.setLast_modified_by("Admin");
        employees.setLast_modified_date(new Date());

        Employees newEmployee = employeeService.saveOrUpdate(employees);

        ResponsePojo<Employees> responsePojo = new ResponsePojo<>();
        responsePojo.setData(newEmployee);
        responsePojo.setMessage("Employee Updated successfully");

        return responsePojo;

    }

    public ResponsePojo<Employees> GetEmployeeById(Long id){
        Optional<Employees> employeesOptional = employeeService.findById(id);
        employeesOptional.orElseThrow(() ->
                new ApiException(String.format("Employee with id : %s not found", id)));

        ResponsePojo<Employees> responsePojo = new ResponsePojo<>();
        responsePojo.setData(employeesOptional.get());
        responsePojo.setMessage("Employee Fetched successfully");

        return responsePojo;
    }

    public ResponsePojo<List<Employees>> fetchEmployees(Pageable pageable){
        QEmployees qEmployees = QEmployees.employees;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<Employees> jpaQuery = jpaQueryFactory.selectFrom(qEmployees)
                .offset(pageable.getPageNumber())
                .limit(pageable.getPageSize());

        ResponsePojo<List<Employees>> responsePojo = new ResponsePojo<>();
        responsePojo.setData(jpaQuery.fetch());
        responsePojo.setMessage("Employee List Fetche Successfully");

        return responsePojo;

    }

    public ResponsePojo<Supervisors> createSuperVisor(SupervisorDto supervisorDto){

        Assert.notNull(supervisorDto.getEmployeeId(), "EmployeeId cannot be null");
        Assert.notNull(supervisorDto.getTeam(), "Team cannot be empty");
        Assert.notNull(supervisorDto.getLastName(), "LastName is Required");
        Assert.notNull(supervisorDto.getFirstName(), "FirstName is Required");
        Assert.hasText(supervisorDto.getTeam(), "Id is required to update an employee");
        Assert.hasText(supervisorDto.getFirstName(), "FirstName is required");
        Assert.hasText(supervisorDto.getLastName(), "LastName is required");
        Assert.hasText(supervisorDto.getEmployeeId().toString(), "EmployeeId is required");

        Supervisors newSupervisor = new Supervisors();
        newSupervisor.setFirstName(supervisorDto.getFirstName());
        newSupervisor.setLastName(supervisorDto.getLastName());
        newSupervisor.setTeam(supervisorDto.getTeam());
        newSupervisor.setEmployeeId(supervisorDto.getEmployeeId());
        newSupervisor.setCreatedBy("Admin");
        newSupervisor.setCreatedDate(new Date());
        newSupervisor.setLast_modified_by("Admin");
        newSupervisor.setLast_modified_date(new Date());

        Supervisors supervisors = supervisorsServices.saveOrUpdate(newSupervisor);
        ResponsePojo<Supervisors> responsePojo = new ResponsePojo<>();
        responsePojo.setData(supervisors);
        responsePojo.setMessage("Supervisor Created Successfully");

        return responsePojo;
    }

    public ResponsePojo<Supervisors> updateSuperVisor(SupervisorDto supervisorDto){

        Assert.notNull(supervisorDto.getEmployeeId(), "EmployeeId cannot be null");
        Assert.notNull(supervisorDto.getTeam(), "Team cannot be empty");
        Assert.notNull(supervisorDto.getLastName(), "LastName is Required");
        Assert.notNull(supervisorDto.getFirstName(), "FirstName is Required");
        Assert.notNull(supervisorDto.getId(), "Id cannot be null");
        Assert.hasText(supervisorDto.getId().toString(), "Id is required to update a supevisor");
        Assert.hasText(supervisorDto.getTeam(), "Id is required to update an supevisor");
        Assert.hasText(supervisorDto.getFirstName(), "FirstName is required");
        Assert.hasText(supervisorDto.getLastName(), "LastName is required");
        Assert.hasText(supervisorDto.getEmployeeId().toString(), "EmployeeId is required");

        Optional<Supervisors> optionalSupervisors = supervisorsServices.findById(supervisorDto.getId());
        optionalSupervisors.orElseThrow(() -> new ApiException(String.format("Supervisor with this id not found", supervisorDto.getId())));

        Supervisors newSupervisor = new Supervisors();
        newSupervisor.setFirstName(supervisorDto.getFirstName());
        newSupervisor.setLastName(supervisorDto.getLastName());
        newSupervisor.setTeam(supervisorDto.getTeam());
        newSupervisor.setEmployeeId(supervisorDto.getEmployeeId());
        newSupervisor.setLast_modified_by("Admin");
        newSupervisor.setLast_modified_date(new Date());

        Supervisors supervisors = supervisorsServices.saveOrUpdate(newSupervisor);

        ResponsePojo<Supervisors> responsePojo = new ResponsePojo<>();
        responsePojo.setData(supervisors);
        responsePojo.setMessage("Supervisor Created Successfully");

        return responsePojo;
    }

    public ResponsePojo<Supervisors> getSupervisorById(Long id){
        Optional<Supervisors> optionalSupervisors = supervisorsServices.findById(id);
        optionalSupervisors.orElseThrow(() ->
                new ApiException(String.format("Supervisor with this id not found", id)));

        ResponsePojo<Supervisors> responsePojo = new ResponsePojo<>();
        responsePojo.setData(optionalSupervisors.get());
        responsePojo.setMessage("Supervisor Fetched Successfully");

        return responsePojo;
    }

    public ResponsePojo<List<Supervisors>> fetchAllSupervisors(Pageable pageable){

        QSupervisors qSupervisors = QSupervisors.supervisors;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<Supervisors> jpaQuery = jpaQueryFactory.selectFrom(qSupervisors)
                .offset(pageable.getPageNumber())
                .limit(pageable.getPageSize());

        ResponsePojo<List<Supervisors>> responsePojo = new ResponsePojo<>();
        responsePojo.setData(jpaQuery.fetch());
        responsePojo.setMessage("Supervisor List Fetched Successfully");

        return responsePojo;
    }

    public ResponsePojo<Subordinates> createSubOrdinate(SubordinateDto subordinateDto){

        Assert.notNull(subordinateDto.getTeam(), "Team is required");
        Assert.notNull(subordinateDto.getFirstName(), "firstName is required");
        Assert.notNull(subordinateDto.getLastName(), "firstName is required");
        Assert.notNull(subordinateDto.getEmployeeId(), "EmployeeId cannot be null");
        Assert.hasText(subordinateDto.getTeam(), "Team is required");
        Assert.hasText(subordinateDto.getFirstName(), "FirstName is required");
        Assert.hasText(subordinateDto.getLastName(), "LastName is required");
        Assert.hasText(subordinateDto.getEmployeeId().toString(), "EmployeeId is required");

        Subordinates subordinates = new Subordinates();
        subordinates.setTeam(subordinateDto.getTeam());
        subordinates.setEmployeeId(subordinates.getEmployeeId());
        subordinates.setFirstName(subordinateDto.getFirstName());
        subordinates.setLastName(subordinates.getFirstName());
        subordinates.setId(subordinates.getId());
        subordinates.setSupervisorId(subordinates.getSupervisorId());
        subordinates.setCreatedBy("Admin");
        subordinates.setCreatedDate(new Date());
        subordinates.setLast_modified_by("Admin");
        subordinates.setLast_modified_date(new Date());

        Subordinates newSubordinate = subordicateService.saveOrUpdate(subordinates);
        System.out.println(newSubordinate);

        ResponsePojo<Subordinates> responsePojo = new ResponsePojo<>();
        responsePojo.setData(newSubordinate);
        responsePojo.setMessage("Subordinate Created Successfully");

        return responsePojo;

    }

    public ResponsePojo<Subordinates> updateSubOrdinate(SubordinateDto subordinateDto){

        Assert.notNull(subordinateDto.getTeam(), "Team is required");
        Assert.notNull(subordinateDto.getFirstName(), "firstName is required");
        Assert.notNull(subordinateDto.getLastName(), "firstName is required");
        Assert.notNull(subordinateDto.getEmployeeId(), "EmployeeId cannot be null");
        Assert.notNull(subordinateDto.getId(), "Id cannot be null");
        Assert.hasText(subordinateDto.getId().toString(), "Id is required to update a Subordinate");
        Assert.hasText(subordinateDto.getSupervisorId().toString(), "Subordinate Id is required");
        Assert.hasText(subordinateDto.getTeam(), "Team is required");
        Assert.hasText(subordinateDto.getFirstName(), "FirstName is required");
        Assert.hasText(subordinateDto.getLastName(), "LastName is required");
        Assert.hasText(subordinateDto.getEmployeeId().toString(), "EmployeeId is required");

        Optional<Subordinates> subordinatesOptional = subordicateService.findById(subordinateDto.getId());
        subordinatesOptional.orElseThrow(() ->
                new ApiException(String.format("Subordinate with this id not found", subordinateDto.getId())));

        Subordinates subordinates = subordinatesOptional.get();
        subordinates.setTeam(subordinateDto.getTeam());
        subordinates.setEmployeeId(subordinates.getEmployeeId());
        subordinates.setLastName(subordinates.getFirstName());
        subordinates.setId(subordinates.getId());
        subordinates.setSupervisorId(subordinates.getSupervisorId());
        subordinates.setLast_modified_by("Admin");
        subordinates.setLast_modified_date(new Date());

        Subordinates newSubordinate = subordicateService.saveOrUpdate(subordinates);

        ResponsePojo<Subordinates> responsePojo = new ResponsePojo<>();
        responsePojo.setData(newSubordinate);
        responsePojo.setMessage("Subordinate Updated Successfully");

        return responsePojo;

    }

    public ResponsePojo<Subordinates> getSubordinateById(Long id){

        Optional<Subordinates> subordinatesOptional = subordicateService.findById(id);
        subordinatesOptional.orElseThrow(() ->
                new ApiException(String.format("Subordinate with this id not found", id)));

        ResponsePojo<Subordinates> responsePojo = new ResponsePojo<>();
        responsePojo.setData(subordinatesOptional.get());
        responsePojo.setMessage("Subordinate List Fetched Successfully");

        return responsePojo;
    }

    public ResponsePojo<List<Subordinates>> fetchAllSubordinates(Pageable pageable){

        QSubordinates qSubordinates = QSubordinates.subordinates;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<Subordinates> jpaQuery = jpaQueryFactory.selectFrom(qSubordinates)
                .offset(pageable.getPageNumber())
                .limit(pageable.getPageSize());

        ResponsePojo<List<Subordinates>> responsePojo = new ResponsePojo<>();
        responsePojo.setData(jpaQuery.fetch());
        responsePojo.setMessage("Subordinates List Fetched Successfully");

        return responsePojo;
    }

}
