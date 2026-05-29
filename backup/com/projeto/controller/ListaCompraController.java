package com.projeto.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto.model.ListaCompra;
import com.projeto.service.ListaCompraService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ListaCompraController {

    private ListaCompraService listaCompraService;

    public ListaCompraController(ListaCompraService listaCompraService) {
        this.listaCompraService = listaCompraService;
    }

    @GetMapping("/cadastraritem")
    public String cadastrarItens() {
        return "cadastraritem.jsp";
    }

    @PostMapping("/cadastraritem")
    public String cadastrarItem(Model model, @ModelAttribute("item") ListaCompra item) {
        ListaCompra novoItem = listaCompraService.salvar(item);
        if (novoItem.getCodigo() > 0) {
            model.addAttribute("texto", "Item cadastrado! Código: " + novoItem.getCodigo());
        }

        return "mensagem.jsp";
    }

    @GetMapping("/listaritem")
    public String listarItem(Model model) {
        model.addAttribute("listaItens", listaCompraService.listar());
        return "listaritem.jsp";
    }

    @GetMapping("/alteraritem")
    public String alterarItem(HttpServletRequest req, Model model) {
        int codigo = Integer.parseInt(req.getParameter("codigo"));
        Optional<ListaCompra> opItem = listaCompraService.getPorCodigo(codigo);
        if (opItem.isPresent()) {
            model.addAttribute("item", opItem.get());
            return "alteraritem.jsp";
        } else {
            model.addAttribute("texto", "Item não encontrado!");
            return "mensagem.jsp";
        }
    }

    @GetMapping("/excluiritem")
    public String excluirItem(HttpServletRequest req, Model model) {
    int codigo = Integer.parseInt(req.getParameter("codigo"));
    listaCompraService.excluir(codigo);
    model.addAttribute("texto", "Item excluído com sucesso!");
    return "mensagem.jsp";
}
    

    @PostMapping("/alteraritem")
    public String alterarItem(@ModelAttribute("item") ListaCompra item, Model model) {
        ListaCompra itemAtualizado = listaCompraService.salvar(item);
        model.addAttribute("texto", "Item atualizado! Código: " + itemAtualizado.getCodigo());
        return "mensagem.jsp";
    }

    @GetMapping("/pesquisaritem")
    public String pesquisarItem(HttpServletRequest req, Model model) {
        String pesquisa = "%" + req.getParameter("pesquisa") + "%";
        model.addAttribute("listaItens", listaCompraService.pesquisarItem(pesquisa));
        return "listaritem.jsp";
    }
}