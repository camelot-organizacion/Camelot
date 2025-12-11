package com.example.clientes_venta.Clientes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Usamos Integer porque así lo pusiste en el Repo

    private String name;
    private String email;

    // Constructor vacío (obligatorio para Spring)
    public Cliente() {
    }

    // Constructor con datos (útil para el DataLoader)
    public Cliente(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}