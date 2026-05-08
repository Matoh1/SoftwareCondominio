package com.example.Gestion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Gestion.DTO.ComunaDTO;
import com.example.Gestion.model.Comuna;
import com.example.Gestion.model.Residencia;
import com.example.Gestion.repository.ComunaRepository;
import com.example.Gestion.repository.ResidenciaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ComunaService {

    private final ComunaRepository comunaRepository;
    private final ResidenciaRepository residenciaRepository; 

    public List<ComunaDTO> obtenerTodos() {
        return comunaRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public ComunaDTO buscarporID(Integer id) {
        Comuna comuna = comunaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comuna no encontrada con ID " + id));
        return convertirADTO(comuna);
    }


    public Comuna guardarComuna(Comuna comuna) {
        return comunaRepository.save(comuna);
    }
    
    public String añadirResidenciaAComuna(Integer comunaId, Integer residenciaId) {
        Comuna comuna = comunaRepository.findById(comunaId)
                .orElseThrow(() -> new RuntimeException("Comuna no encontrada con ID " + comunaId));
        Residencia residencia = residenciaRepository.findById(residenciaId)
                .orElseThrow(() -> new RuntimeException("Residencia no encontrada con ID " + residenciaId));
        residencia.setComuna(comuna);
        residenciaRepository.save(residencia);

        return "Residencia añadida a la comuna exitosamente";
    }

    public String eliminarResidenciaDeComuna(Integer comunaId, Integer residenciaId) {
        Residencia residencia = residenciaRepository.findById(residenciaId)
                .orElseThrow(() -> new RuntimeException("La residencia no existe."));
        if (residencia.getComuna() != null && residencia.getComuna().getComuna_ID().equals(comunaId)) {
            residencia.setComuna(null);
            residenciaRepository.save(residencia);
            return "La residencia ha sido eliminada de la comuna exitosamente.";
        }
        return "Error: La residencia no pertenece a esa comuna, no puedes eliminarla.";
    }

    private ComunaDTO convertirADTO(Comuna comuna) {
        ComunaDTO dto = new ComunaDTO();
        dto.setId(comuna.getComuna_ID());
        dto.setNombre(comuna.getNombre_Comuna());

        if (comuna.getRegion() != null) {
            dto.setRegionId(comuna.getRegion().getRegion_ID());
            dto.setNombreRegion(comuna.getRegion().getNombre_Region());
        }

        // Mapeo corregido: Extrae nombres de la lista de residencias
        if (comuna.getResidencias() != null) {
            List<String> nombresResidencias = comuna.getResidencias().stream()
                    .map(Residencia::getNombre_Residencia)
                    .collect(Collectors.toList());
            dto.setResidencia(nombresResidencias);
        } else {
            dto.setResidencia(new ArrayList<>());
        }

        return dto;
    }
}