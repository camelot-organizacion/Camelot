package com.example.clientes_venta.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Asumo que el ID de tu Cliente es Integer, igual que en Producto.
// Si en tu archivo Cliente.java el ID es Long, cambia Integer por Long.
@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
    
    // Aquí puedes agregar métodos extra si los necesitas en el futuro, por ejemplo:
    // Cliente findByName(String name);
}