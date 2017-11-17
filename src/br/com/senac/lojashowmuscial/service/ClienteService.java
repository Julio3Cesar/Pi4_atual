/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.lojashowmuscial.service;

import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.exception.ClienteException;
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
    
}
