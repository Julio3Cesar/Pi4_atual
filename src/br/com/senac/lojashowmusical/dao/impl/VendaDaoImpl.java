package br.com.senac.lojashowmusical.dao.impl;

import br.com.senac.lojashowmuscial.dao.VendaDao;
import br.com.senac.lojashowmuscial.entity.VendaEntity;
import br.com.senac.lojashowmuscial.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class VendaDaoImpl implements VendaDao {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public void insert(VendaEntity v) throws SQLException {

        String sql = "INSERT INTO VENDA (ID_CLIENTE, TIPO_PAGAMENTO, PARCELAS, "
                + "PRECO_TOTAL_VENDA, DATA_DA_VENDA) VALUES "
                + "(?, ?, ?, ?, ?)";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, v.getIdCliente());
            pst.setString(2, v.getTipoPagamento().getName());
            pst.setInt(3, v.getParcelas());
            pst.setDouble(4, v.getPrecoTotalVenda());
            pst.setTimestamp(5, new Timestamp(v.getDataVenda().getTime()));

            pst.execute();
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }
    }

    @Override
    public Integer getLastId() throws SQLException {
        Integer resp;
        String sql = "SELECT MAX(ID_VENDA) FROM VENDA";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            rs.next();
            resp = rs.getInt("ID_VENDA");

        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return resp;
    }

}
