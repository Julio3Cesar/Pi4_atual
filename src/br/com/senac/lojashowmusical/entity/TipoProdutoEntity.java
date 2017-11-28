package br.com.senac.lojashowmuscial.entity;

import br.com.senac.lojashowmuscial.enums.TipoInstrumentoEnum;

public class TipoProdutoEntity {

    private Integer id_prd;
    private String nome_prd;
    private TipoInstrumentoEnum tipo_prd;

    public TipoProdutoEntity(Integer idProduto, String nome, TipoInstrumentoEnum tipo) {
        this.id_prd = idProduto;
        this.nome_prd = nome;
        this.tipo_prd = tipo;
    }

    public TipoProdutoEntity(String nome, TipoInstrumentoEnum tipo) {
        this.nome_prd = nome;
        this.tipo_prd = tipo;
    }

    public TipoProdutoEntity() {
    }

    public Integer getIdProduto() {
        return id_prd;
    }

    public void setIdProduto(Integer idProduto) {
        this.id_prd = idProduto;
    }

    public String getNome() {
        return nome_prd;
    }

    public void setNome(String nome) {
        this.nome_prd = nome;
    }

    public TipoInstrumentoEnum getTipo() {
        return tipo_prd;
    }

    public void setTipo(TipoInstrumentoEnum tipo) {
        this.tipo_prd = tipo;
    }
}
