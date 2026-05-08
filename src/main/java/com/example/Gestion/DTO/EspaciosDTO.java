package com.example.Gestion.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EspaciosDTO {
    private Integer Espacio_ID;
    private Integer Residencia_ID;
}
