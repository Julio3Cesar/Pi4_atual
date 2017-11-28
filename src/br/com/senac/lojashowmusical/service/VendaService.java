/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.lojashowmuscial.service;

import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.dto.ProdutoDTO;
import br.com.senac.lojashowmuscial.dto.VendaDTO;
import br.com.senac.lojashowmuscial.exception.ClienteException;
import br.com.senac.lojashowmuscial.exception.ProdutoException;
import br.com.senac.lojashowmuscial.exception.VendaException;

/**
 *
 * @author julio
 */
public interface VendaService {

    ClienteDTO getCliente(String cpf) throws ClienteException;

    ProdutoDTO getProduto(String codBarras) throws ProdutoException;

    void insert(VendaDTO venda) throws VendaException;

}
