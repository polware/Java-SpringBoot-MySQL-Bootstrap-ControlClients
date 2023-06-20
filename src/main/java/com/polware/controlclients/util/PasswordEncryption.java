package com.polware.controlclients.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by IntelliJ IDEA
 * User: Paul H. Vargas P.
 * Date: 7/06/2023
 * Time: 11:51 a. m.
 */
public class PasswordEncryption {

    public static void main(String[] args) {
        var password = "admin";
        System.out.println("Password encriptado: "+encryptPassword(password));
    }

    public static String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
