package com.example.clientes_venta.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientes_venta.Usuario.Usuario;
import com.example.clientes_venta.Usuario.UsuarioRepo;

@RestController
public class RegistroController {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping(value = "req/signup", consumes = "aplication/json")
    public Usuario creaUsuario(@RequestBody Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepo.save(usuario);
    }

}
