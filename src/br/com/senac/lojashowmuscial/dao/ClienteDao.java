/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.lojashowmusical.dao;

import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.entity.ClienteEntity;
import br.com.senac.lojashowmuscial.entity.ContatoEntity;
import br.com.senac.lojashowmuscial.entity.EnderecoEntity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author julio
 */
public interface ClienteDao {

    void delete(Integer id) throws SQLException;

    ClienteDTO getT(Integer id) throws SQLException;

    void insert(ClienteEntity c, EnderecoEntity e, ContatoEntity co) throws SQLException;

    List<ClienteDTO> listAll() throws SQLException;

    List<ClienteDTO> search(String nome) throws SQLException;

    void update(ClienteEntity c, EnderecoEntity e, ContatoEntity co) throws SQLException;

    ClienteDTO getT(String cpf) throws SQLException;
}
