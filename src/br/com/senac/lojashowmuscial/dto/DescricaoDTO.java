package br.com.senac.lojashowmuscial.dto;

public class DescricaoDTO {

    private Integer idDescricao;
    private String cor;
    private String modelo;
    private Integer estoque;
    private Double preco;
    private Boolean enable;

    public DescricaoDTO(Integer idDescricao, String cor, String modelo, Integer estoque, Double preco, Boolean enable) {
        this.idDescricao = idDescricao;
        this.cor = cor;
        this.modelo = modelo;
        this.estoque = estoque;
        this.preco = preco;
        this.enable = enable;
    }

    public DescricaoDTO(String cor, String modelo, Integer estoque, Double preco, Boolean enable) {
        this.cor = cor;
        this.modelo = modelo;
        this.estoque = estoque;
        this.preco = preco;
        this.enable = enable;
    }

    public DescricaoDTO(String cor, String modelo, Integer estoque, Double preco) {
        this.cor = cor;
        this.modelo = modelo;
        this.estoque = estoque;
        this.preco = preco;
    }

    public Integer getIdDescricao() {
        return idDescricao;
    }

    public void setIdDescricao(Integer idDescricao) {
        this.idDescricao = idDescricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

}
