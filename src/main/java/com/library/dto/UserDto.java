package com.library.dto;

import com.library.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private LocalDate creationDate;
    private UserStatus userStatus;

    public UserDto(String firstName, String lastName, LocalDate creationDate, UserStatus userStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = creationDate;
        this.userStatus = userStatus;
    }
}
