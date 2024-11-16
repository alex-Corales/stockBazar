package com.corales_alex.stockBazar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ProductoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoProducto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidadDisponible;

    public ProductoModel(){}

    public ProductoModel(Long codigoProducto, String nombre, String marca, Double costo, Double cantidadDisponible){
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
    }

}
