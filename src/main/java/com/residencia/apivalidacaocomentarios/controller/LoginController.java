package com.residencia.apivalidacaocomentarios.controller;

import com.residencia.apivalidacaocomentarios.model.Usuario;
import com.residencia.apivalidacaocomentarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService; // Serviço para validar o login

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Retorna a página de login
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            Optional<Usuario> userOptional = usuarioService.validateUser(username, password);
            return userOptional.map(user -> {
                model.addAttribute("user", user);
                return "redirect:/swagger-ui/index.html";
            }).orElseGet(() -> {
                model.addAttribute("error", "Usuário ou senha inválidos");
                return "login";
            });
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao processar login");
            return "login";
        }
    }

}