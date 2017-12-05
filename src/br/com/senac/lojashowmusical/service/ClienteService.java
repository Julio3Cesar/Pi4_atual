/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.lojashowmusical.service;

import br.com.senac.lojashowmuscial.exception.ClienteException;
import br.com.senac.lojashowmusical.dto.ClienteDTO;
import java.util.List;

/**
 *
 * @author julio
 */
public interface ClienteService {

    void delete(Integer id) throws ClienteException;

    ClienteDTO getT(Integer id) throws ClienteException;

    void insert(ClienteDTO cli) throws ClienteException;

    List<ClienteDTO> listAll() throws ClienteException;

    List<ClienteDTO> search(String nome) throws ClienteException;

    void update(ClienteDTO cli) throws ClienteException;

    ClienteDTO getT(String cpf) throws ClienteException;
}
