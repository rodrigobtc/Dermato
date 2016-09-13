package com.hmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmw.model.Laudo;

@Repository
public interface LaudoRepository extends JpaRepository<Laudo, Long> {

}
