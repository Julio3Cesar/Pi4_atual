package br.com.senac.lojashowmuscial.entity;

import java.util.Date;

public class RelatorioEntity {

    private Date dataVenda;
    private String nomeProduto;
    private Integer quantidadeProduto;
    private Double precoNaVenda;
    private Double total;

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Double getPrecoNaVenda() {
        return precoNaVenda;
    }

    public void setPrecoNaVenda(Double precoNaVenda) {
        this.precoNaVenda = precoNaVenda;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
