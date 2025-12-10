package com.example.clientes_venta.Compras;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="compras")
public class Compras {

    @Id
    @SequenceGenerator(
            name = "compras_id_seq",
            sequenceName = "compras_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "compras_id_seq"
    )
    private Integer id;

    // CAMBIOS AQUI:
    private String producto;  // Ej: "Paquete Hamburguesa"
    
    private Integer cantidad; // Ej: 2

    private String estatus;   // Ej: "Entregado"

    private Double total;     // El precio total de la compra

    private LocalDate fecha;  
}