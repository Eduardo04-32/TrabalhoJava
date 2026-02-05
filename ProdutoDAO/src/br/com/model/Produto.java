/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.model;

/**
 *
 * @author jesus
 */
public class Produto {
    //colunas da tebala
    private int id;
    private String nome;
    private int valor;
    private String SetorProfuto;
    
    
    public Produto()
    {
        
    }

    public Produto(String nome, int valor, String SetorProfuto) {
        this.nome = nome;
        this.valor = valor;
        this.SetorProfuto = SetorProfuto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getSetorProfuto() {
        return SetorProfuto;
    }

    public void setSetorProfuto(String SetorProfuto) {
        this.SetorProfuto = SetorProfuto;
    }
    
    
 
}
