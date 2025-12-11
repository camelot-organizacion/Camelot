package com.example.clientes_venta.Ventas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepo extends JpaRepository<Ventas, Integer>{ // <- CAMBIO AQUÍ
    public Ventas findById(int id); // <- CAMBIO AQUÍ
}