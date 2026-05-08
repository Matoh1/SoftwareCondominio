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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_ID")
    private Integer User_ID;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 40, message = "El nombre debe contener entre 3 y 50 caracteres")
    @Column(nullable = false, length = 100)
    private String Nombre;

    @Size(min = 2, max = 50, message = "El apellido debe contener entre 2 y 50 caracteres")
    @Column(nullable = false, length = 100)
    private String Apellido;

    @NotBlank(message = "Se requere el rut")
    @Size(min = 9, max = 11, message = "El rut es obligatorio")
    @Column(nullable = false, length = 30)
    private String Rut;

    @Size(min = 13, max = 45, message = "La direccion de correo electronico debe contener entre 12 y 45 caracteres")
    private String Email;

    @Size(min = 10, max = 13, message = "El numero de telefono debe contener entre 10 y 13 caracteres, incluyendo el identificador '+' y el/los numero(s)")
    private String Telefono;

    @OneToMany(mappedBy = "user")
    private List<Residencias> residencias;
}

    