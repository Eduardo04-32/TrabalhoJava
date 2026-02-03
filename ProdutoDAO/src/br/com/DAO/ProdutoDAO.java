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
        stmt.setString(2, produto.getSetorProfuto());
        stmt.setInt(3, produto.getValor());
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
    String sql = "SELECT id, nome, SetorProfuto, valor FROM produtos";
    
    // Lista que vamos devolver preenchida
    List<Produto> produtos = new ArrayList<>();
    try(Connection conn= connetion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
    // Enquanto tiver linha no resultado
    while(rs.next())
    {
    // Pega os dados da linha atual
    int id = rs.getInt("id");
    String nome =rs.getString("nome");
    String SetorProfuto = rs.getString("SetorProfuto");
    int valor = rs.getInt("valor");
    
    // Monta um objeto Aluno com os dados
    Produto produto = new Produto(id, nome, valor, SetorProfuto );
    
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
