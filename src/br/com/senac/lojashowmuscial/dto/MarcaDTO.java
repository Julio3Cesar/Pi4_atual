package br.com.senac.lojashowmuscial.dto;

public class MarcaDTO {

    private Integer idMarca;
    private String marca;

    public MarcaDTO(Integer idMarca, String marca) {
        this.idMarca = idMarca;
        this.marca = marca;
    }

    public MarcaDTO(String marca) {
        this.marca = marca;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
