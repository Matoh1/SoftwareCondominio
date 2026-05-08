package com.example.Gestion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Gestion.DTO.UserDTO;
import com.example.Gestion.model.User;
import com.example.Gestion.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> obtenerTodos() {
        return userRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }


    private UserDTO convertirADTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUser_ID(user.getUser_ID());
        dto.setNombre(user.getNombre());
        dto.setApellido(user.getApellido());
        dto.setRut(user.getRut());
        dto.setEmail(user.getEmail());
        dto.setTelefono(user.getTelefono());
        
        return dto;
    }
}
