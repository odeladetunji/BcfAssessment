package com.Interface;

import com.entity.Supervisors;

import java.util.Optional;

public interface SupervisorsImpl {

    Optional<Supervisors> findById(Long id);
    Supervisors saveOrUpdate(Supervisors supervisors);

}
