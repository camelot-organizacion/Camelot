package com.example.clientes_venta;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.clientes_venta.Ventas.Ventas;
import com.example.clientes_venta.Ventas.VentasRepo;

@Component
public class DataLoader implements CommandLineRunner {

    private final VentasRepo ventasRepo;

    public DataLoader(VentasRepo ventasRepo) {
        this.ventasRepo = ventasRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Solo llenamos la tabla si está vacía para no duplicar datos
        if (ventasRepo.count() == 0) {
            
            // Usamos .builder() gracias a Lombok (@Builder en Ventas.java)
            List<Ventas> datosFigma = List.of(
                Ventas.builder()
                    .clienteNombre("Sherman Blankenship")
                    .estatus("Pendiente")
                    .total(217.90)
                    .fecha(LocalDate.of(2025, 1, 8))
                    .build(),

                Ventas.builder()
                    .clienteNombre("Claudio Barrera")
                    .estatus("Completado")
                    .total(329.90)
                    .fecha(LocalDate.of(2025, 1, 6))
                    .build(),

                Ventas.builder()
                    .clienteNombre("Clifton Daniel")
                    .estatus("Completado")
                    .total(-549.90)
                    .fecha(LocalDate.of(2025, 1, 3))
                    .build(),

                Ventas.builder()
                    .clienteNombre("Curt Boyer")
                    .estatus("Completado")
                    .total(-238.90)
                    .fecha(LocalDate.of(2025, 1, 1))
                    .build(),

                Ventas.builder()
                    .clienteNombre("Jeff Proctor")
                    .estatus("Completado")
                    .total(-283.90)
                    .fecha(LocalDate.of(2024, 12, 31))
                    .build(),

                Ventas.builder()
                    .clienteNombre("Rodger Fritz")
                    .estatus("Completado")
                    .total(237.90)
                    .fecha(LocalDate.of(2024, 12, 24))
                    .build()
            );

            ventasRepo.saveAll(datosFigma);
        }
    }
}