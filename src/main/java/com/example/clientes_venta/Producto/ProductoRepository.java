package com.example.clientes_venta.Producto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByName(String name);

    // si quieres varias por categoría:
    List<Producto> findByCategoria(String categoria);
}
