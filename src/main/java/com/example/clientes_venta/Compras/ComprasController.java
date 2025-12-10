package com.example.clientes_venta.Compras;

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
import org.springframework.security.core.Authentication; // Importante para el nombre de usuario

@Controller
@RequestMapping("/compras")
public class ComprasController {

    private final ComprasService comprasService;

    @Autowired // Buena práctica ponerlo
    public ComprasController(ComprasService comprasService) {
        this.comprasService = comprasService;
    }

    @GetMapping
    public String listarCompras(Model model, Authentication auth) {

        // 1. Usamos el método correcto del servicio (asegúrate que en Service se llame así)
        List<Compras> compras = comprasService.getAllCompras(); 

        // 2. CORRECCIÓN: El nombre del atributo debe ser "compras" para coincidir con el HTML
        model.addAttribute("compras", compras);

        // 3. Activamos el botón del sidebar
        model.addAttribute("paginaActual", "compras");

        // 4. Pasamos el nombre del usuario logueado (como en Ventas)
        if (auth != null) {
            model.addAttribute("nombre", auth.getName());
        }

        return "compras"; // Retorna compras.html
    }

    // 5. AGREGADO: La función para descargar el Excel
    @GetMapping("/exportar-excel")
    public ResponseEntity<InputStreamResource> exportarExcel() throws IOException {
        ByteArrayInputStream in = comprasService.generarExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=compras_camelot.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(in));
    }
}