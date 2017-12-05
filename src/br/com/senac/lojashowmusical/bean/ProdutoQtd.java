package br.com.senac.lojashowmusical.bean;

import br.com.senac.lojashowmusical.dto.ProdutoDTO;
import java.util.Objects;

public class ProdutoQtd {

    private ProdutoDTO produto;
    private Integer quantidade;

    public ProdutoQtd() {
    }

    public ProdutoQtd(ProdutoDTO produto) {
        this.produto = produto;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProdutoQtd other = (ProdutoQtd) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produto + "quantidade: " + quantidade + "\n";
    }

}
