package com.polware.controlclients.services;

import com.polware.controlclients.models.Cliente;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Paul H. Vargas P.
 * Date: 31/05/2023
 * Time: 8:42 p. m.
 */
public interface ClienteService {

    List<Cliente> listClients();

    void save(Cliente cliente);

    void delete(Cliente cliente);

    Cliente findClient(Cliente cliente);

}
