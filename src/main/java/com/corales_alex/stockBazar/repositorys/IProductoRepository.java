package com.corales_alex.stockBazar.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.corales_alex.stockBazar.models.ProductoModel;

public interface IProductoRepository extends JpaRepository<ProductoModel, Long>{
       
}

