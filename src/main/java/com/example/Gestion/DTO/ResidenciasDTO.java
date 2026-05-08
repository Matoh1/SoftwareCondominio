package com.example.Gestion.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ResidenciasDTO {

    private Integer userId;
    private Integer residenciaId;
    @NotBlank(message = "El nombre del usuario no puede estar vacío")
    private String nombreUsuario;
    @NotBlank(message = "El nombre de la residencia no puede estar vacío")
    private String nombreResidencia;

}
