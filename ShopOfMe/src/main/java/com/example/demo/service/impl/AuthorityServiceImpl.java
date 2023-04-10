package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Authority;
import com.example.demo.repository.AccountDAO;
import com.example.demo.repository.AuthorityDAO;
import com.example.demo.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	AccountDAO accountDAO;
	@Autowired
	AuthorityDAO authorityDAO;

	@Override
	public List<Authority> findAll() {
		return authorityDAO.findAll();
	}

	
	
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accountDAO.getAdministrators();
		return authorityDAO.authoritiesOf(accounts);
	}



	@Override
	public Authority create(Authority auth) {
		
		return authorityDAO.save(auth);
	}



	@Override
	public void delete(Integer id) {
		authorityDAO.deleteById(id);
		
	}
	
	
}
