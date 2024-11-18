package com.corales_alex.stockBazar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corales_alex.stockBazar.models.ClienteModel;
import com.corales_alex.stockBazar.repositorys.IClienteRepository;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public void saveCliente(ClienteModel cliente) {
        iClienteRepository.save(cliente);
    }

    @Override
    public List<ClienteModel> getAllCliente() {
        return iClienteRepository.findAll();
    }

    @Override
    public ClienteModel getCliente(Long idCliente) {
        return iClienteRepository.findById(idCliente).orElse(null);
    }

    @Override
    public void deleteCliente(Long idCliente) {
        iClienteRepository.deleteById(idCliente);
    }
    
    @Override
    public void updateCliente(Long idCliente, ClienteModel clienteNuevo) {
        ClienteModel clienteAux = this.getCliente(idCliente);
        clienteAux.setNombre(clienteNuevo.getNombre());
        clienteAux.setApellido(clienteNuevo.getApellido());
        clienteAux.setDni(clienteNuevo.getDni());
        this.saveCliente(clienteAux);
    }
    
}
