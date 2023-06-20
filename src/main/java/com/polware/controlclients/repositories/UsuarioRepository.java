package com.polware.controlclients.repositories;

import com.polware.controlclients.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA
 * User: Paul H. Vargas P.
 * Date: 7/06/2023
 * Time: 1:35 p. m.
 */

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}
