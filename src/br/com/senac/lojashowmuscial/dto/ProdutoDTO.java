package br.com.senac.lojashowmuscial.dto;

import br.com.senac.lojashowmuscial.entity.ProdutoEntity;
import br.com.senac.lojashowmuscial.entity.MarcaProdutoEntity;
import br.com.senac.lojashowmuscial.enums.TipoInstrumentoEnum;

public class ProdutoDTO {

    private Integer idProduto;
    private String nome;
    private TipoInstrumentoEnum tipo;
    private MarcaDTO marca;
    private DescricaoDTO descricao;

    public ProdutoDTO(Integer idProduto, String nome, TipoInstrumentoEnum tipo,
            MarcaProdutoEntity marca, ProdutoEntity descricao) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.tipo = tipo;
        this.marca = new MarcaDTO(marca.getIdMarca(), marca.getMarca());
        this.descricao = new DescricaoDTO(descricao.getIdDescricao(), descricao.getCor(),
                descricao.getModelo(), descricao.getEstoque(), descricao.getPreco(),
                descricao.getEnable());
    }

    public ProdutoDTO(String nome, String marca, TipoInstrumentoEnum tipo,
            String cor, String modelo, Integer estoque, Double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = new MarcaDTO(marca);
        this.descricao = new DescricaoDTO(cor, modelo, estoque, preco, true);

    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoInstrumentoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoInstrumentoEnum tipo) {
        this.tipo = tipo;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    public DescricaoDTO getDescricao() {
        return descricao;
    }

    public void setDescricao(DescricaoDTO descricao) {
        this.descricao = descricao;
    }

}
