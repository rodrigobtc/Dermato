package com.hmw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hmw.model.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {

	@Query(value = "select e.id, e.descricao from Exame e")
	List<Exame> getExames();
}
