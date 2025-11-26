package com.example.clientes_venta.Compras;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComprasController {

    @GetMapping("/compras")
    public String compras(){
        return "compras";
    }
}
