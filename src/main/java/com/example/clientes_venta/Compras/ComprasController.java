package com.example.clientes_venta.Compras;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/compras")
public class ComprasController {

    private final ComprasService comprasService;

    public ComprasController(ComprasService comprasService) {
        this.comprasService = comprasService;
    }

    @GetMapping
    public String listaCompras(Model model, Authentication auth) {

        List<Compras> compras = comprasService.listaCompras();

        model.addAttribute("compras", compras);

        // ⭐⭐ ESTO ACTIVA EL BOTÓN "Mis compras" EN EL SIDEBAR
        model.addAttribute("paginaActual", "compras");

        // Esto pone el nombre del usuario real en la esquina
        if (auth != null) {
            model.addAttribute("nombre", auth.getName());
        }

        return "compras"; // debe coincidir con compras.html
    }
}