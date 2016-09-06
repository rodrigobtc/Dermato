package com.hmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmw.model.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {

}
