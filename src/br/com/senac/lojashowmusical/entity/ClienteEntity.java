package br.com.senac.lojashowmuscial.entity;

import br.com.senac.lojashowmuscial.enums.EstadoCivilEnum;
import br.com.senac.lojashowmuscial.enums.SexoEnum;
import java.util.Date;

public class ClienteEntity {

    private Integer id;
    private Integer idEndereco;
    private Integer idContato;
    private String nome;
    private String cpf;
    private String rg;
    private SexoEnum sexo;
    private EstadoCivilEnum estadoCivil;
    private Date dataDeNascimento;
    private Boolean enable;

    public ClienteEntity() {
    }

    public ClienteEntity(Integer id, String nome, String cpf, String rg, SexoEnum sexo, EstadoCivilEnum estadoCivil, Date dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
        this.enable = true;
    }

    public ClienteEntity(String text, String text0, String text1, String text2, String text3, String text4, SexoEnum valueOf, EstadoCivilEnum valueOf0, Date parse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public EstadoCivilEnum getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

}
