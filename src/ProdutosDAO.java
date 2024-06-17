/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm, @DevOtavioAlves
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProdutosDAO {
    
         Connection conn;
         PreparedStatement prep;
         
         
         public List<ProdutosDTO> listarProdutos() {
                  List<ProdutosDTO> produtos = new ArrayList<>();
                  conn = new conectaDAO().connectDB(); // Conexão com o banco de dados

                  String sql = "SELECT id, nome, valor, vendido FROM produtos";

                  try {
                           prep = conn.prepareStatement(sql);
                           ResultSet rs = prep.executeQuery();

                           while (rs.next()) {
                                    ProdutosDTO produto = new ProdutosDTO();
                                    produto.setId(rs.getInt("id"));
                                    produto.setNome(rs.getString("nome"));
                                    produto.setValor(rs.getInt("valor"));
                                    produto.setVendido(rs.getString("vendido"));
                                    produtos.add(produto);
                           }
                  } catch (SQLException e) {
                           System.err.println("Erro ao listar produtos: " + e);
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
                  return produtos;
         }
         
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
         
         conectaDAO conexao = new conectaDAO();
         Connection con = null;

                  try {
                           con = conexao.connectDB();
                           String sql = "UPDATE produtos SET vendido = 'S' WHERE id = ?";
                           PreparedStatement stmt = con.prepareStatement(sql);

                           stmt.setInt(1, produtoId);
                           stmt.executeUpdate();
                           JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
                  } catch (SQLException e) {
                           JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
                  } finally {
                           if (con != null) {
                                    try {
                                             con.close();
                                    } catch (SQLException e) {
                                             e.printStackTrace();
                                    }
                           }
                  }
         }
         public List<ProdutosDTO> listarProdutosVendidos() {
                  List<ProdutosDTO> produtosVendidos = new ArrayList<>();
                  conn = new conectaDAO().connectDB(); // Conexão com o banco de dados
                  
                  String sql = "SELECT * FROM produtos WHERE vendido = 'S'";
                  
                  try {
                           prep = conn.prepareStatement(sql);
                           ResultSet rs = prep.executeQuery();

                  while (rs.next()) {
                           ProdutosDTO produto = new ProdutosDTO();
                           produto.setId(rs.getInt("id"));
                           produto.setNome(rs.getString("nome"));
                           produto.setValor(rs.getInt("valor"));
                           produtosVendidos.add(produto);
                  }
         } catch (SQLException e) {
            System.err.println("Erro ao listar produtos vendidos: " + e);
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
                  return produtosVendidos;
         }
}

