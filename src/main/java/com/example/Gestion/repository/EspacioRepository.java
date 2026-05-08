package com.example.Gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestion.model.Espacio;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Integer> {

}
