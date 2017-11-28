package br.com.senac.lojashowmusical.dao.impl;

import br.com.senac.lojashowmuscial.dao.RelatorioGeralDao;
import br.com.senac.lojashowmuscial.entity.RelatorioGeralEntity;
import br.com.senac.lojashowmuscial.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelatorioGeralDaoImpl implements RelatorioGeralDao {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public List<RelatorioGeralEntity> listAll() throws SQLException {
        List<RelatorioGeralEntity> resp = new ArrayList<>();
        String sql = "SELECT * FROM RELATORIO_GERAL";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                RelatorioGeralEntity r = new RelatorioGeralEntity();
                r.setDataVenda(new Date(rs.getTimestamp("DATA_DA_VENDA").getTime()));
                r.setAVista(rs.getInt("A_VISTA"));
                r.setParceladas(rs.getInt("PARCELADO"));
                r.setTotalVendasRealizadas(rs.getInt("TOTAL_DE_VENDAS"));

                resp.add(r);
            }

        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return resp;
    }
}
