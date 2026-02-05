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
    
    System.out.println("Quantos Produtos novos deseja cadastrar? ");
    int quantidade = entrada.nextInt();
    entrada.nextLine();
    
    // Loop para cadastrar alunos
    for(int i = 1; i <= quantidade; i++){

        System.out.println("Digite o nome do produto " + i + ": ");
        String nome = entrada.nextLine();

        System.out.println("Digite o valor do produto: ");
        int valor = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Digite o setor do produto: ");
        String setorProduto = entrada.nextLine();

        Produto produto = new Produto(nome, valor, setorProduto);

            // ✅ AGORA SALVA NO BANCO
            dao.cadastrar(produto);
    }

    
    // Litsa os alunos cadastrados
    System.out.println("\n=== Novos produtos Cadastrados ===");
    dao.listar().forEach(Produto -> {
        System.out.println(Produto.getNome() + " - R$" + Produto.getValor() + " - " + Produto.getSetorProfuto());
    });
    entrada.close();
    
    }
}
