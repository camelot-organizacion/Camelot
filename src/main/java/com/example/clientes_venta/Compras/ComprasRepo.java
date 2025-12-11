package com.example.clientes_venta.Compras;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepo extends JpaRepository<Compras, Long>{
    public Compras findById(long id);
    
}
