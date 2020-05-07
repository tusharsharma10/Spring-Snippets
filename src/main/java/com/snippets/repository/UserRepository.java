package com.snippets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snippets.entity.User;

public interface UserRepository extends JpaRepository<User,Long>  {

	User findByUsername(String username);
}
