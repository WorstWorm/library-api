package com.library.repository;

import com.library.domain.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {

    @Override
    Optional<Borrowing> findById(Long id);

    @Override
    List<Borrowing> findAll();

    @Override
    Borrowing save(Borrowing borrowing);

    @Override
    void deleteById(Long id);
}