package com.corales_alex.stockBazar.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

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
        ProductoModel productoModificar = this.getProducto(codigoProducto);
        productoModificar.setNombre(productoNuevo.getNombre());
        productoModificar.setMarca(productoNuevo.getMarca());
        productoModificar.setCosto(productoNuevo.getCosto());
        productoModificar.setCantidadDisponible(productoNuevo.getCantidadDisponible());
        this.saveProducto(productoModificar);
    }

    @Override
    public List<ProductoModel> faltaStock() {
        List<ProductoModel> productos = new ArrayList<>();

        for (ProductoModel produc : this.getAllProductos()){
            if(produc.getCantidadDisponible() < 5) productos.add(produc);
        }

        return productos;
    }
    
}
