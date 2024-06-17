/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm, @DevOtavioAlves
 */
public class ProdutosDTO {
    
         private Integer id;
         private String nome;
         private Integer valor;
         private String vendido;

         public Integer getId() {
                  return id;
         }

         public String getNome() {
                  return nome;
         }

         public Integer getValor() {
                  return valor;
         }

         public String getVendido() {
                  return vendido;
         }

         public void setId(Integer id) {
                  this.id = id;
         }

         public void setNome(String nome) {
                  this.nome = nome;
         }

         public void setValor(Integer valor) {
                  this.valor = valor;
         }

         public void getVendido(String vendido) {
                  this.vendido = vendido;
         }
    
}
