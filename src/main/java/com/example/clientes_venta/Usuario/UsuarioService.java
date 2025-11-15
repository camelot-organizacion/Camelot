package com.example.clientes_venta.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {

    private final UsuarioRepo usuarioRepo;
    

    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo){
        this.usuarioRepo=usuarioRepo;
    }

    public List<Usuario> getUsuarios(){ 
        return usuarioRepo.findAll();
    }
    
}
