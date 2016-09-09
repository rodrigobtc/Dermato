package com.hmw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hmw.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	@Query("SELECT u FROM Paciente u WHERE u.nome LIKE CONCAT('%',UPPER(:nome),'%')")
	List<Paciente> procurarPaciente(@Param("nome") String nome);
}
