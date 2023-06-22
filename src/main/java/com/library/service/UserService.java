package com.library.service;

import com.library.domain.User;
import com.library.exception.UserNotFoundException;
import com.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User user)  {
        if(userRepository.findById(id).isPresent()) {
            User userModificated = userRepository.findById(id).get();
            userModificated.setFirstName(user.getFirstName());
            userModificated.setLastName(user.getLastName());
            userModificated.setCreationDate(user.getCreationDate());
//            userModificated.setUserStatus(user.getUserStatus());
            userRepository.save(userModificated);
        } else {
            throw new UserNotFoundException();
        }
    }

    public void deleteUser(Long id)  {
        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException();
        }
    }
}
