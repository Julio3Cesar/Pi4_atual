package br.com.senac.lojashowmusical.dao.impl;

import br.com.senac.lojashowmuscial.dao.RelatorioDetalhadoDao;
import br.com.senac.lojashowmuscial.entity.RelatorioDetalhadoEntity;
import br.com.senac.lojashowmuscial.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelatorioDetalhadoDaoImpl implements RelatorioDetalhadoDao {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public List<RelatorioDetalhadoEntity> listBetweenDates(Date dtInicial, Date dtFinal) throws SQLException {
        List<RelatorioDetalhadoEntity> resp = new ArrayList<>();
        String sql = "SELECT * FROM RELATORIO_DETALHADO WHERE DATA_DA_VENDA BETWEEN ? AND ?";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setTimestamp(1, new Timestamp(dtInicial.getTime()));
            pst.setTimestamp(2, new Timestamp(dtFinal.getTime()));
            rs = pst.executeQuery();

            while (rs.next()) {
                RelatorioDetalhadoEntity r = new RelatorioDetalhadoEntity();
                r.setDataVenda(new Date(rs.getTimestamp("DATA_DA_VENDA").getTime()));
                r.setNomeProduto(rs.getString("NOME_PRD"));
                r.setPrecoNaVenda(rs.getDouble("PRECO_ORIGINAL_PRODUTO"));
                r.setQuantidadeProduto(rs.getInt("QTD"));
                r.setTotal(rs.getDouble("TOTAL_PERIODO"));

                resp.add(r);
            }

        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return resp;
    }
}
