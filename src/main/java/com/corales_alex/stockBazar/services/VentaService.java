package com.corales_alex.stockBazar.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corales_alex.stockBazar.models.ProductoModel;
import com.corales_alex.stockBazar.models.VentaModel;
import com.corales_alex.stockBazar.repositorys.IVentaRepository;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository iVentaRepository;

    @Override
    public void saveVenta(VentaModel venta) {
        iVentaRepository.save(venta);
    }

    @Override
    public List<VentaModel> getAllVentas() {
        return iVentaRepository.findAll();
    }

    @Override
    public VentaModel getVenta(Long idVenta) {
        return iVentaRepository.findById(idVenta).orElse(null);
    }

    @Override
    public void deteleVenta(Long idVenta) {
        iVentaRepository.deleteById(idVenta);
    }

    @Override
    public void updateVenta(Long idVenta, VentaModel ventaNueva) {
        VentaModel ventaAux = this.getVenta(idVenta);
        ventaAux.setFechaVenta(ventaNueva.getFechaVenta());
        ventaAux.setTotal(ventaNueva.getTotal());
        ventaAux.setListaProductos(ventaNueva.getListaProductos());
        ventaAux.setCliente(ventaNueva.getCliente());
        this.saveVenta(ventaAux);
    }

    @Override
    public List<ProductoModel> obtenerProductosDeterminadaVenta(Long codigoVenta) {
        return this.getVenta(codigoVenta).getListaProductos();
    }

    @Override
    public String obtenerSumatoriaMontoYCantidadTotalVentasDeterminadoDia(LocalDate fechaVenta) {
        
        // Primero vamos a buscar las ventas de un determinado dia
        List<VentaModel> ventaDia = new ArrayList<>();

        for (VentaModel venta : this.getAllVentas()) {
            if (venta.getFechaVenta().equals(fechaVenta)){
                ventaDia.add(venta);
            }
        }

        double sumatoriaMontoTotal = 0.0;
        int contTotalVentas = 0;

        for (VentaModel venta : ventaDia){
            contTotalVentas += 1;
            sumatoriaMontoTotal += venta.getTotal();
        }

        return "La sumatoria total del monto de ventas del dia es de: " + sumatoriaMontoTotal + " y la cantidad de ventas es de: " + contTotalVentas;
    }
    
}
