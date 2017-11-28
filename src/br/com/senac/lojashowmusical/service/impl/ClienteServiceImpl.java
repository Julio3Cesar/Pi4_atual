package br.com.senac.lojashowmuscial.service.impl;

import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.exception.ClienteException;
import br.com.senac.lojashowmuscial.util.Utils;
import br.com.senac.lojashowmusical.dao.impl.ClienteDaoImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.senac.lojashowmuscial.service.ClienteService;
import br.com.senac.lojashowmusical.dao.ClienteDao;

public class ClienteServiceImpl implements ClienteService {

    private final ClienteDao daoCliente;
    private static ClienteService service;

    private ClienteServiceImpl() throws SQLException {
        this.daoCliente = new ClienteDaoImpl();
    }

    public static ClienteService getInstance() {
        if (ClienteServiceImpl.service == null) {
            try {
                ClienteServiceImpl.service = new ClienteServiceImpl();
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
    public void insert(ClienteDTO cli) throws ClienteException {
        try {
            daoCliente.insert(Utils.toClienteEntity(cli),
                    Utils.toEnderecoEntity(cli), Utils.toContatoEntity(cli));
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClienteException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public void update(ClienteDTO cli) throws ClienteException {
        try {
            daoCliente.update(Utils.toClienteEntity(cli),
                    Utils.toEnderecoEntity(cli), Utils.toContatoEntity(cli));
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClienteException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public ClienteDTO getT(Integer id) throws ClienteException {
        try {
            return daoCliente.getT(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClienteException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public ClienteDTO getT(String cpf) throws ClienteException {
        try {
            return daoCliente.getT(cpf);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClienteException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public List<ClienteDTO> listAll() throws ClienteException {
        try {
            return daoCliente.listAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClienteException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public void delete(Integer id) throws ClienteException {
        try {
            daoCliente.delete(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClienteException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }

    @Override
    public List<ClienteDTO> search(String nome) throws ClienteException {
        try {
            if (nome == null || "".equals(nome)) {
                return daoCliente.listAll();
            } else {
                return daoCliente.search(nome);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ClienteException("Algo deu errado entre em contato "
                    + "com os desenvolvedores.");
        }
    }
}
