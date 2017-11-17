/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.lojashowmuscial.service;

import br.com.senac.lojashowmuscial.dto.ProdutoDTO;
import br.com.senac.lojashowmuscial.exception.ProdutoException;
import java.util.List;

/**
 *
 * @author julio
 */
public interface ProdutoService {

    void delete(Integer id) throws ProdutoException;

    ProdutoDTO getT(Integer id) throws ProdutoException;

    void insert(ProdutoDTO p) throws ProdutoException;

    List<ProdutoDTO> listAll() throws ProdutoException;

    List<ProdutoDTO> search(String modelo) throws ProdutoException;

    void update(ProdutoDTO p) throws ProdutoException;
    
}
