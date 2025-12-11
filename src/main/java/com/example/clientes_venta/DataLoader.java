package com.example.clientes_venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

// Imports de entidades
import com.example.clientes_venta.Producto.Producto;
import com.example.clientes_venta.Clientes.Cliente;
import com.example.clientes_venta.Ventas.Ventas;
import com.example.clientes_venta.Ventas.Estado;
import com.example.clientes_venta.Compras.Compras;

// Imports de repositorios
import com.example.clientes_venta.Producto.ProductoRepo;
import com.example.clientes_venta.Clientes.ClienteRepo;
import com.example.clientes_venta.Ventas.VentasRepo;
import com.example.clientes_venta.Compras.ComprasRepo;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepo productoRepo;
    private final ClienteRepo clienteRepo;
    private final VentasRepo ventasRepo;
    private final ComprasRepo comprasRepo;

    @Autowired
    public DataLoader(ProductoRepo productoRepo, 
                      ClienteRepo clienteRepo,
                      VentasRepo ventasRepo,
                      ComprasRepo comprasRepo) {
        this.productoRepo = productoRepo;
        this.clienteRepo = clienteRepo;
        this.ventasRepo = ventasRepo;
        this.comprasRepo = comprasRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- DATALOADER INICIADO ---");

        // 1. CARGAR VENTAS (Sin @GeneratedValue -> ID Manual obligatorio)
        if (ventasRepo.count() == 0) {
            Ventas v1 = Ventas.builder()
                .id(1) 
                .cantidad(5)
                .fecha("2025-12-11")
                .estado(Estado.COMPLETADA)
                .build();
            ventasRepo.save(v1);
            System.out.println("- Venta creada manualmente.");
        }

        // 2. CARGAR COMPRAS (Sin @GeneratedValue -> ID Manual obligatorio)
        if (comprasRepo.count() == 0) {
            Compras c1 = Compras.builder()
                .id(1)
                .cantidad(100)
                .fecha("2025-10-20")
                .build();
            comprasRepo.save(c1);
            System.out.println("- Compra creada manualmente.");
        }

        // 3. CARGAR PRODUCTOS (Sin @GeneratedValue -> ID Manual obligatorio)
        if (productoRepo.count() == 0) {
            Producto p1 = new Producto();
            p1.setId(1);
            p1.setName("Monitor 24 pulgadas");
            p1.setCategoria("Monitores");
            p1.setPrecio(1200.00f); 
            p1.setStock(15);
            productoRepo.save(p1);
            System.out.println("- Producto creado manualmente.");
        }

        // 4. CARGAR CLIENTES (CON @GeneratedValue -> PROHIBIDO poner ID Manual)
        if (clienteRepo.count() == 0) {
            Cliente cliente = new Cliente();
            // ¡AQUÍ NO PONEMOS setId! Dejamos que la base de datos lo ponga.
            
            cliente.setName("Cliente Prueba");
            cliente.setEmail("cliente@prueba.com");
            
            clienteRepo.save(cliente);
            System.out.println("- Cliente creado exitosamente (ID automático).");
        }

        System.out.println("--- CARGA FINALIZADA EXITOSAMENTE ---");
    }
}