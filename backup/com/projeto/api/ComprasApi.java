package com.projeto.api;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("{codigo}")
    @ResponseBody
    public ResponseEntity<ListaCompra> getPorCodigo(@PathVariable("codigo") int codigo) {
        Optional<ListaCompra>opCompra = this.listaCompraService.getPorCodigo(codigo);
        if (opCompra.isPresent()) {
            return new ResponseEntity<ListaCompra>(opCompra.get(), HttpStatus.OK);
        } 
        
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    
}
