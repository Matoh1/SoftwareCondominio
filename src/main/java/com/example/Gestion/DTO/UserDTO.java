package com.example.Gestion.DTO;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private Integer User_ID;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String Nombre;
    @NotBlank(message = "El apellido no puede estar vacío")
    private String Apellido;
    private String Rut;
    @Email(message = "Formato de email inválido")
    private String Email;
    private String Telefono;
    private List<String> residencias;

}
