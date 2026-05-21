package com.projeto.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.model.ListaCompra;
import com.projeto.repository.ListaCompraRepository;

@Service
public class ListaCompraService {

    private ListaCompraRepository listaCompraRepository;

    public ListaCompraService(ListaCompraRepository listaCompraRepository) {
        this.listaCompraRepository = listaCompraRepository;
    }

    public ListaCompra salvar(ListaCompra item) {
        return listaCompraRepository.save(item);
    }

    public Iterable<ListaCompra> listar() {
        return listaCompraRepository.findAll();
    }

    public Optional<ListaCompra> getPorCodigo(int codigo) {
        return listaCompraRepository.findById(codigo);
    }

    public Iterable<ListaCompra> pesquisarItem(String pesquisa) {
        return listaCompraRepository.findByNomeLike(pesquisa);
    }

    public void excluir(int codigo) {
    listaCompraRepository.deleteById(codigo);
}
}