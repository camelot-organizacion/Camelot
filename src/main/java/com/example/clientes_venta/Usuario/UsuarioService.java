package com.example.clientes_venta.Usuario;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService implements UserDetailsService{

    private final UsuarioRepo usuarioRepo;
    
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
        Optional <Usuario> user = usuarioRepo.findByName(name);

        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder().username(userObj.getUsername()).password(userObj.getPassword())
            .build();
        }
        else{
            throw new UsernameNotFoundException(name);
        }
    }

    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo){
        this.usuarioRepo=usuarioRepo;
    }

    public List<Usuario> getUsuarios(){ 
        return usuarioRepo.findAll();
    }
    
}
