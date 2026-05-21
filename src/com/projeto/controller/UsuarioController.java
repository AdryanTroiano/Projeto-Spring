package com.projeto.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/cadastrarusuario")
    public String exibirFormularioCadastro() {
        return "cadastrarusuario.jsp";
    }

    @PostMapping("/cadastrarusuario")
    public String cadastrarUsuario(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   @RequestParam("confirmPassword") String confirmPassword,
                                   Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("erro", "As senhas não coincidem.");
            return "cadastrarusuario.jsp";
        }

        if (usuarioRepository.findByUsername(username).isPresent()) {
            model.addAttribute("erro", "Usuário já existe.");
            return "cadastrarusuario.jsp";
        }

        String senhaCriptografada = passwordEncoder.encode(password);

        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsername(username);
        novoUsuario.setPassword(senhaCriptografada);
        novoUsuario.setRoles("ROLE_USER");

        usuarioRepository.save(novoUsuario);

        return "redirect:/login";
    }
}