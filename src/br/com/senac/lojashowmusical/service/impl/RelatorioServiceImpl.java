package br.com.senac.lojashowmuscial.service.impl;

import br.com.senac.lojashowmuscial.exception.RelatorioException;
import br.com.senac.lojashowmuscial.dao.RelatorioDetalhadoDao;
import br.com.senac.lojashowmuscial.dao.RelatorioGeralDao;
import br.com.senac.lojashowmuscial.dao.impl.RelatorioDetalhadoDaoImpl;
import br.com.senac.lojashowmuscial.dao.impl.RelatorioGeralDaoImpl;
import br.com.senac.lojashowmuscial.entity.RelatorioDetalhadoEntity;
import br.com.senac.lojashowmuscial.entity.RelatorioGeralEntity;
import br.com.senac.lojashowmuscial.service.RelatorioService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RelatorioServiceImpl implements RelatorioService {

    private final RelatorioGeralDao daoRelatorioGeral;
    private final RelatorioDetalhadoDao daoRelatorioDetalhado;
    private static RelatorioService service;

    private RelatorioServiceImpl() throws SQLException {
        this.daoRelatorioGeral = new RelatorioGeralDaoImpl();
        this.daoRelatorioDetalhado = new RelatorioDetalhadoDaoImpl();
    }

    public static RelatorioService getInstance() {
        if (RelatorioServiceImpl.service == null) {
            try {
                RelatorioServiceImpl.service = new RelatorioServiceImpl();
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
    public List<RelatorioGeralEntity> getAllRelatorioGeral() throws RelatorioException {
        try {
            return daoRelatorioGeral.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RelatorioException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public List<RelatorioDetalhadoEntity> getAllRelatorioDetalhado() throws RelatorioException {
        try {
            return daoRelatorioDetalhado.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RelatorioException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }
}
