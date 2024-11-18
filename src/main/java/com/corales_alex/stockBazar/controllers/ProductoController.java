package com.corales_alex.stockBazar.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.corales_alex.stockBazar.models.ProductoModel;
import com.corales_alex.stockBazar.services.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private IProductoService iProductoService;

    @PostMapping("/crear")
    public String getProducto(@RequestBody ProductoModel producto){
        iProductoService.saveProducto(producto);
        return "El producto se creo correctamente";
    }

    @GetMapping("/")
    @ResponseBody // ¿ Que pasa si no pongo, como se envia ?
    public List<ProductoModel> getAllProductos(){
        return iProductoService.getAllProductos();
    }

    @GetMapping("/{codigoProducto}")
    @ResponseBody
    public ProductoModel getProducto(@PathVariable Long codigoProducto){
        return iProductoService.getProducto(codigoProducto);
    }

    @DeleteMapping("/eliminar/{codigoProducto}")
    public String deteleProducto(@PathVariable Long codigoProducto){
        iProductoService.deteleProducto(codigoProducto);
        return "El producto se elimino correctamente";
    }

    @PutMapping("/editar/{codigoProducto}")
    public String updateProducto(@PathVariable Long codigoProducto, @RequestBody ProductoModel producto){
        iProductoService.updateProducto(codigoProducto, producto);
        return "El producto se modifico correctamente";
    }
}
