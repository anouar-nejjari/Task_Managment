package com.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    static Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}