package com.crcl.graphqlserver.services;

import com.crcl.graphqlserver.domain.User;
import com.crcl.graphqlserver.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService extends GenericCrudService<User, String> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
