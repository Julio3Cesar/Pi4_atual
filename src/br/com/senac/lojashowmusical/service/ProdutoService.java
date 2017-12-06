/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.lojashowmusical.service;

import br.com.senac.lojashowmuscial.exception.ProdutoException;
import br.com.senac.lojashowmusical.dto.ProdutoDTO;
import java.util.List;

/**
 *
 * @author julio
 */
public interface ProdutoService {

    void delete(Integer id) throws ProdutoException;

    ProdutoDTO getT(Integer id) throws ProdutoException;

    ProdutoDTO getT(String codBarras) throws ProdutoException;

    void insert(ProdutoDTO p) throws ProdutoException;

    List<ProdutoDTO> listAll() throws ProdutoException;

    List<ProdutoDTO> search(String modelo) throws ProdutoException;

    void update(ProdutoDTO p) throws ProdutoException;

    void updateEstoque(Integer qtd, String codBarras) throws ProdutoException;

}
