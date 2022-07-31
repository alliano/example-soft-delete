package com.softdelete.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdelete.models.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
   
}
