package br.com.senac.lojashowmuscial.service.impl;

import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.dto.ProdutoDTO;
import br.com.senac.lojashowmuscial.exception.ClienteException;
import br.com.senac.lojashowmusical.dao.ClienteDao;
import br.com.senac.lojashowmusical.dao.ProdutoDao;
import br.com.senac.lojashowmusical.dao.impl.ClienteDaoImpl;
import br.com.senac.lojashowmusical.dao.impl.ProdutoDaoImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VendaServiceImpl {

    private final ProdutoDao daoProduto;
    private final ClienteDao daoCliente;
    private static VendaServiceImpl service;

    private VendaServiceImpl() throws SQLException {
        this.daoProduto = new ProdutoDaoImpl();
        this.daoCliente = new ClienteDaoImpl();
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
        try {
            return this.daoCliente.getT(cpf);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClienteException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    public ProdutoDTO getProduto(String codBarras) throws ClienteException {
        try {
            return this.daoProduto.getT(codBarras);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClienteException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

}
