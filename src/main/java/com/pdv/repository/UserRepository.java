package com.pdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdv.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
