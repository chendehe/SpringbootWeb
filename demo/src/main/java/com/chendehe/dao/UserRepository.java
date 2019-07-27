package com.chendehe.dao;

import com.chendehe.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findAll(Pageable page);

    UserEntity findById(String id);

}