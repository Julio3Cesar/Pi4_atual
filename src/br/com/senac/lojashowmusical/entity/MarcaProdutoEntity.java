package br.com.senac.lojashowmuscial.entity;

public class MarcaProdutoEntity {

    private Integer id_marca_prd;
    private String marca_prd;

    public MarcaProdutoEntity(Integer idMarca, String marca) {
        this.id_marca_prd = idMarca;
        this.marca_prd = marca;
    }

    public MarcaProdutoEntity(String marca) {
        this.marca_prd = marca;
    }

    public Integer getIdMarca() {
        return id_marca_prd;
    }

    public void setIdMarca(Integer idMarca) {
        this.id_marca_prd = idMarca;
    }

    public String getMarca() {
        return marca_prd;
    }

    public void setMarca(String marca) {
        this.marca_prd = marca;
    }

}
