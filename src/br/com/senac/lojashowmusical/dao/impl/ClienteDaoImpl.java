package br.com.senac.lojashowmusical.dao.impl;

import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.entity.ClienteEntity;
import br.com.senac.lojashowmuscial.entity.ContatoEntity;
import br.com.senac.lojashowmuscial.entity.EnderecoEntity;
import br.com.senac.lojashowmuscial.enums.EstadoCivilEnum;
import br.com.senac.lojashowmuscial.enums.SexoEnum;
import br.com.senac.lojashowmuscial.factory.ConnectionFactory;
import br.com.senac.lojashowmuscial.util.Utils;
import br.com.senac.lojashowmusical.dao.ClienteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public void insert(ClienteEntity c, EnderecoEntity e, ContatoEntity co) throws SQLException {
        String sql = "BEGIN "
                + "INSERT INTO ENDERECO_CLIENTE "
                + "(CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, "
                + "UF)"
                + " VALUES (?, ?, ?, ?, ?, ?)"
                + "INSERT INTO CONTATO_CLIENTE "
                + "(TELEFONE, CELULAR, EMAIL)"
                + " VALUES (?, ?, ?)"
                + " INSERT INTO cliente "
                + "(ID_ENDERECO_CLIENTE, ID_CONTATO_CLIENTE, NOME_CLIENTE, "
                + "CPF_CLIENTE, RG_CLIENTE, "
                + "SEXO_CLIENTE,ESTADO_CIVIL_CLIENTE,DT_NASCIMENTO_CLIENTE, ENABLE) "
                + "VALUES ((SELECT MAX(ID_ENDERECO_CLIENTE) FROM ENDERECO_CLIENTE), "
                + "(SELECT MAX(ID_CONTATO_CLIENTE) FROM CONTATO_CLIENTE), "
                + "?, ?, ?, ?, ?, ?, ?) "
                + "END;";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, e.getCep());
            pst.setString(2, e.getLogradouro());
            pst.setString(3, e.getNumero());
            pst.setString(4, e.getBairro());
            pst.setString(5, e.getCidade());
            pst.setString(6, e.getUf());

            pst.setString(7, co.getTelefone());
            pst.setString(8, co.getCelular());
            pst.setString(9, co.getEmail());

            pst.setString(10, c.getNome());
            pst.setString(11, c.getCpf());
            pst.setString(12, c.getRg());
            pst.setString(13, c.getSexo().getName());
            pst.setString(14, c.getEstadoCivil().getName());
            pst.setTimestamp(15, new Timestamp(c.getDataDeNascimento().getTime()));
            pst.setBoolean(16, true);

            pst.execute();
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }
    }

    @Override
    public List<ClienteDTO> listAll() throws SQLException {
        List<ClienteDTO> resp = new ArrayList<>();
        String sql = "SELECT * FROM ENDERECO_CLIENTE AS E, CONTATO_CLIENTE AS CO, "
                + "CLIENTE AS C WHERE C.ID_ENDERECO_CLIENTE=E.ID_ENDERECO_CLIENTE AND "
                + "C.ID_CONTATO_CLIENTE=CO.ID_CONTATO_CLIENTE AND C.ENABLE=?";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setBoolean(1, true);
            rs = pst.executeQuery();

            while (rs.next()) {
                ClienteEntity c = new ClienteEntity();
                c.setId(rs.getInt("ID_CLIENTE"));
//                c.setIdEndereco(rs.getInt("ID_ENDERECO_CLIENTE"));
//                c.setIdContato(rs.getInt("ID_CONTATO_CLIENTE"));
                c.setNome(rs.getString("NOME_CLIENTE"));
                c.setCpf(rs.getString("CPF_CLIENTE"));
                c.setRg(rs.getString("RG_CLIENTE"));
                c.setSexo(SexoEnum.valueOf(rs.getString("SEXO_CLIENTE")));
                c.setEstadoCivil(EstadoCivilEnum.valueOf(rs.getString("ESTADO_CIVIL_CLIENTE")));
                c.setDataDeNascimento(new Date(rs.getTimestamp("DT_NASCIMENTO_CLIENTE").getTime()));
                c.setEnable(rs.getBoolean("ENABLE"));

                EnderecoEntity e = new EnderecoEntity();
                e.setBairro(rs.getString("BAIRRO"));
                e.setCep(rs.getString("CEP"));
                e.setLogradouro(rs.getString("LOGRADOURO"));
                e.setNumero(rs.getString("NUMERO"));
                e.setCidade(rs.getString("CIDADE"));
                e.setUf(rs.getString("UF"));

                ContatoEntity co = new ContatoEntity(rs.getString("TELEFONE"),
                        rs.getString("CELULAR"), rs.getString("EMAIL"));

                resp.add(Utils.toClienteDTO(c, e, co));
            }

        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return resp;
    }

    @Override
    public ClienteDTO getT(Integer id) throws SQLException {
        ClienteDTO resp;
        String sql = "SELECT * FROM ENDERECO_CLIENTE AS E, CONTATO_CLIENTE AS CO, "
                + "CLIENTE AS C WHERE C.ID_ENDERECO_CLIENTE=E.ID_ENDERECO_CLIENTE AND "
                + "C.ID_CONTATO_CLIENTE=CO.ID_CONTATO_CLIENTE AND ID_CLIENTE=?";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            rs.next();
            ClienteEntity c = new ClienteEntity();
            c.setId(rs.getInt("ID_CLIENTE"));
            c.setIdEndereco(rs.getInt("ID_ENDERECO_CLIENTE"));
            c.setIdContato(rs.getInt("ID_CONTATO_CLIENTE"));
            c.setNome(rs.getString("NOME_CLIENTE"));
            c.setCpf(rs.getString("CPF_CLIENTE"));
            c.setRg(rs.getString("RG_CLIENTE"));
            c.setSexo(SexoEnum.valueOf(rs.getString("SEXO_CLIENTE")));
            c.setEstadoCivil(EstadoCivilEnum.valueOf(rs.getString("ESTADO_CIVIL_CLIENTE")));
            c.setDataDeNascimento(new Date(rs.getTimestamp("DT_NASCIMENTO_CLIENTE").getTime()));
            c.setEnable(rs.getBoolean("ENABLE"));

            EnderecoEntity e = new EnderecoEntity();
            e.setBairro(rs.getString("BAIRRO"));
            e.setCep(rs.getString("CEP"));
            e.setLogradouro(rs.getString("LOGRADOURO"));
            e.setNumero(rs.getString("NUMERO"));
            e.setCidade(rs.getString("CIDADE"));
            e.setUf(rs.getString("UF"));

            ContatoEntity co = new ContatoEntity(rs.getString("TELEFONE"),
                    rs.getString("CELULAR"), rs.getString("EMAIL"));

            resp = Utils.toClienteDTO(c, e, co);

        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return resp;
    }

    @Override
    public void update(ClienteEntity c, EnderecoEntity e, ContatoEntity co) throws SQLException {
        String sql = "UPDATE ENDERECO_CLIENTE SET CEP=?, LOGRADOURO=?, NUMERO=?, "
                + "BAIRRO=?, CIDADE=?, UF=? WHERE ID_ENDERECO_CLIENTE="
                + "(SELECT ID_ENDERECO_CLIENTE FROM CLIENTE WHERE ID_CLIENTE=?) "
                + "UPDATE CONTATO_CLIENTE SET TELEFONE=?, CELULAR=?, EMAIL=? "
                + "WHERE ID_CONTATO_CLIENTE="
                + "(SELECT ID_CONTATO_CLIENTE FROM CLIENTE WHERE ID_CLIENTE=?) "
                + "UPDATE CLIENTE SET "
                + "NOME_CLIENTE=?, CPF_CLIENTE=?, RG_CLIENTE=?, "
                + "SEXO_CLIENTE=?, ESTADO_CIVIL_CLIENTE=?, DT_NASCIMENTO_CLIENTE=? "
                + "WHERE ID_CLIENTE=?";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, e.getCep());
            pst.setString(2, e.getLogradouro());
            pst.setString(3, e.getNumero());
            pst.setString(4, e.getBairro());
            pst.setString(5, e.getCidade());
            pst.setString(6, e.getUf());
            pst.setInt(7, c.getId());

            pst.setString(8, co.getTelefone());
            pst.setString(9, co.getCelular());
            pst.setString(10, co.getEmail());
            pst.setInt(11, c.getId());

            pst.setString(12, c.getNome());
            pst.setString(13, c.getCpf());
            pst.setString(14, c.getRg());
            pst.setString(15, c.getSexo().getName());
            pst.setString(16, c.getEstadoCivil().getName());
            pst.setTimestamp(17, new Timestamp(c.getDataDeNascimento().getTime()));
            pst.setInt(18, c.getId());

            pst.execute();

        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "UPDATE CLIENTE SET enable=? WHERE ID_CLIENTE=?";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setBoolean(1, false);
            pst.setInt(2, id);
            pst.execute();

        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }
    }

    @Override
    public List<ClienteDTO> search(String nome) throws SQLException {
        List<ClienteDTO> resp = new ArrayList<>();
        String sql = "SELECT * FROM ENDERECO_CLIENTE AS E, CONTATO_CLIENTE AS CO, "
                + "CLIENTE AS C WHERE ((UPPER(NOME_CLIENTE) LIKE UPPER(?)) "
                + "AND ENABLE=?) AND E.ID_ENDERECO_CLIENTE=C.ID_ENDERECO_CLIENTE AND "
                + "CO.ID_CONTATO_CLIENTE=C.ID_CONTATO_CLIENTE";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + nome + "%");
            pst.setBoolean(2, true);

            rs = pst.executeQuery();

            while (rs.next()) {
                ClienteEntity c = new ClienteEntity();
                c.setId(rs.getInt("ID_CLIENTE"));
//                c.setIdEndereco(rs.getInt("C.ID_ENDERECO_CLIENTE"));
//                c.setIdContato(rs.getInt("C.ID_CONTATO_CLIENTE"));
                c.setNome(rs.getString("NOME_CLIENTE"));
                c.setCpf(rs.getString("CPF_CLIENTE"));
                c.setRg(rs.getString("RG_CLIENTE"));
                c.setSexo(SexoEnum.valueOf(rs.getString("SEXO_CLIENTE")));
                c.setEstadoCivil(EstadoCivilEnum.valueOf(rs.getString("ESTADO_CIVIL_CLIENTE")));
                c.setDataDeNascimento(new Date(rs.getTimestamp("DT_NASCIMENTO_CLIENTE").getTime()));
                c.setEnable(rs.getBoolean("ENABLE"));

                EnderecoEntity e = new EnderecoEntity();
                e.setBairro(rs.getString("BAIRRO"));
                e.setCep(rs.getString("CEP"));
                e.setLogradouro(rs.getString("LOGRADOURO"));
                e.setNumero(rs.getString("NUMERO"));
                e.setCidade(rs.getString("CIDADE"));
                e.setUf(rs.getString("UF"));

                ContatoEntity co = new ContatoEntity(rs.getString("TELEFONE"),
                        rs.getString("CELULAR"), rs.getString("EMAIL"));

                resp.add(Utils.toClienteDTO(c, e, co));
            }
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }
        return resp;
    }
}
