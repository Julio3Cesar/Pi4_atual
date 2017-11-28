package br.com.senac.lojashowmusical.service.impl;

import br.com.senac.lojashowmusical.bean.ProdutoQtd;
import br.com.senac.lojashowmuscial.dao.ItemProdutoDao;
import br.com.senac.lojashowmuscial.service.VendaService;
import br.com.senac.lojashowmuscial.dao.VendaDao;
import br.com.senac.lojashowmusical.dao.impl.VendaDaoImpl;
import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.dto.ProdutoDTO;
import br.com.senac.lojashowmuscial.dto.VendaDTO;
import br.com.senac.lojashowmuscial.exception.ClienteException;
import br.com.senac.lojashowmuscial.exception.ProdutoException;
import br.com.senac.lojashowmuscial.exception.VendaException;
import br.com.senac.lojashowmuscial.service.ClienteService;
import br.com.senac.lojashowmuscial.service.ProdutoService;
import br.com.senac.lojashowmuscial.service.impl.ClienteServiceImpl;
import br.com.senac.lojashowmuscial.service.impl.ProdutoServiceImpl;
import br.com.senac.lojashowmuscial.util.Utils;
import br.com.senac.lojashowmusical.dao.impl.ItemProdutoDaoImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VendaServiceImpl implements VendaService {

    private static VendaService service;
    private final ProdutoService produtoService;
    private final ClienteService clienteService;
    private final VendaDao daoVenda;
    private final ItemProdutoDao daoItemProduto;

    private VendaServiceImpl() throws SQLException {
        this.produtoService = ProdutoServiceImpl.getInstance();
        this.clienteService = ClienteServiceImpl.getInstance();
        this.daoVenda = new VendaDaoImpl();
        this.daoItemProduto = new ItemProdutoDaoImpl();
    }

    public static VendaService getInstance() {
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

    @Override
    public ClienteDTO getCliente(String cpf) throws ClienteException {
        return this.clienteService.getT(cpf);
    }

    @Override
    public ProdutoDTO getProduto(String codBarras) throws ProdutoException {
        return this.produtoService.getT(codBarras);
    }

    @Override
    public void insert(VendaDTO venda) throws VendaException {
        try {
            daoVenda.insert(Utils.toVendaEntity(venda));
            for (ProdutoQtd p : venda.getProdutosQtd()) {
                daoItemProduto.insert(Utils.toVendaEntity(daoVenda.getLastId(), p));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new VendaException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }
}
