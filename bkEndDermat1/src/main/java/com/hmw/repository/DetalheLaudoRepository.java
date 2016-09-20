package com.hmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmw.model.DetalheLaudo;

@Repository
public interface DetalheLaudoRepository extends JpaRepository<DetalheLaudo, Long> {

}
