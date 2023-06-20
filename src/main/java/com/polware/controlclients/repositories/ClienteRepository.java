package com.polware.controlclients.repositories;

import com.polware.controlclients.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA
 * User: Paul H. Vargas P.
 * Date: 31/05/2023
 * Time: 8:19 p. m.
 */

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
