package br.com.senac.lojashowmusical.entity;

public class ItensVendaEntity {

    private Integer idVenda;
    private Integer idDescProd;
    private Integer quantidade;
    private Double precoOriginalProduto;

    public ItensVendaEntity(Integer idVenda, Integer idDescProd, Integer quantidade, Double precoOriginalProduto) {
        this.idVenda = idVenda;
        this.idDescProd = idDescProd;
        this.quantidade = quantidade;
        this.precoOriginalProduto = precoOriginalProduto;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getIdDescProd() {
        return idDescProd;
    }

    public void setIdDescProd(Integer idDescProd) {
        this.idDescProd = idDescProd;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoOriginalProduto() {
        return precoOriginalProduto;
    }

    public void setPrecoOriginalProduto(Double precoOriginalProduto) {
        this.precoOriginalProduto = precoOriginalProduto;
    }

}
