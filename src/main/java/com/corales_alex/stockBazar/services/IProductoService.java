package com.corales_alex.stockBazar.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.corales_alex.stockBazar.models.ProductoModel;

public interface IProductoService extends JpaRepository<ProductoModel, Long>{
    
}

