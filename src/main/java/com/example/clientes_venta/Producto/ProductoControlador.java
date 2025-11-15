package com.example.clientes_venta.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {
    private final ProductoService productoService;


    @Autowired
    public ProductoControlador(ProductoService productoService){
        this.productoService=productoService;
    }

    @GetMapping
    public List<Producto> getProductos(
        @RequestParam(required=false) String name,
        @RequestParam(required=false) String categoria        
        )
    {
        if(categoria != null) {
            return productoService.getProductoCategoria(categoria);
        }
        else if(name != null){
            return productoService.getProductoNombre(name);
        }
        else{
            return productoService.getProductos();
        }
    }    

}
