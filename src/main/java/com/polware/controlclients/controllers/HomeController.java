package com.polware.controlclients.controllers;

import com.polware.controlclients.models.Cliente;
import com.polware.controlclients.services.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA
 * User: Paul H. Vargas P.
 * Date: 31/05/2023
 * Time: 8:05 p. m.
 */
@Controller
@Slf4j
public class HomeController {
    private final ClienteService clienteService;

    public HomeController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal User user) {
        var clientes = clienteService.listClients();
        var saldoTotal = 0D;
        var totalClientes = 0;
        log.info("Usuario autenticado: " + user);
        log.info("Listado clientes: " + clientes);
        model.addAttribute("clientes", clientes);
        for (var p:clientes) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        totalClientes = clientes.size();
        model.addAttribute("totalClientes", totalClientes);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/save")
    public String save(@Valid Cliente cliente, Errors errors) {
        if (errors.hasErrors()) {
            return "modify";
        }
        clienteService.save(cliente);
        return "redirect:/";
    }

    @GetMapping("/edit/{idCliente}")
    public String edit(Cliente cliente, Model model) {
        cliente = clienteService.findClient(cliente);
        model.addAttribute("cliente", cliente);
        return "modify";
    }

    @GetMapping("/delete")
    public String delete(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/";
    }

}
