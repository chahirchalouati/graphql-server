package com.crcl.graphqlserver.dto;

import com.crcl.graphqlserver.domain.Education;
import com.crcl.graphqlserver.domain.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class MutateUserRequest {
    private String username;
    private String email;
    private String birthDate;
    private String firstName;
    private String lastName;
    private boolean isActive = false;
    private String address;
    private String phoneNumber;
    private String occupation;
    private Education education;
    private List<String> hobbies = new ArrayList<>();

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setBirthDate(LocalDate.parse(birthDate)); // Parse string to LocalDate
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setActive(isActive);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        user.setOccupation(occupation);
        user.setEducation(education);
        user.setHobbies(hobbies);

        return user;
    }
}
