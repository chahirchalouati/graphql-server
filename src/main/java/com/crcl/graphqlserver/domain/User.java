package com.crcl.graphqlserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private boolean isActive = false;
    private String address;
    private String phoneNumber;
    private String occupation;
    private Education education;
    private List<String> hobbies;

}