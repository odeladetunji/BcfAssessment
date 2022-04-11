package com.repository;

import com.entity.Subordinates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubordinateRepository extends CrudRepository<Subordinates, Long> {
    Optional<Subordinates> findById(Long id);
    Subordinates save(Subordinates subordinates);
}
