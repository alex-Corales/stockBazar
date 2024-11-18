package com.corales_alex.stockBazar.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corales_alex.stockBazar.dto.VentaProductoClienteDTO;
import com.corales_alex.stockBazar.models.ProductoModel;
import com.corales_alex.stockBazar.models.VentaModel;
import com.corales_alex.stockBazar.services.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    
    @Autowired
    private IVentaService iVentaService;

    @PostMapping("/crear")
    public String saveVenta(@RequestBody VentaModel venta){
        iVentaService.saveVenta(venta);
        return "La venta se registro correctamente";
    }

    @GetMapping("/")
    public List<VentaModel> getAllVentas(){
        return iVentaService.getAllVentas();
    }

    @GetMapping("/{idVenta}")
    public VentaModel getVentas(@PathVariable Long idVenta){
        return iVentaService.getVenta(idVenta);
    }

    @DeleteMapping("/eliminar/{idVenta}")
    public String deteleVenta(@PathVariable Long idVenta){
        iVentaService.deteleVenta(idVenta);
        return "La venta se elimino correctamente";
    }

    @PutMapping("/editar/{idVenta}")
    public String updateVenta(@PathVariable Long idVenta, @RequestBody VentaModel ventaNueva){
        iVentaService.updateVenta(idVenta, ventaNueva);
        return "La venta se actualizo con exito";
    }

    @GetMapping("/productos{codigoVenta}")
    public List<ProductoModel> obtenerProductosDeterminadaVenta(@PathVariable Long codigoVenta){
        return iVentaService.obtenerProductosDeterminadaVenta(codigoVenta);
    }

    @GetMapping("/{fechaVenta}")
    public String obtenerSumatoriaMontoYCantidadTotalVentasDeterminadoDia(@PathVariable LocalDate fechaVenta){
        return iVentaService.obtenerSumatoriaMontoYCantidadTotalVentasDeterminadoDia(fechaVenta);
    }

    @GetMapping("/mayor_venta")
    public VentaProductoClienteDTO datosDTO(){
        return iVentaService.datosDTO();
    }
    
}
