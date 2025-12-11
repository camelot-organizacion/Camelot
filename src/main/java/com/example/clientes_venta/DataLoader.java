package com.example.clientes_venta;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.clientes_venta.Compras.Compras;
import com.example.clientes_venta.Compras.ComprasRepo;
import com.example.clientes_venta.Ventas.Ventas;
import com.example.clientes_venta.Ventas.VentasRepo;

@Component
public class DataLoader implements CommandLineRunner {

    private final VentasRepo ventasRepo;
    private final ComprasRepo comprasRepo;

    public DataLoader(VentasRepo ventasRepo, ComprasRepo comprasRepo) {
        this.ventasRepo = ventasRepo;
        this.comprasRepo = comprasRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (ventasRepo.count() == 0) {
            
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

        // Solo llenamos la tabla de compras si está vacía para no duplicar datos
        if (comprasRepo.count() == 0) {
            List<Compras> comprasData = List.of(
                Compras.builder()
                    .nombreProducto("Laptop Dell")
                    .cantidad(50)
                    .fecha("2025-01-15")
                    .build(),

                Compras.builder()
                    .nombreProducto("Monitor LG 27\"")
                    .cantidad(75)
                    .fecha("2025-01-14")
                    .build(),

                Compras.builder()
                    .nombreProducto("Teclado Mecánico")
                    .cantidad(120)
                    .fecha("2025-01-12")
                    .build(),

                Compras.builder()
                    .nombreProducto("Ratón Logitech")
                    .cantidad(45)
                    .fecha("2025-01-10")
                    .build(),

                Compras.builder()
                    .nombreProducto("Cable HDMI")
                    .cantidad(200)
                    .fecha("2025-01-08")
                    .build(),

                Compras.builder()
                    .nombreProducto("Hub USB 3.0")
                    .cantidad(80)
                    .fecha("2025-01-05")
                    .build(),

                Compras.builder()
                    .nombreProducto("Auriculares Sony")
                    .cantidad(90)
                    .fecha("2025-01-03")
                    .build(),

                Compras.builder()
                    .nombreProducto("SSD Samsung 1TB")
                    .cantidad(150)
                    .fecha("2024-12-30")
                    .build()
            );

            comprasRepo.saveAll(comprasData);
        }
    }
}