package com.example.Gestion.DTO;

import java.util.List;

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
    private String Nombre;
    private String Apellido;
    private String Rut;
    private String Email;
    private String Telefono;
    private List<String> residencias;

}
