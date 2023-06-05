package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;

public interface HotelesDao extends JpaRepository<Hotel, Integer> {

}
