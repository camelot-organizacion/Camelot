package com.example.clientes_venta.Ventas;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/ventas")
public class VentasController {

    private final VentasService ventasService;

    @Autowired
    public VentasController(VentasService ventasService){
        this.ventasService = ventasService;
    }

    @GetMapping
    public String listarVentas(Model model, Authentication auth){
        
        // 1. TU CÓDIGO: Traemos la lista usando tu método getAllVentas()
        List<Ventas> ventas = ventasService.getAllVentas();
        model.addAttribute("ventas", ventas);

        // 2. CÓDIGO DEL MASTER: Agregamos lógica para el sidebar y usuario
        // Esto ayuda a que se ilumine la opción "Ventas" en el menú
        model.addAttribute("paginaActual", "ventas");

        // Esto pone el nombre del usuario real en la esquina
        if (auth != null) {
            model.addAttribute("nombre", auth.getName());
        }

        return "ventas";
    }    

    // 3. TU CÓDIGO: Mantenemos la función de Excel que creaste
    @GetMapping("/exportar-excel")
    public ResponseEntity<InputStreamResource> exportarExcel() throws IOException {
        ByteArrayInputStream in = ventasService.generarExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=ventas_camelot.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(in));
    }
}