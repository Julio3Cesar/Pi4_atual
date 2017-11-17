/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.lojashowmusical.dao;

import br.com.senac.lojashowmuscial.dto.ProdutoDTO;
import br.com.senac.lojashowmuscial.entity.MarcaProdutoEntity;
import br.com.senac.lojashowmuscial.entity.ProdutoEntity;
import br.com.senac.lojashowmuscial.entity.TipoProdutoEntity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author julio
 */
public interface ProdutoDao {

    void delete(Integer id) throws SQLException;

    ProdutoDTO getT(Integer id) throws SQLException;

    void insert(ProdutoEntity d, MarcaProdutoEntity m, TipoProdutoEntity p) throws SQLException;

    List<ProdutoDTO> listAll() throws SQLException;

    List<ProdutoDTO> search(String modelo) throws SQLException;

    void update(ProdutoEntity d, MarcaProdutoEntity m, TipoProdutoEntity p) throws SQLException;
    
}
