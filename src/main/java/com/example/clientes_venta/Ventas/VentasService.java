package com.example.clientes_venta.Ventas;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VentasService {
    
    private final VentasRepo ventasRepo;

    public VentasService(VentasRepo ventasRepo) {
        this.ventasRepo = ventasRepo;
    }


    public List<Ventas> listaVentas(){
        return ventasRepo.findAll();
    }

}
