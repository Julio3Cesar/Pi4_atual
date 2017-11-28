package br.com.senac.lojashowmuscial.entity;

public class ProdutoEntity {

    private Integer id_desc_produto;
    private Integer id_prod;
    private Integer id_marca;
    private String codBarras;
    private String cor_prd;
    private String modelo_prd;
    private Integer estoque_prd;
    private Double preco_prd;
    private Boolean enable;

    public ProdutoEntity() {
    }

    public ProdutoEntity(Integer IdDescricao, Integer idProd, Integer idMarca, String cor, String modelo, Integer estoque, Double preco, String codBarras) {
        this.id_desc_produto = IdDescricao;
        this.id_marca = idMarca;
        this.id_prod = idProd;
        this.cor_prd = cor;
        this.modelo_prd = modelo;
        this.estoque_prd = estoque;
        this.preco_prd = preco;
        this.codBarras = codBarras;
        this.enable = true;
    }

    public ProdutoEntity(Integer idProd, Integer idMarca, String cor, String modelo, Integer estoque, Double preco, String codBarras) {
        this.id_marca = idMarca;
        this.id_prod = idProd;
        this.cor_prd = cor;
        this.modelo_prd = modelo;
        this.estoque_prd = estoque;
        this.preco_prd = preco;
        this.codBarras = codBarras;
        this.enable = true;
    }

    public ProdutoEntity(String cor, String modelo, Integer estoque, Double preco, Boolean enable, String codBarras) {
        this.cor_prd = cor;
        this.modelo_prd = modelo;
        this.estoque_prd = estoque;
        this.preco_prd = preco;
        this.codBarras = codBarras;
        this.enable = enable;
    }

    public Integer getIdDescricao() {
        return id_desc_produto;
    }

    public void setIdDescricao(Integer idDescricao) {
        this.id_desc_produto = idDescricao;
    }

    public Integer getIdMarca() {
        return id_marca;
    }

    public void setIdMarca(Integer idMarca) {
        this.id_marca = idMarca;
    }

    public String getCor() {
        return cor_prd;
    }

    public void setCor(String cor) {
        this.cor_prd = cor;
    }

    public String getModelo() {
        return modelo_prd;
    }

    public void setModelo(String modelo) {
        this.modelo_prd = modelo;
    }

    public Integer getEstoque() {
        return estoque_prd;
    }

    public void setEstoque(Integer estoque) {
        this.estoque_prd = estoque;
    }

    public Double getPreco() {
        return preco_prd;
    }

    public void setPreco(Double preco) {
        this.preco_prd = preco;
    }

    public Integer getIdProd() {
        return id_prod;
    }

    public void setIdProd(Integer idProd) {
        this.id_prod = idProd;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }
}
