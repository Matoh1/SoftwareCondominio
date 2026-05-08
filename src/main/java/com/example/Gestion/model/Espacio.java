package com.example.Gestion.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Espacio")
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "espacio_ID")
    private Integer espacio_ID;

    @NotBlank(message = "El nombre del lugar es obligatorio")
    @Size(min = 5, max = 40, message = "El nombre del lugar debe contener entre 5 y 40 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre_lugar;

    @NotBlank(message = "El tipo de espacio es obligatorio")
    @Size(min = 3, max = 30, message = "El tipo de espacio debe contener entre 3 y 30 caracteres")
    @Column(nullable = false, length = 100)
    private String tipo_espacio;

    @NotNull(message = "La capacidad es obligatoria")
    @Min(value = 1, message = "La capacidad mínima es 1")
    @Max(value = 150, message = "La capacidad máxima de seres humanos es de 150")
    @Column(nullable = false, length = 50)
    private Integer capacidad;

    @OneToMany(mappedBy = "espacio")
    private List<Espacios> espacios;

}