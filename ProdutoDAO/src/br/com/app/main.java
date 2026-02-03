/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.app;

import br.com.DAO.ProdutoDAO;
import br.com.model.Produto;
import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class main {
    public static void main(String[]args){
    //  Scanner = entrada de dados (Nosso prompt por java)
    Scanner entrada = new Scanner(System.in);
    
    // DAO = quem conversa com o banco
    ProdutoDAO dao = new ProdutoDAO();
    
    System.out.println("Quantos alunos deseja cadastrar? ");
    int quantidade = entrada.nextInt();
    entrada.nextLine();
    
    // Loop para cadastrar alunos
    for(int i = 1; i <= quantidade; i++){
        System.out.println("Digame o nome do produto "+ i + ": ");
        String nome = entrada.nextLine();
        // Cria o alunon (Model)
        Produto produto = new Produto(nome, valor, SetorPruduo);
        
        // Envia para o DAO salvar no banco
        dao.cadastrar(produto);
      }
    
    // Litsa os alunos cadastrados
    System.out.println("\n=== Alunos Cadastrados ===");
    dao.listar().forEach(aluno -> {
        System.out.println(aluno.getId()+ " - "+ aluno.getNome());
    });
    entrada.close();
    
    }
}
