package br.com.senac.lojashowmuscial.dto;

import br.com.senac.lojashowmuscial.enums.EstadoCivilEnum;
import br.com.senac.lojashowmuscial.enums.SexoEnum;
import java.util.Date;

public class ClienteDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private SexoEnum sexo;
    private EstadoCivilEnum estadoCivil;
    private Date dataDeNascimento;
    private EnderecoDTO endereco;
    private ContatoDTO contato;

    public ClienteDTO(Integer id, EnderecoDTO endereco, ContatoDTO contato, String nome, String cpf, String rg, SexoEnum sexo, EstadoCivilEnum estadoCivil, Date dataDeNascimento) {
        this.id = id;
        this.endereco = endereco;
        this.contato = contato;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
    }

    public ClienteDTO(String nome, String cpf, String rg, SexoEnum sexo, EstadoCivilEnum estadoCivil, Date dataDeNascimento, EnderecoDTO endereco, ContatoDTO contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public ContatoDTO getContato() {
        return contato;
    }

    public void setContato(ContatoDTO contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
