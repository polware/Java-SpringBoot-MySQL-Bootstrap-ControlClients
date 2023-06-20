package com.polware.controlclients.services;

import com.polware.controlclients.repositories.ClienteRepository;
import com.polware.controlclients.models.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Paul H. Vargas P.
 * Date: 31/05/2023
 * Time: 8:44 p. m.
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listClients() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findClient(Cliente cliente) {
        return clienteRepository.findById(cliente.getIdCliente()).orElse(null);

    }

}
