package com.example.clientes_venta.Clientes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Clientes {

    @GetMapping("/clientes")
    public String clientes(){
        return "clientes";
    }

}
