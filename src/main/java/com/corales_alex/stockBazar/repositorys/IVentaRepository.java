package com.corales_alex.stockBazar.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.corales_alex.stockBazar.models.ClienteModel;

@Repository
public interface IVentaRepository extends JpaRepository<ClienteModel, Long>{
    
}

