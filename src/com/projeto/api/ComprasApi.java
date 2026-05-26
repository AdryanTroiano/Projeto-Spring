package com.projeto.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.ListaCompra;
import com.projeto.service.ListaCompraService;

@RestController
@RequestMapping("/compras")
public class ComprasApi {
    private ListaCompraService listaCompraService;

    public ComprasApi(ListaCompraService listaCompraService){
        this.listaCompraService = listaCompraService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<ListaCompra>> listar(){
        return new ResponseEntity<Iterable<ListaCompra>>(this.listaCompraService.listar(), HttpStatus.OK);

    }
    
}
