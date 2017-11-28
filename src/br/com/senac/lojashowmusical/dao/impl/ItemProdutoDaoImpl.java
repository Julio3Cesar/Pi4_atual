package br.com.senac.lojashowmusical.dao.impl;

import br.com.senac.lojashowmuscial.dao.ItemProdutoDao;
import br.com.senac.lojashowmuscial.entity.ItensVendaEntity;
import br.com.senac.lojashowmuscial.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemProdutoDaoImpl implements ItemProdutoDao {

    private Connection conn;
    private PreparedStatement pst;

    @Override
    public void insert(ItensVendaEntity item) throws SQLException {

        String sql = "INSERT INTO ITENS_VENDA (ID_VENDA, ID_DESC_PRD, QTD, "
                + "PRECO_ORIGINAL_PROTUDO) VALUES "
                + "(?, ?, ?, ?)";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, item.getIdVenda());
            pst.setInt(2, item.getIdDescProd());
            pst.setInt(3, item.getQuantidade());
            pst.setDouble(4, item.getPrecoOriginalProduto());

            pst.execute();
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }
    }
}
