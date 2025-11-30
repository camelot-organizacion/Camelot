package com.example.clientes_venta.Ventas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepo extends JpaRepository<Ventas, Long>{
    public Ventas findById(long id);
    
}
