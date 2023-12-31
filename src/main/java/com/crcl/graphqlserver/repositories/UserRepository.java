package com.crcl.graphqlserver.repositories;

import com.crcl.graphqlserver.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
