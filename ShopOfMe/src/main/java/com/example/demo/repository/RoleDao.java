package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Role;

public interface RoleDao extends JpaRepository<Role, String>{

}
