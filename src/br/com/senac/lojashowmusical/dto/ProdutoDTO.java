package br.com.senac.lojashowmusical.dto;

import br.com.senac.lojashowmuscial.dto.DescricaoDTO;
import br.com.senac.lojashowmuscial.dto.MarcaDTO;
import br.com.senac.lojashowmuscial.entity.ProdutoEntity;
import br.com.senac.lojashowmuscial.entity.MarcaProdutoEntity;
import br.com.senac.lojashowmuscial.enums.TipoInstrumentoEnum;
import java.util.Objects;

public class ProdutoDTO {

    private Integer idProduto;
    private String codBarras;
    private String nome;
    private TipoInstrumentoEnum tipo;
    private MarcaDTO marca;
    private DescricaoDTO descricao;

    public ProdutoDTO(Integer idProduto, String nome, TipoInstrumentoEnum tipo,
            MarcaProdutoEntity marca, ProdutoEntity descricao, String codBarras) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.tipo = tipo;
        this.codBarras = codBarras;
        this.marca = new MarcaDTO(marca.getIdMarca(), marca.getMarca());
        this.descricao = new DescricaoDTO(descricao.getIdDescricao(), descricao.getCor(),
                descricao.getModelo(), descricao.getEstoque(), descricao.getPreco(),
                descricao.getEnable());
    }

    public ProdutoDTO(String nome, String marca, TipoInstrumentoEnum tipo,
            String cor, String modelo, Integer estoque, Double preco, String codBarras) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = new MarcaDTO(marca);
        this.codBarras = codBarras;
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

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
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
        final ProdutoDTO other = (ProdutoDTO) obj;
        if (!Objects.equals(this.codBarras, other.codBarras)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome + " " + marca.getMarca()
                + "  " + descricao.getModelo() + "\n";
    }

}
