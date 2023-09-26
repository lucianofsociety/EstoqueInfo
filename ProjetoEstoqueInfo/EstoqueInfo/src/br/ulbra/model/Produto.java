package br.ulbra.model;

public class Produto {

    private int pkProduto;
    private String nomeProd;
    private String codProd;
    private String quantProd;
    private String estoquProd;
    private String senhaLogin;

    public String getEstoquProd() {
        return estoquProd;
    }

    public void setEstoquProd(String estoquProd) {
        this.estoquProd = estoquProd;
    }
    

    public int getPkProduto() {
        return pkProduto;
    }

    public void setPkProduto(int pkProduto) {
        this.pkProduto = pkProduto;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public String getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(String senhaLogin) {
        this.senhaLogin = senhaLogin;
    }

    public String getQuantProd() {
        return quantProd;
    }

    public void setQuantProd(String quantProd) {
        this.quantProd = quantProd;
    }

    @Override
    public String toString() {
        return "USUARIO (" + "pkProduto+" + pkProduto + ",nomeProd+" + nomeProd
                + ",codProd+" + codProd + ",quantProd+" + quantProd
                + ",senhaLogin+" + senhaLogin + );
    }

}

