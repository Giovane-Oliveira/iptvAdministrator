/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iptv.dao;


import br.com.iptv.jdbc.ConnectionFactory;
import br.com.iptv.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovane Oliveira
 */
public class ClientesDAO {

    private Connection con;

    public void cadastrarCliente(Clientes obj) {

        try {

            String sql = "insert into clientes(NOME, DATAVENCIMENTO, DATAVENCSISTEMA, OBS, FORMAPAG)"
                    + "values(?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNOME());
            stmt.setString(2, obj.getDATAVENCIMENTO());
            stmt.setString(3, obj.getDATAVENCSISTEMA());
            stmt.setString(4, obj.getOBS());
            stmt.setString(5, obj.getFORMAPAG());
           

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com  sucesso");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }

    }
    
    public void creditos(int preco) {

        try {

            String sql = "update preco set preco=? where id =?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, preco);
            stmt.setInt(2, 1);
        
           

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com  sucesso");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }

    }


    public void excluirCliente(int x) {
int n = 0;
        try {

            String sql = "delete from clientes where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, x);

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Deletado com  sucesso");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }

    }
    
    
     public Integer precoCredito(){
      int valor = 0;
        try {

            String sql = "SELECT preco FROM iptv.preco";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

              valor =  rs.getInt("preco");
       

            }
           

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
 return valor;
    
    }
    
    public Integer fatura(int n){
        int creditos = 0; //3
             int custo = 0; //2
             int lucro = 0; //1
             int count = 0;
        try {

            String sql = "SELECT * FROM iptv.clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

           count = count + 1;

            }
            creditos = count ; //3
           custo = creditos * precoCredito(); //2
           lucro = ((creditos * 30) - custo); //1

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
    if(n == 1){
    return lucro;
    }else if( n == 2){
    return custo;
    }else{
    
        return creditos;
    }
    
    }

    public void alterarCliente(Clientes obj) {
      
        try {

           
            String sql = "update clientes set NOME=?, DATAVENCIMENTO=?, DATAVENCSISTEMA=?, OBS=?, FORMAPAG=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNOME());
            stmt.setString(2, obj.getDATAVENCIMENTO());
            stmt.setString(3, obj.getDATAVENCSISTEMA());
            stmt.setString(4, obj.getOBS());
            stmt.setString(5, obj.getFORMAPAG());
            stmt.setInt(6, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com  sucesso");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }

    }
    
 
    
    

    public List<Clientes> listarClientesSistemaPagamento(int c) {
           List<Clientes> lista = new ArrayList<>();
if(c == 0){

         String data = LocalDate.now().toString();
       String ano = data.substring(0, 4); //ano
       
       String mes = data.substring(5, 7); //mes
        
       String dia = data.substring(8, 10); //dia
        
        //String d = "" + dia + "-" + mes + "-" + ano;
        
        
     
        try {

            String sql = "select * from clientes where datavencsistema like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + dia + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
//NOME VARCHAR, DATAVENCIMENTO VARCHAR, DATAVENCSISTEMA VARCHAR, OBS VARCHAR, FORMAPAG)");
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNOME(rs.getString("nome"));
                obj.setDATAVENCIMENTO(rs.getString("datavencimento"));
                obj.setDATAVENCSISTEMA(rs.getString("datavencsistema"));
                obj.setOBS(rs.getString("obs"));
                obj.setFORMAPAG(rs.getString("formapag"));
              

                lista.add(obj);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }


}else{
      String data = LocalDate.now().toString();
       String ano = data.substring(0, 4); //ano
       
       String mes = data.substring(5, 7); //mes
        
       String dia = data.substring(8, 10); //dia
        
        //String d = "" + dia + "-" + mes + "-" + ano;
        
        
     
        try {

            String sql = "select * from clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setString(1, "%" + dia + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
//NOME VARCHAR, DATAVENCIMENTO VARCHAR, DATAVENCSISTEMA VARCHAR, OBS VARCHAR, FORMAPAG)");
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNOME(rs.getString("nome"));
                obj.setDATAVENCIMENTO(rs.getString("datavencimento"));
                obj.setDATAVENCSISTEMA(rs.getString("datavencsistema"));
                obj.setOBS(rs.getString("obs"));
                obj.setFORMAPAG(rs.getString("formapag"));
              

                lista.add(obj);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }

    
}






        return lista;

    }
    
        public List<Clientes> listarClientesPagamento(int c) {
    List<Clientes> lista = new ArrayList<>();
            if(c == 0){
         
        try {
            String data = LocalDate.now().toString();
       String ano = data.substring(0, 4); //ano
       
       String mes = data.substring(5, 7); //mes
        
       String dia = data.substring(8, 10); //dia
        
        String d = "" + dia + "-" + mes + "-" + ano;
        

            String sql = "select * from clientes where datavencimento like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + dia + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
//NOME VARCHAR, DATAVENCIMENTO VARCHAR, DATAVENCSISTEMA VARCHAR, OBS VARCHAR, FORMAPAG)");
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNOME(rs.getString("nome"));
                obj.setDATAVENCIMENTO(rs.getString("datavencimento"));
                obj.setDATAVENCSISTEMA(rs.getString("datavencsistema"));
                obj.setOBS(rs.getString("obs"));
                obj.setFORMAPAG(rs.getString("formapag"));
              

                lista.add(obj);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
            
            }else{
             try {
            String data = LocalDate.now().toString();
       String ano = data.substring(0, 4); //ano
       
       String mes = data.substring(5, 7); //mes
        
       String dia = data.substring(8, 10); //dia
        
        String d = "" + dia + "-" + mes + "-" + ano;
        

            String sql = "select * from clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setString(1, "%" + dia + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
//NOME VARCHAR, DATAVENCIMENTO VARCHAR, DATAVENCSISTEMA VARCHAR, OBS VARCHAR, FORMAPAG)");
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNOME(rs.getString("nome"));
                obj.setDATAVENCIMENTO(rs.getString("datavencimento"));
                obj.setDATAVENCSISTEMA(rs.getString("datavencsistema"));
                obj.setOBS(rs.getString("obs"));
                obj.setFORMAPAG(rs.getString("formapag"));
                

                lista.add(obj);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
            
            }
            
            
       
        return lista;

    }
   

  public void aniversariante(){
  int sair = 0;
  
       try {
  
            String sql = "select * from clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setString(1, "%" + dia + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next() && sair != 1) {
//NOME VARCHAR, DATAVENCIMENTO VARCHAR, DATAVENCSISTEMA VARCHAR, OBS VARCHAR, FORMAPAG)");
               
               
                //verificar aniversario
              String dataVenc = rs.getString("datavencimento");
              int anox = Integer.parseInt(dataVenc.substring(6,10));
              int mesx = Integer.parseInt(dataVenc.substring(3,5));
              int diax = Integer.parseInt(dataVenc.substring(0,2));
              
              String datax = LocalDate.now().toString();
       int ano1 = Integer.parseInt(datax.substring(0, 4)); //ano
       
       int mes1 = Integer.parseInt(datax.substring(5, 7)); //mes
        
       int dia1 = Integer.parseInt(datax.substring(8, 10)); //dia
       
       int anoFinal =  ano1 - anox ;
    
   
       
       
       if(mesx == mes1 && diax == dia1 && anoFinal >= 1){
       
           JOptionPane.showMessageDialog(null, "O cliente " + rs.getString("nome") +" fechou " + anoFinal + " ano com a gente!!! :D");
       sair = 1;
       }

                

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
       
  
  
  
  
  
  
  
  }      
        
        
    public List<Clientes> consultarClientesPorNome1(String nome) {
List<Clientes> lista = new ArrayList<>();
        try {

            String sql = "select * from clientes where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNOME(rs.getString("nome"));
                obj.setDATAVENCIMENTO(rs.getString("datavencimento"));
                obj.setDATAVENCSISTEMA(rs.getString("datavencsistema"));
                obj.setOBS(rs.getString("obs"));
                obj.setFORMAPAG(rs.getString("formapag"));
                lista.add(obj);
            }
            return lista;
            
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }
    
    
         
    public boolean verificarNome(String nome) {
      boolean x = true;
        try {

            String sql = "select * from clientes where nome=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            if (!rs.next()) {
         
           
            x = false;
                   
                  
            }
            
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return x;

    }
    
    
   

  

    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

}
