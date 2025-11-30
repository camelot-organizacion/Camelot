package com.example.clientes_venta.Producto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="producto")
public class Producto {

    @Id
    private Integer id;
    
    private String name;

    private Float precio;

    private Integer stock;

    private String categoria;

}
