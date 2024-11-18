package com.corales_alex.stockBazar.services;

import java.util.List;
import com.corales_alex.stockBazar.models.ClienteModel;

public interface IClienteService {
    public void saveCliente(ClienteModel cliente);
    public List<ClienteModel> getAllCliente();
    public ClienteModel getCliente(Long idCliente);
    public void deleteCliente(Long idCliente);
    public void updateCliente(Long idCliente, ClienteModel clienteNuevo);
}

