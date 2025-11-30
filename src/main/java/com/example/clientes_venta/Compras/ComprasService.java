package com.example.clientes_venta.Compras;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class ComprasService {
    private final ComprasRepo comprasRepo;

    public ComprasService(ComprasRepo comprasRepo) {
        this.comprasRepo = comprasRepo;
    }

    public List<Compras> listaCompras(){
        return comprasRepo.findAll();
    }
}
