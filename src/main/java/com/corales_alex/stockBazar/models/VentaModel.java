package com.corales_alex.stockBazar.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private Double total;
    private List<ProductoModel> listaProductos;
    private ClienteModel cliente;

    public VentaModel(){}

    public VentaModel(Long codigoVenta, LocalDate fechaVenta, Double total, List<ProductoModel> listaProductos, ClienteModel cliente){
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.cliente = cliente;
    }

}
