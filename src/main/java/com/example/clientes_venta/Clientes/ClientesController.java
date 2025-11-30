package com.example.clientes_venta.Clientes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.clientes_venta.Usuario.UsuarioService;

@Controller
public class ClientesController {

    private final UsuarioService usuarioService;

    public ClientesController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    
    @GetMapping("/clientes")
    public String clientes(){
        return "clientes";
    }


    @GetMapping
    public String listaClientes(
        @RequestParam(required=false) String name, Model model
    )
    {
        model.addAttribute("name", name);
        return "clientes";
    }

}
