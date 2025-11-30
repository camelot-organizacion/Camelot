package com.example.clientes_venta.Producto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component 
public class ProductoService {


    private final ProductoRepo productoRepo;

    @Autowired
    public ProductoService(ProductoRepo productoRepo){
        this.productoRepo=productoRepo;
    }


    public List<Producto> getProductos(){
        return productoRepo.findAll();
    }

    public List<Producto> getProductoCategoria(String categoria){
        return productoRepo.findAll().stream().filter(producto -> categoria.equals(producto.getCategoria()))
        .collect(Collectors.toList());
    }

    public List<Producto> getProductoNombre(String name){
        return productoRepo.findAll().stream().filter(producto -> name.equals(producto.getName()))
        .collect(Collectors.toList());
    }

}
