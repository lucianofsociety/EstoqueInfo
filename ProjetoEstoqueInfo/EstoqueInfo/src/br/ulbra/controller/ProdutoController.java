package br.ulbra.controller;

import br.ulbra.model.Produto;
import br.ulbra.model.ProdutoDAO;
import java.util.List;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        produtoDAO = new ProdutoDAO();
    }

    public boolean adicionarProduto(String nome, String cod
            , String estoqu) {
        return produtoDAO.adicionarProduto(nome, cod, estoqu);
    }
    
    public List<Produto> readForDesc(String desc){
        return produtoDAO.readForDesc(desc);
    }
    
     public Produto readForPk(int pk){
        return produtoDAO.readForPk(pk);
    }
     
     public boolean alterarProduto(Produto u){
         return produtoDAO.alterarProduto(u);
     }
     
     public boolean excluirProduto(int pkProduto){
         return produtoDAO.excluirProduto(pkProduto);
     }
}
