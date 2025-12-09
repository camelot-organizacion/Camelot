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

@Controller
@RequestMapping("/ventas")
public class VentasController {

    private final VentasService ventasService;

    @Autowired // Agregamos Autowired para que Spring inyecte el servicio correctamente
    public VentasController(VentasService ventasService){
        this.ventasService = ventasService;
    }

    @GetMapping
    public String listarVentas(Model model){
        
        // Usamos getAllVentas() para traer la lista desde el servicio
        List<Ventas> ventas = ventasService.getAllVentas();

        // Enviamos la lista al HTML con el nombre "ventas"
        model.addAttribute("ventas", ventas);

        return "ventas"; // Busca ventas.html
    }   

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