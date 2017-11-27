package br.com.senac.lojashowmuscial.service.impl;

import br.com.senac.lojashowmuscial.dao.impl.VendaDaoImpl;
import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.dto.ProdutoDTO;
import br.com.senac.lojashowmuscial.exception.ClienteException;
import br.com.senac.lojashowmuscial.exception.ProdutoException;
import br.com.senac.lojashowmuscial.service.ClienteService;
import br.com.senac.lojashowmuscial.service.ProdutoService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VendaServiceImpl {

    private final ProdutoService produtoService;
    private final ClienteService clienteService;
    private static VendaServiceImpl service;
    private VendaDaoImpl dao;

    private VendaServiceImpl() throws SQLException {
        this.produtoService = ProdutoServiceImpl.getInstance();
        this.clienteService = ClienteServiceImpl.getInstance();
    }

    public static VendaServiceImpl getInstance() {
        if (VendaServiceImpl.service == null) {
            try {
                VendaServiceImpl.service = new VendaServiceImpl();
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Algo deu errado entre em contato "
                        + "com os desenvolvedores.");
            }
        }
        return service;
    }

    public ClienteDTO getCliente(String cpf) throws ClienteException {
        return this.clienteService.getT(cpf);
    }

    public ProdutoDTO getProduto(String codBarras) throws ProdutoException {
        return this.produtoService.getT(codBarras);
    }

}
