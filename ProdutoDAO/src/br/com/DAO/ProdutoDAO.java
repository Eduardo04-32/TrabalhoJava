/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DAO;
import br.com.config.connetion;
import java.sql.Connection;
import br.com.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesus
 */
public class ProdutoDAO {
    //CREATE: inserir o aluno no banco
    public void cadastrar(Produto produto){
    // SQL com ? (parâmetro) para evitar SQL injection
    String sql = "INSERT INTO produtos (nome, valor, SetorProfuto) VALUES (?,?,?)";
    // tratamento de possíveis erros | no caso fecha automaticamehnte a conexão e o Statement 
    try (Connection conn = connetion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
        // Troca o ? pelo nome do aluno
        stmt.setString(1, produto.getNome());
        stmt.setInt(2, produto.getValor());              // valor é inteiro
        stmt.setString(3, produto.getSetorProfuto());    // setor é texto

        // Executa o INSERT (podemos utilizar op executeUpdate para INSERT/UPDATE/DELETE)
        stmt.executeUpdate();
        
    }catch(Exception e){
        // se der erro, mostramos uma mensagem clara
        throw new RuntimeException ("Erro ao cadastrar produto", e);
    
    }
    }
    // READ: listar todos
    public List<Produto> listar(){
    // SQL para buscar todos
    String sql = "SELECT id, nome, valor, SetorProfuto FROM produtos";
    
    // Lista que vamos devolver preenchida
    List<Produto> produtos = new ArrayList<>();
    try(Connection conn= connetion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
    // Enquanto tiver linha no resultado
    while(rs.next())
    {
    // Pega os dados da linha atual
    int id = rs.getInt("id");
    String nome =rs.getString("nome");
    int valor = rs.getInt("valor");
    String SetorProfuto = rs.getString("SetorProfuto");
    
    
    // Monta um objeto Aluno com os dados
        Produto produto = new Produto(nome, valor, SetorProfuto);
    
    // Adiciona na lista
    produtos.add(produto);
    }
    
    
    
    }
    catch (Exception e)
    {
    throw new RuntimeException("Erro ao listar produtos", e);
    
    }
    // Devolve a lista pronta
    return produtos;             
    }

    
}


