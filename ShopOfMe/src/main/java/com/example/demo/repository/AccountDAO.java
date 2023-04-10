package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String>{

	
	@Query("SELECT DISTINCT a.account FROM Authority a WHERE a.role.id IN ('DIRE', 'STAF')")
	List<Account> getAdministrators();



}
