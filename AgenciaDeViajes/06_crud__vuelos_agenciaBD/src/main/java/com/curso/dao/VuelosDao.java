package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Vuelo;

public interface VuelosDao extends JpaRepository<Vuelo, Integer> {

}
