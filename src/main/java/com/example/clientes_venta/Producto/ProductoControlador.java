package com.example.clientes_venta.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    private ProductoService productoService;

    // LISTAR
    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "productos";   // nombre de tu plantilla productos.html
    }

    // FORM NUEVO
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("esEdicion", false);
        return "nuevo_producto";
    }

    // FORM EDITAR
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de producto inválido: " + id));

        model.addAttribute("producto", producto);
        model.addAttribute("esEdicion", true);
        return "nuevo_producto";   // mismo HTML
    }

    // GUARDAR (crear + actualizar)
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardarProducto(producto);  // si tiene id, actualiza
        return "redirect:/productos";
    }

}
