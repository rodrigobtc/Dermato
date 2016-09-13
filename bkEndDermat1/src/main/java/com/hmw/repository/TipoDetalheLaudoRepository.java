package com.hmw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hmw.model.TipoDetalheLaudo;

@Repository
public interface TipoDetalheLaudoRepository extends JpaRepository<TipoDetalheLaudo, Integer> {
	
	@Query("SELECT tdl FROM TipoDetalheLaudo tdl")
	List<TipoDetalheLaudo> getLaudoPorTipo(String tipoLaudo);
}
