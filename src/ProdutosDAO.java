/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm, @DevOtavioAlves
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ProdutosDAO {
    
         Connection conn;
         PreparedStatement prep;
    
         public boolean cadastrarProduto(ProdutosDTO produto) {
         conn = new conectaDAO().connectDB(); // Conexão com o banco de dados
         
                  String sql = "INSERT INTO produtos (nome, valor, vendido) VALUES (?, ?, ?)";

                  try {
                           prep = conn.prepareStatement(sql);
                           prep.setString(1, produto.getNome());
                           prep.setInt(2, produto.getValor());
                           prep.setString(3, produto.getVendido());

                           int rowsAffected = prep.executeUpdate();
                           return rowsAffected > 0;
                           
                  } catch (SQLException e) {
                           
                           System.err.println("Erro ao cadastrar o produto: " + e);
                           return false;
                           
                  } finally {
                           try {
                                    if (prep != null) {
                                             prep.close();
                                    }
                                    if (conn != null) {
                                             conn.close();
                                    }
                           } catch (SQLException ex) {
                                    System.err.println("Erro ao fechar a conexão: " + ex);
                           }
                  }
    }
         
         public void venderProduto(int produtoId) {
                  // Conectar ao banco de dados
                  conectaDAO conexao = new conectaDAO();
                  Connection conn = conexao.connectDB();

                  // Atualizar o status do produto para "vendido"
                  String sql = "UPDATE produtos SET status = 'vendido' WHERE id = ?";

                  try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                           stmt.setInt(1, produtoId);
                           stmt.executeUpdate();
                           JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
                  } catch (SQLException e) {
                           JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
                  } finally {
                           try {
                           conn.close();
                           } catch (SQLException e) {
                                    e.printStackTrace();
                           }
                  }
         }
}

