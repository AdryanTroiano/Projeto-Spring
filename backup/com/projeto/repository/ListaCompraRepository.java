package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.ListaCompra;

@Repository
public interface ListaCompraRepository extends CrudRepository<ListaCompra, Integer> {
    public Iterable<ListaCompra> findByNomeLike(String nome);
}