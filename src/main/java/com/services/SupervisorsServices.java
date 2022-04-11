package com.services;

import com.Interface.SupervisorsImpl;
import com.entity.Supervisors;
import com.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupervisorsServices implements SupervisorsImpl {

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Override
    public Optional<Supervisors> findById(Long id){
        return supervisorRepository.findById(id);
    }

    @Override
    public Supervisors saveOrUpdate(Supervisors supervisors){
        return supervisorRepository.save(supervisors);
    }

}
