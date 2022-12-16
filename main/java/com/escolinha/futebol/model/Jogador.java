package com.escolinha.futebol.model;


import javax.persistence.*;

@Entity
@Table(name = "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //coluna na tabela
    @Column
    private String nome;

    //coluna na tabela
    @Column
    private Double peso;

    //coluna na tabela
    @Column
    private Double altura;

    //coluna na tabela
    @Column
    private Integer idade;

    //coluna na tabela
    @Column
    private String perna;

    private Integer camisa;

    //Juntando as colunas - JOIN
    @ManyToOne
    @JoinColumn(name = "posicao_id")
    private Posicao posicao;



    // construtor vazio

    public Jogador(){

    }



    // Getter e Setter

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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getPerna() {
        return perna;
    }

    public void setPerna(String perna) {
        this.perna = perna;
    }

    public Integer getCamisa() {
        return camisa;
    }

    public void setCamisa(Integer camisa) {
        this.camisa = camisa;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }
}
