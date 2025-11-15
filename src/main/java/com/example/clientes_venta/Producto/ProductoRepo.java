package com.example.clientes_venta.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductoRepo extends JpaRepository<Producto, Long>{

    Optional<Producto> findByName(String name);

    Optional<Producto> findByCategoria(String categoria);

    
}