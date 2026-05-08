package com.example.Gestion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Gestion.DTO.EspacioDTO;
import com.example.Gestion.model.Espacio;
import com.example.Gestion.repository.EspacioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EspacioService {

    private final EspacioRepository espacioRepository;

    public List<EspacioDTO> obtenerTodos() {
        return espacioRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    private EspacioDTO convertirADTO(Espacio espacio) {
        EspacioDTO dto = new EspacioDTO();
        return dto;
    }

}