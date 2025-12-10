package com.example.clientes_venta;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.clientes_venta.Ventas.Ventas;
import com.example.clientes_venta.Ventas.VentasRepo;
// 1. IMPORTANTE: Importamos las clases de Compras
import com.example.clientes_venta.Compras.Compras;
import com.example.clientes_venta.Compras.ComprasRepo;

@Component
public class DataLoader implements CommandLineRunner {

    private final VentasRepo ventasRepo;
    private final ComprasRepo comprasRepo; // 2. Añadimos el repositorio de compras

    // 3. Inyectamos ambos repositorios en el constructor
    public DataLoader(VentasRepo ventasRepo, ComprasRepo comprasRepo) {
        this.ventasRepo = ventasRepo;
        this.comprasRepo = comprasRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        
        // --- PARTE 1: CARGAR VENTAS (Lo que ya tenías) ---
        if (ventasRepo.count() == 0) {
            List<Ventas> datosVentas = List.of(
                Ventas.builder().clienteNombre("Sherman Blankenship").estatus("Pendiente").total(217.90).fecha(LocalDate.of(2025, 1, 8)).build(),
                Ventas.builder().clienteNombre("Claudio Barrera").estatus("Completado").total(329.90).fecha(LocalDate.of(2025, 1, 6)).build(),
                Ventas.builder().clienteNombre("Clifton Daniel").estatus("Completado").total(-549.90).fecha(LocalDate.of(2025, 1, 3)).build(),
                Ventas.builder().clienteNombre("Curt Boyer").estatus("Completado").total(-238.90).fecha(LocalDate.of(2025, 1, 1)).build(),
                Ventas.builder().clienteNombre("Jeff Proctor").estatus("Completado").total(-283.90).fecha(LocalDate.of(2024, 12, 31)).build(),
                Ventas.builder().clienteNombre("Rodger Fritz").estatus("Completado").total(237.90).fecha(LocalDate.of(2024, 12, 24)).build()
            );
            ventasRepo.saveAll(datosVentas);
        }

        // --- PARTE 2: CARGAR COMPRAS ---
        if (comprasRepo.count() == 0) {
            List<Compras> datosCompras = List.of(
                Compras.builder()
                    .producto("Combo Hamburguesa Doble")
                    .cantidad(2) // Cantidad cualquiera
                    .estatus("Entregado")
                    .total(180.00)
                    .fecha(LocalDate.of(2025, 1, 10))
                    .build(),

                Compras.builder()
                    .producto("Refresco Grande (Cola)")
                    .cantidad(4) // Cantidad cualquiera
                    .estatus("En camino")
                    .total(102.00)
                    .fecha(LocalDate.of(2025, 1, 10))
                    .build(),

                Compras.builder()
                    .producto("Nachos con Queso")
                    .cantidad(1) // Cantidad cualquiera
                    .estatus("Entregado")
                    .total(45.00)
                    .fecha(LocalDate.of(2025, 1, 5))
                    .build(),
                    
                Compras.builder()
                    .producto("Malteada de Fresa")
                    .cantidad(3) // Cantidad cualquiera
                    .estatus("Cancelado")
                    .total(135.00)
                    .fecha(LocalDate.of(2024, 12, 28))
                    .build()
            );
            comprasRepo.saveAll(datosCompras);
        }
    }
}