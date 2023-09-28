package br.ulbra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    private GerenciadorConexao gerenciador;

    public ProdutoDAO() {
        this.gerenciador = GerenciadorConexao.getInstancia();
    }

    public boolean autenticar(String login, String senha) {
        String sql = "SELECT * from TBPRODUTO WHERE login = ? and senhaLogin = ?";
        try {
            PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    public boolean adicionarProduto(String nome, String cod, String estoqu) {
        String sql = "INSERT INTO TBPRODUTO (nomeProd, codProd, estoquProd)"
                + "VALUES (?,?,?)";
        try {
            PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cod);
            stmt.setString(3, estoqu);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto: " + nome + " Inserido com sucesso! ");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
        return false;
    }
    
    
     public boolean lançarProduto(String nome, String quant) {
        String sql = "INSERT INTO TBPRODUTO (nomeProd, quantProd)"
                + "VALUES (?,?)";
        try {
            PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, quant);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lançamento: " + nome + " Inserido com sucesso! ");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
        return false;
    }
    
    
    public List<Produto> read() {
        String sql = "SELECT * FROM tbproduto";
        List<Produto> produtos = new ArrayList<>();

        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setPkProduto(rs.getInt("pkproduto"));
                produto.setNomeProd(rs.getString("nomeprod"));
                produto.setCodProd(rs.getString("codprod"));
                produto.setSenhaLogin(rs.getString("senhalogin"));
                produto.setQuantProd(rs.getString("quantprod"));
                produto.setEstoquProd(rs.getString("estoquprod"));
                produto.setEstoquProd(rs.getString("login"));

                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
    
    public List<Produto> readForDesc(String desc){
        String sql = "SELECT * FROM tbproduto WHERE nomeprod LIKE ?";
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto>  produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Produto produto = new Produto();
                
                produto.setPkProduto(rs.getInt("pkproduto"));
                produto.setNomeProd(rs.getString("nomeprod"));
                produto.setCodProd(rs.getString("codprod"));
                produto.setSenhaLogin(rs.getString("senhalogin"));
                produto.setQuantProd(rs.getString("quantprod"));
                produto.setEstoquProd(rs.getString("estoquprod"));
                produto.setEstoquProd(rs.getString("login"));
                produtos.add(produto);
            }
        }catch (SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null, ex);
        }finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    
    public Produto readForPk(int pk){
        String sql = "SELECT * FROM tbproduto WHERE pkproduto = ?";
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto  produto = new Produto();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk);
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                
                
                produto.setPkProduto(rs.getInt("pkproduto"));
                produto.setNomeProd(rs.getString("nomeprod"));
                produto.setCodProd(rs.getString("codprod"));
                produto.setSenhaLogin(rs.getString("senhalogin"));
                produto.setQuantProd(rs.getString("quantprod"));
                produto.setEstoquProd(rs.getString("estoquprod"));
                produto.setEstoquProd(rs.getString("login"));
            }
        }catch (SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null, ex);
        }finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        
        return produto;
    }
    
    public boolean alterarProduto(Produto u){
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE tbProduto SET nomeproduto = ?,codprod = ?,"
                    +"senhalogin = ?, quantprod = ?, estoquprod = ? WHERE pkproduto = ?");
            stmt.setString(1,u.getNomeProd());
            stmt.setString(2,u.getCodProd());
            stmt.setString(3,u.getSenhaLogin());
            stmt.setString(4,u.getQuantProd());
            stmt.setString(5,u.getEstoquProd());
            stmt.setString(5,u.getLogin());
            stmt.setInt(6,u.getPkProduto());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizacao com sucesso! ");
            return true;
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar : " + ex);
        }finally{
            GerenciadorConexao.closeConnection(con, stmt);
        }
        return false;
    }
    
     public boolean excluirProduto(int pkProduto){
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM tbProduto  WHERE pkproduto = ?");
            
            stmt.setInt(1, pkProduto);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso! ");
            return true;
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir : " + ex);
        }finally{
            GerenciadorConexao.closeConnection(con, stmt);
        }
        return false;
    }


}
