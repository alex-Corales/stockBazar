package com.corales_alex.stockBazar.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.corales_alex.stockBazar.models.ProductoModel;
import com.corales_alex.stockBazar.services.IProductoService;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService iProductoService;

    @PostMapping("/productos/crear")
    public String getProducto(@RequestBody ProductoModel producto){
        iProductoService.saveProducto(producto);
        return "El producto se creo correctamente";
    }

    @GetMapping("/productos")
    public List<ProductoModel> getAllProductos(){
        return iProductoService.getAllProductos();
    }

    @GetMapping("/productos/{codigoProducto}")
    public ProductoModel getProducto(@PathVariable Long codigoProducto){
        return iProductoService.getProducto(codigoProducto);
    }

    @DeleteMapping("/productos/eliminar/{codigoProducto}")
    public String deteleProducto(@PathVariable Long codigoProducto){
        iProductoService.deteleProducto(codigoProducto);
        return "El producto se elimino correctamente";
    }

    @PutMapping("/productos/editar/{codigoProducto}")
    public String updateProducto(@PathVariable Long codigoProducto, @RequestBody ProductoModel producto){
        iProductoService.updateProducto(codigoProducto, producto);
        return "El producto se modifico correctamente";
    }
}
