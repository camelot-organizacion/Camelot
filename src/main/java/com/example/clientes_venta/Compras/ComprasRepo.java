package com.example.clientes_venta.Compras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepo extends JpaRepository<Compras, Integer> {
}