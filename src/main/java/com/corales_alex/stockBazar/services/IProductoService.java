package com.corales_alex.stockBazar.services;

import java.util.List;
import com.corales_alex.stockBazar.models.ProductoModel;

public interface IProductoService{
    public void saveProducto(ProductoModel producto);
    public List<ProductoModel> getAllProductos();
    public ProductoModel getProducto(Long codigoProducto);
    public void deteleProducto(Long codigoProducto);
    public void updateProducto(Long codigoProducto, ProductoModel productoNuevo);
    public List<ProductoModel> faltaStock();
}

