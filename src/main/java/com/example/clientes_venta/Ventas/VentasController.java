package com.example.clientes_venta.Ventas;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ventas")
public class VentasController {

    private final VentasService ventasService;
    public VentasController(VentasService ventasService){
        this.ventasService = ventasService;
    }

    @GetMapping
    public String listaVentas(Model model){

        List<Ventas> ventas = ventasService.listaVentas();

        model.addAttribute("ventas", ventas);


        return "ventas";
    }   
}
