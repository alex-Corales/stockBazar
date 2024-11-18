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

import com.corales_alex.stockBazar.models.ClienteModel;
import com.corales_alex.stockBazar.services.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/crear")
    public String saveCliente(@RequestBody ClienteModel cliente){
        iClienteService.saveCliente(cliente);
        return "El cliente se guardo correctamente";
    }

    @GetMapping("/")
    @ResponseBody
    public List<ClienteModel> getAllClientes(){
        return iClienteService.getAllCliente();
    }

    @GetMapping("/{idCliente}")
    @ResponseBody
    public ClienteModel getCliente(@PathVariable Long idCliente){
        return iClienteService.getCliente(idCliente);
    }

    @DeleteMapping("/eliminar/{idCliente}")
    public String deleteCliente(@PathVariable Long idCliente){
        iClienteService.deleteCliente(idCliente);
        return "El cliente se elimino correctamente";
    }

    @PutMapping("/editar/{idCliente}")
    public String updateCliente(@PathVariable Long idCliente, @RequestBody ClienteModel clienteNuevo){
        iClienteService.updateCliente(idCliente, clienteNuevo);
        return "El cliente se actualizo con exito";
    }
}
