package com.repository;

import com.entity.Supervisors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupervisorRepository extends CrudRepository<Supervisors, Long> {

    Optional<Supervisors> findById(Long id);
    Supervisors save(Supervisors supervisors);

}
