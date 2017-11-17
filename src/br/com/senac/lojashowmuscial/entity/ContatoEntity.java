package br.com.senac.lojashowmuscial.entity;

public class ContatoEntity {

    private Integer idContato;
    private String telefone;
    private String celular;
    private String email;

    public ContatoEntity(String telefone, String celular, String email) {
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
