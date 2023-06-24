package com.library.repository;

import com.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    Optional<User> findById(Long userId);

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    void deleteById(Long userId);

}
