/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iptv.jdbc;


import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovane Oliveira
 */
public class ConfigDB {
  private Connection con;   
  
   public ConfigDB(){
    
    this.con = new ConnectionFactory().getConnection();
 
      try {
          
          
 //stmt.execute("create database if not exists iptv;");
                //stmt.execute("use iptv;");
           Statement stmt = con.createStatement();;
           stmt.execute("CREATE TABLE IF NOT EXISTS iptv.clientes(ID INT AUTO_INCREMENT PRIMARY KEY, NOME TEXT, DATAVENCIMENTO TEXT, DATAVENCSISTEMA TEXT, OBS TEXT,FORMAPAG TEXT) ENGINE=INNODB;");
           stmt.execute("CREATE TABLE IF NOT EXISTS iptv.preco(ID INT PRIMARY KEY, PRECO INT);");
            
         int n = consulta();
         
         if(n == 0){
             
          stmt.execute("insert into preco(id, preco) values(1,10);");
          JOptionPane.showMessageDialog(null, "O valor padrão do preco dos créditos é R$ 10,00 cada. Se for outro valor, por favor altere");
          
         }else{
       
             //JOptionPane.showMessageDialog(null, "Já foi");
         
         }
           
          
         
           stmt.close();
           
          

          
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro" + ex);
      }
    }
   
 public int consulta() throws SQLException{
 int x = 0;
           String sql = "SELECT * FROM iptv.preco";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            
                x = 1;
            
            }
 return x;
 
 
 }
    
}
