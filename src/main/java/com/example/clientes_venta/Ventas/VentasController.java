package com.example.clientes_venta.Ventas;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/ventas")
public class VentasController {

    private final VentasService ventasService;

    public VentasController(VentasService ventasService){
        this.ventasService = ventasService;
    }

    @GetMapping   // ← atiende /ventas
    public String listarVentas(Model model, Authentication auth) {

        List<Ventas> ventas = ventasService.listaVentas();
        model.addAttribute("ventas", ventas);

        // para resaltar el botón "Mis ventas"
        model.addAttribute("paginaActual", "ventas");

        // opcional: nombre en el sidebar
        if (auth != null) {
            model.addAttribute("nombre", auth.getName());
        }

        return "ventas";
    }
}