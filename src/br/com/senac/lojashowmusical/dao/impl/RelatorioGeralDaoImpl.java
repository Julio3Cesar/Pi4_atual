package br.com.senac.lojashowmusical.dao.impl;

import br.com.senac.lojashowmuscial.dao.RelatorioGeralDao;
import br.com.senac.lojashowmuscial.entity.RelatorioGeralEntity;
import br.com.senac.lojashowmuscial.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelatorioGeralDaoImpl implements RelatorioGeralDao {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public List<RelatorioGeralEntity> listBetweenDates(Date dtInicial, Date dtFinal) throws SQLException {
        List<RelatorioGeralEntity> resp = new ArrayList<>();
        String sql = "SELECT * FROM RELATORIO_GERAL WHERE DATA_DA_VENDA BETWEEN ? AND ?";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setTimestamp(1, new Timestamp(dtInicial.getTime()));
            pst.setTimestamp(2, new Timestamp(dtFinal.getTime()));
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
