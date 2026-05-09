package com.example.Gestion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Gestion.DTO.ResidenciaDTO;
import com.example.Gestion.model.Residencia;
import com.example.Gestion.repository.ResidenciaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ResidenciaService {

    private final ResidenciaRepository residenciaRepository;

    public List<ResidenciaDTO> obtenerTodos() {
        return residenciaRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public ResidenciaDTO buscarporID(Integer id) {
        Residencia residencia = residenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Residencia no encontrada con ID " + id));
        return convertirADTO(residencia);
    }

    public Residencia guardarResidencia(Residencia residencia) {
        return residenciaRepository.save(residencia);
    }

    public String eliminar(Integer id) {
        try {
            Residencia residencia = residenciaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Residencia no encontrada con ID " + id));
            residenciaRepository.delete(residencia);
            return "Residencia'" + residencia.getNombreresidencia() + "' eliminada exitosamente.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Residencia actualizarResidencia(Integer id, Residencia Aresidencia) {
        Residencia resi = residenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Residencia no encontrada con ID " + id));
        if (Aresidencia.getNombreresidencia() != null) {
            resi.setNombreresidencia(Aresidencia.getNombreresidencia());
        }
        if (Aresidencia.getDireccion() != null) {
            resi.setDireccion(Aresidencia.getDireccion());
        }
        return residenciaRepository.save(resi);
    }

    private ResidenciaDTO convertirADTO(Residencia residencia) {
        ResidenciaDTO dto = new ResidenciaDTO();
        dto.setId(residencia.getId());
        dto.setNombre(residencia.getNombreresidencia());
        dto.setDireccion(residencia.getDireccion());

        // Mapeo de los datos de la Comuna relacionada a la residencia
        if (residencia.getComuna() != null) {
            dto.setComunaId(residencia.getComuna().getId());
            dto.setNombreComuna(residencia.getComuna().getNombrecomuna());
        }
        return dto;
    }

}
