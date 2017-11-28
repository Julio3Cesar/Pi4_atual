package br.com.senac.lojashowmuscial.service.impl;

import br.com.senac.lojashowmuscial.dto.ProdutoDTO;
import br.com.senac.lojashowmuscial.exception.ProdutoException;
import br.com.senac.lojashowmuscial.util.Utils;
import br.com.senac.lojashowmusical.dao.impl.ProdutoDaoImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.senac.lojashowmuscial.service.ProdutoService;
import br.com.senac.lojashowmusical.dao.ProdutoDao;

public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoDao daoProduto;
    private static ProdutoService service;

    private ProdutoServiceImpl() throws SQLException {
        this.daoProduto = new ProdutoDaoImpl();
    }

    public static ProdutoService getInstance() {
        if (ProdutoServiceImpl.service == null) {
            try {
                ProdutoServiceImpl.service = new ProdutoServiceImpl();
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
    public void insert(ProdutoDTO p) throws ProdutoException {
        try {
            daoProduto.insert(Utils.toProdutoEntity(p),
                    Utils.toMarcaEntity(p), Utils.toTipoProdutoEntity(p));
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProdutoException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public void update(ProdutoDTO p) throws ProdutoException {
        try {
            daoProduto.update(Utils.toProdutoEntity(p),
                    Utils.toMarcaEntity(p), Utils.toTipoProdutoEntity(p));
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProdutoException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public ProdutoDTO getT(Integer id) throws ProdutoException {
        try {
            return daoProduto.getT(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProdutoException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public ProdutoDTO getT(String codBarras) throws ProdutoException {
        try {
            return daoProduto.getT(codBarras);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProdutoException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public List<ProdutoDTO> listAll() throws ProdutoException {
        try {
            return daoProduto.listAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProdutoException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public void delete(Integer id) throws ProdutoException {
        try {
            daoProduto.delete(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProdutoException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public List<ProdutoDTO> search(String modelo) throws ProdutoException {
        try {
            if (modelo == null || "".equals(modelo)) {
                return daoProduto.listAll();
            } else {
                return daoProduto.search(modelo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProdutoException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }
}
