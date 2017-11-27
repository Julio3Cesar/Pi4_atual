package br.com.senac.lojashowmuscial.bean;

import br.com.senac.lojashowmuscial.dto.ProdutoDTO;

public class ProdutoQtd {

    private ProdutoDTO produto;
    private Integer quantidade;

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
