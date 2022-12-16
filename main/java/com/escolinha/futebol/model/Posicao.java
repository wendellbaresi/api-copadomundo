package com.escolinha.futebol.model;


import javax.persistence.*;

@Entity
@Table(name = "posicao")
public class Posicao {

    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // coluna
    @Column
    private String nome;


    // gerando contrutor vazio
    public Posicao(){

    }

    public Posicao (Integer id){
        this.id = id;
    }


    // getter e setter

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
}
