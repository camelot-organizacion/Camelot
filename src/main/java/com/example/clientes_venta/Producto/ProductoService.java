package com.example.clientes_venta.Producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepositorio;

    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepositorio.findById(id);
    }

    public void guardarProducto(Producto producto) {
        productoRepositorio.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }
}
