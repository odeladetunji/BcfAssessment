package com.services;

import com.Interface.SubordinateImpl;
import com.entity.Subordinates;
import com.repository.SubordinateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubordicateService implements SubordinateImpl {

    @Autowired
    private SubordinateRepository subordinateRepository;

    public Optional<Subordinates> findById(Long id){
        return subordinateRepository.findById(id);
    }

    @Override
    public Subordinates saveOrUpdate(Subordinates subordinates){
        return subordinateRepository.save(subordinates);
    }

}
