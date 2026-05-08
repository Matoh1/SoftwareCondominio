package com.example.Gestion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Espacios")

public class Espacios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "espacios_ID")
    private Integer espacios_ID;

    @ManyToOne
    @JoinColumn(name = "Espacio_ID", nullable = false)
    private Espacio espacio;

    @ManyToOne
    @JoinColumn(name = "Residencia_ID", nullable = false)
    private Residencias residencia;
}
