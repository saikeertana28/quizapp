package com.security.repository;

import com.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
    @Query("SELECT u.id FROM Users u WHERE u.email = :email")
    Long findStudentIdByEmail(@Param("email") String email);
    @Query("SELECT u.username FROM Users u WHERE u.email = :email")
    String findUsernameByEmail(@Param("email") String email);

}
