package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Authority;

public interface AuthorityService {

	List<Authority> findAll();

	List<Authority> findAuthoritiesOfAdministrators();

	Authority create(Authority auth);

	void delete(Integer id);

}
