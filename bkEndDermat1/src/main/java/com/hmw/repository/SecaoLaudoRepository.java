package com.hmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmw.model.SecaoLaudo;

@Repository
public interface SecaoLaudoRepository extends JpaRepository<SecaoLaudo, Integer> {
	
}
