package com.example.Gestion.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ComunaDTO {
    
    private Integer id;         
    private String nombre;        
    private Integer regionId;     
    private String nombreRegion;  
    private List<String> residencia;

}
