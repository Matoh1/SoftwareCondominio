package com.example.Gestion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Gestion.DTO.RegionDTO;
import com.example.Gestion.model.Comuna;
import com.example.Gestion.model.Region;
import com.example.Gestion.repository.ComunaRepository;
import com.example.Gestion.repository.RegionRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RegionService {

    private final RegionRepository regionRepository;
    private final ComunaRepository comunaRepository;

    public List<RegionDTO> obtenerTodos() {
        return regionRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public RegionDTO buscarporID(Integer id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Región no encontrada con ID " + id));
        return convertirADTO(region);
    }

    public Region guardarRegion(Region region) {
        return regionRepository.save(region);
    }

    public String añadirComunaARegion(Integer regionId, Integer comunaId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("Región no encontrada con ID " + regionId));
        Comuna comuna = comunaRepository.findById(comunaId)
                .orElseThrow(() -> new RuntimeException("Comuna no encontrada con ID " + comunaId));
        comuna.setRegion(region);
        comunaRepository.save(comuna);
        return "Comuna añadida a la región exitosamente";
    }

    private RegionDTO convertirADTO(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setId(region.getRegion_ID());
        dto.setNombre(region.getNombre_Region());

        // Mapeo de los nombres de las comunas relacionadas a la región
        List<String> nombresComunas = new ArrayList<>();
        if (region.getComunas() != null) {
            nombresComunas = region.getComunas().stream().map(Comuna::getNombre_Comuna).toList();
        }
        dto.setComunas(nombresComunas);
        return dto;
    }
}
