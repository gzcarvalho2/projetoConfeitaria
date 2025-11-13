package com.Senac.Prova.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "bolo")
public class Bolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bolo_id")
    private Integer id;
    @Column(name = "bolo_nome")
    private String nome;
    @Column(name = "bolo_descricao")
    private String descricao;
    @Column(name = "bolo_status")
    private Integer status;

    @OneToMany (mappedBy = "bolo")
    List<Ingrediente> ingredientes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
