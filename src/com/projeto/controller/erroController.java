package com.projeto.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class erroController implements ErrorController {
    
    @RequestMapping("/error")
    public String handleErro(HttpServletRequest req, Model model) {
        Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object erro = req.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        String mensagem = "Status:"+ status.toString() + "<br><br>" + erro.toString();
        if (status.toString().equals("404")){
            mensagem += "Página não encontrada!";
        }
        model.addAttribute("mensagem", mensagem);
        return "erro.jsp";
    }

    public String getErrorPath() {
        return "/error";
    }
}
