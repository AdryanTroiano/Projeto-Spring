package com.projeto.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ListaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nome;        // Nome do produto
    private Date data;          // Data de adição
    private String descricao;   // Observação (ex: "integral", "sem açúcar")

    // NOVOS CAMPOS
    private String categoria;   // Proteinas, Verduras, etc
    private int quantidade;     // Quantidade
    private boolean comprado;   // Já foi comprado ou não
}