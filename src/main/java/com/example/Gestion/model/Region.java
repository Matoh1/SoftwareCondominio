package com.example.Gestion.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Region_ID")
    private Integer Region_ID;

    @NotBlank(message = "La Region es obligatoria")
    @Size(min = 5, max = 50, message = "La Region debe tener al menos 5 caracteres")
    @Column(nullable = false, length = 50)
    private String Nombre_Region;

    @OneToMany(mappedBy = "region")
    private List<Comuna> comunas;
}
