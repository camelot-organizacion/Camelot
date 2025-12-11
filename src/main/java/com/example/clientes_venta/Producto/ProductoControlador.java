package com.example.clientes_venta.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/productos")
public class ProductoControlador {
    private final ProductoService productoService;

    @Autowired
    public ProductoControlador(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public String productos(
        @RequestParam(required=false) String name,
        @RequestParam(required=false) String categoria,
        Model model){
        
        List<Producto> productos;
        
        if(categoria != null) {
            productos = productoService.getProductoCategoria(categoria);
        }
        else if(name != null){
            productos = productoService.getProductoNombre(name);
        }
        else{
            productos = productoService.getProductos();
        }
        
        model.addAttribute("productos", productos);
        return "productos";
    }

    // Este método muestra el formulario cuando entras a /productos/nuevo
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrear(Model model) {
        // Creamos un objeto vacío para rellenar
        Producto producto = new Producto(); 
        model.addAttribute("producto", producto);
        
        // Retornamos el nombre del archivo HTML que creamos en el Paso 1
        return "crear_producto"; 
    }
}
