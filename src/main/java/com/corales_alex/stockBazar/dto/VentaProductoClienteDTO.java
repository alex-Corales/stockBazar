package com.corales_alex.stockBazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaProductoClienteDTO {
    private Long codigoVenta;
    private Double totalVenta;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaProductoClienteDTO(){}

    public VentaProductoClienteDTO(Long codigoVenta, Double totalVenta, int cantidadProductos, String nombreCliente, String apellidoCliente){
        this.codigoVenta = codigoVenta;
        this.totalVenta = totalVenta;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

}
