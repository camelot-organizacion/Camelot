package com.example.clientes_venta.Compras;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/compras")
public class ComprasController {

    private final ComprasService comprasService;

    public ComprasController(ComprasService comprasService) {
        this.comprasService = comprasService;
    }

    @GetMapping
    public String listaCompras(Model model) {

        List<Compras> compras = comprasService.listaCompras();

        model.addAttribute("listaCompras", compras);

        // ⭐⭐ ESTO ACTIVA EL BOTÓN "Mis compras" EN EL SIDEBAR
        model.addAttribute("paginaActual", "compras");

        return "compras"; // debe coincidir con compras.html
    }
}