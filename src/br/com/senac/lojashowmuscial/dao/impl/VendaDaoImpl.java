package br.com.senac.lojashowmuscial.dao.impl;

import br.com.senac.lojashowmuscial.entity.ItensVendaEntity;
import br.com.senac.lojashowmuscial.entity.VendaEntity;
import br.com.senac.lojashowmuscial.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaDaoImpl {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    public void insert(VendaEntity v, ItensVendaEntity iV) throws SQLException {

        String sql = "BEGIN "
                + "IF NOT EXISTS (SELECT ID_TIPO_PRD FROM TIPO_PRODUTO WHERE TIPO_PRD=? AND NOME_PRD=?)"
                + "BEGIN "
                + "INSERT INTO TIPO_PRODUTO (TIPO_PRD, NOME_PRD) VALUES(?,?); "
                + "END;"
                + "IF NOT EXISTS (SELECT ID_MARCA_PRD FROM marca_produto WHERE MARCA_PRD=?) "
                + "BEGIN "
                + "INSERT INTO marca_produto (MARCA_PRD) VALUES(?); "
                + "END;"
                + "IF NOT EXISTS (SELECT ID_TIPO_PRD FROM PRODUTO WHERE ID_TIPO_PRD=(SELECT ID_TIPO_PRD FROM TIPO_PRODUTO WHERE TIPO_PRD=? AND NOME_PRD=?) "
                + " AND ID_MARCA_PRD=(SELECT ID_MARCA_PRD FROM marca_produto WHERE MARCA_PRD=?) AND MODELO_PRD=?) "
                + "BEGIN "
                + "INSERT INTO PRODUTO(ID_MARCA_PRD, ID_TIPO_PRD,"
                + "MODELO_PRD, COR_PRD, PRECO_PRD, QTD_EM_ESTOQUE_PRD, COD_BARRAS, ENABLE) "
                + "VALUES((SELECT ID_MARCA_PRD FROM marca_produto WHERE MARCA_PRD=?),"
                + "(SELECT ID_TIPO_PRD FROM TIPO_PRODUTO WHERE TIPO_PRD=? AND NOME_PRD=?), "
                + "?, ?, ?, ?, ?, ?); "
                + "END; "
                + "END;";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setString(1, p.getTipo().getName());
            pst.setString(2, p.getNome());
            pst.setString(3, p.getTipo().getName());
            pst.setString(4, p.getNome());

            pst.setString(5, m.getMarca());
            pst.setString(6, m.getMarca());

            pst.setString(7, p.getTipo().getName());
            pst.setString(8, p.getNome());

            pst.setString(9, m.getMarca());
            pst.setString(10, d.getModelo());

            pst.setString(11, m.getMarca());
            pst.setString(12, p.getTipo().getName());
            pst.setString(13, p.getNome());
            pst.setString(14, d.getModelo());
            pst.setString(15, d.getCor());
            pst.setDouble(16, d.getPreco());
            pst.setInt(17, d.getEstoque());
            pst.setString(18, d.getCodBarras());
            pst.setBoolean(19, true);

            pst.execute();
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }
    }
}
