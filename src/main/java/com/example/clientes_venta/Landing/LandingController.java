package com.example.clientes_venta.Landing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LandingPage")
public class LandingController {

    public String landingPage(){
        return "LandingPage";
    }
}
