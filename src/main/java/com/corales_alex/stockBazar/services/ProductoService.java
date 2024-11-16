package com.corales_alex.stockBazar.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corales_alex.stockBazar.models.ProductoModel;
import com.corales_alex.stockBazar.repositorys.IProductoRepository;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public void saveProducto(ProductoModel producto) {
        iProductoRepository.save(producto);
    }

    @Override
    public List<ProductoModel> getAllProductos() {
        return iProductoRepository.findAll();
    }

    @Override
    public ProductoModel getProducto(Long codigoProducto) {
        return iProductoRepository.findById(codigoProducto).orElse(null);
    }

    @Override
    public void deteleProducto(Long codigoProducto) {
        iProductoRepository.deleteById(codigoProducto);
    }

    @Override
    public void updateProducto(Long codigoProducto, ProductoModel productoNuevo) {
        iProductoRepository.save(productoNuevo);
    }
    
}
