package com.example.Gestion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestion.model.Residencias;

@Repository
public interface ResidenciasRepository extends JpaRepository<Residencias, Integer>{
    Optional<Residencias> findByResidenciaIdAndUserId(Integer residenciaId, Integer userId);

}
