package com.crcl.graphqlserver.controllers;

import com.crcl.graphqlserver.domain.User;
import com.crcl.graphqlserver.dto.MutateUserRequest;
import com.crcl.graphqlserver.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @QueryMapping(value = "findById")
    public User findById(@Argument String id) {
        return userService.findById(id);
    }

    @QueryMapping(value = "users")
    public List<User> users() {
        return userService.readAll();
    }

    @MutationMapping(value = "createUser")
    public User create(@Argument(value = "mutateUserRequest") MutateUserRequest mutateUserRequest) {
        return userService.create(mutateUserRequest.toUser());
    }

    @MutationMapping(value = "updateUser")
    public User update(@Argument(value = "mutateUserRequest") MutateUserRequest mutateUserRequest,
                       @Argument(value = "id") String id) {
        if (Objects.nonNull(userService.findById(id)))
            return userService.update(mutateUserRequest.toUser());
        return null;
    }

    @MutationMapping(value = "deleteUser")
    public String create(@Argument(value = "id") String id) {
        userService.delete(id);
        return id;
    }
}