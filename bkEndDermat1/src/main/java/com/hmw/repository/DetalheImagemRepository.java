package com.hmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmw.model.DetalheImagem;

@Repository
public interface DetalheImagemRepository extends JpaRepository<DetalheImagem, Long> {

}
