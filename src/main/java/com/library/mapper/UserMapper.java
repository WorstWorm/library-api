package com.library.mapper;

import com.library.domain.User;
import com.library.dto.UserDto;
import com.library.enums.UserStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUserId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getCreationDate()
//                userDto.getUserStatus().getStatus()
        );
    }

    public UserDto mapToUserDto(final Optional<User> user) {
        return new UserDto(
                user.get().getUserId(),
                user.get().getFirstName(),
                user.get().getLastName(),
                user.get().getCreationDate()
//                UserStatus.valueOf(user.get().getUserStatus())
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getCreationDate()
//                UserStatus.valueOf(user.getUserStatus())
        );
    }

    public List<User> mapToUserList(final List<UserDto> userDtoList) {
        return userDtoList.stream().map(this::mapToUser).collect(Collectors.toList());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream().map(this::mapToUserDto).collect(Collectors.toList());
    }
}
