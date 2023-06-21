package com.library.repository;

import com.library.domain.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Override
    Optional<Copy> findById(Long id);

    @Override
    List<Copy> findAll();

    @Override
    Copy save(Copy copy);

    @Override
    void deleteById(Long id);
}