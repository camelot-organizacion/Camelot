package com.example.clientes_venta.Producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double precio;

    private Integer stock;

    @Column(columnDefinition = "text")
    private String categoria;

    @Column(columnDefinition = "text")
    private String name;

    @Column(name = "cantidad_medida")
    private Double cantidadMedida;

    @Column(name = "imagen_url", columnDefinition = "text")
    private String imagenUrl;

    @Column(columnDefinition = "text")
    private String subcategoria;

    @Column(name = "unidad_medida", columnDefinition = "text")
    private String unidadMedida;

    // ====== GETTERS Y SETTERS ======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCantidadMedida() {
        return cantidadMedida;
    }

    public void setCantidadMedida(Double cantidadMedida) {
        this.cantidadMedida = cantidadMedida;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}