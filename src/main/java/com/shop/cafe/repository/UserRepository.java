package com.shop.cafe.repository;

import com.shop.cafe.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmailId(@Param("email") String email);
}
