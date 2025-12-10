package com.example.clientes_venta.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.clientes_venta.Usuario.UsuarioRepo;
import com.example.clientes_venta.Usuario.Usuario;

import java.util.Optional;

@Controller
public class PerfilController {

    private final UsuarioRepo usuarioRepo;

    @Autowired
    public PerfilController(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    /**
     * Mapea la URL /perfil y carga la vista de configuración.
     * Inyecta los datos completos del usuario logueado en el modelo.
     */
    @GetMapping("/perfil")
    public String verPerfil(Model model, Authentication authentication) {
        
        // El email se obtiene del objeto Authentication (gracias a UsuarioService.loadUserByUsername)
        String email = authentication.getName();
        
        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);

        if (usuario.isPresent()) {
            // El objeto "usuarioActual" estará disponible en perfil.html
            model.addAttribute("usuarioActual", usuario.get());
        } else {
            // Manejar el caso si el usuario no es encontrado (aunque es improbable si está logueado)
            model.addAttribute("error", "Usuario no encontrado.");
        }
        
        // Retorna la vista HTML "perfil.html"
        return "perfil";
    }
}