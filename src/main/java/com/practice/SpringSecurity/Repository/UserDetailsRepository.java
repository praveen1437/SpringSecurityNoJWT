package com.practice.SpringSecurity.Repository;

import com.practice.SpringSecurity.Entity.Users;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.PostConstruct;

public interface UserDetailsRepository extends CrudRepository<Users,Long> {

    Users findByUserName(String username);
}
