package com.controlis.salus.repositories;

import com.controlis.salus.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
