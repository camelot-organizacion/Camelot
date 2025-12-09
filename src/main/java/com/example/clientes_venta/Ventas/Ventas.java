package com.example.clientes_venta.Ventas;

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
@Table(name="ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Agregado para que el ID sea automático (1, 2, 3...)
    private Long id; // Cambiado de Integer a Long (estándar en JPA)

    @Column(name = "cliente_nombre")
    private String clienteNombre; // Antes "cantidad". Ahora es el nombre del cliente.

    private String estatus; // Antes "Estado estado". Lo dejamos como String para que coincida con "Pendiente/Completado" del Figma.

    private Double total; // Nuevo campo para el precio ($217.90)

    private LocalDate fecha; // Cambiado de String a LocalDate para manejar fechas reales
}