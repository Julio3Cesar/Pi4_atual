package br.com.senac.lojashowmusical.service;

import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.exception.ClienteException;
import br.com.senac.lojashowmuscial.exception.ProdutoException;
import br.com.senac.lojashowmuscial.exception.VendaException;
import br.com.senac.lojashowmusical.dto.ProdutoDTO;
import br.com.senac.lojashowmusical.dto.VendaDTO;

public interface VendaService {

    ClienteDTO getCliente(String cpf) throws ClienteException;

    ProdutoDTO getProduto(String codBarras) throws ProdutoException;

    void insert(VendaDTO venda) throws VendaException;

}
