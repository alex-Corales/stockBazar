package com.corales_alex.stockBazar.services;

import java.util.List;

import com.corales_alex.stockBazar.models.VentaModel;

public interface IVentaService {
    public void saveVenta(VentaModel venta);
    public List<VentaModel> getAllVentas();
    public VentaModel getVenta(Long idVenta);
    public void deteleVenta(Long idVenta);
    public void updateVenta(Long idVenta, VentaModel ventaNueva);
}
