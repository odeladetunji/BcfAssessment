package com.Interface;

import com.entity.Subordinates;

import java.util.Optional;

public interface SubordinateImpl {

    Optional<Subordinates> findById(Long id);
    Subordinates saveOrUpdate(Subordinates subordinates);

}
