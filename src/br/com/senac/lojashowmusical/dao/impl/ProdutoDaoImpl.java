package br.com.senac.lojashowmusical.dao.impl;

import br.com.senac.lojashowmuscial.entity.MarcaProdutoEntity;
import br.com.senac.lojashowmuscial.entity.ProdutoEntity;
import br.com.senac.lojashowmuscial.entity.TipoProdutoEntity;
import br.com.senac.lojashowmuscial.enums.TipoInstrumentoEnum;
import br.com.senac.lojashowmuscial.factory.ConnectionFactory;
import br.com.senac.lojashowmusical.dao.ProdutoDao;
import br.com.senac.lojashowmusical.dto.ProdutoDTO;
import br.com.senac.lojashowmusical.util.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDaoImpl implements ProdutoDao {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    private ProdutoEntity descricao;
    private MarcaProdutoEntity marca;
    private TipoProdutoEntity produto;
    private List<ProdutoDTO> prodsDTO;
    private ProdutoDTO prodDTO;

    @Override
    public void insert(ProdutoEntity d, MarcaProdutoEntity m, TipoProdutoEntity p) throws SQLException {

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

    @Override
    public List<ProdutoDTO> listAll() throws SQLException {
        this.prodsDTO = new ArrayList<>();
        String sql = "SELECT * FROM TIPO_PRODUTO AS T, PRODUTO AS D, "
                + "marca_produto AS M WHERE enable=? AND T.ID_TIPO_PRD=D.ID_TIPO_PRD AND M.ID_MARCA_PRD=D.ID_MARCA_PRD";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setBoolean(1, true);
            rs = pst.executeQuery();

            while (rs.next()) {
                this.descricao = new ProdutoEntity();
                descricao.setIdDescricao(rs.getInt("ID_DESC_PRD"));
                this.descricao.setCodBarras(rs.getString("COD_BARRAS"));
                descricao.setModelo(rs.getString("MODELO_PRD"));
                descricao.setCor(rs.getString("COR_PRD"));
                descricao.setEstoque(rs.getInt("QTD_EM_ESTOQUE_PRD"));
                descricao.setPreco(rs.getDouble("PRECO_PRD"));
                descricao.setEnable(rs.getBoolean("ENABLE"));

                this.produto = new TipoProdutoEntity(rs.getString("NOME_PRD"),
                        TipoInstrumentoEnum.valueOf(rs.getString("TIPO_PRD")));

                this.marca = new MarcaProdutoEntity(rs.getString("MARCA_PRD"));

                this.prodDTO = Utils.toProdutoDTO(descricao, marca, produto);
                this.prodsDTO.add(prodDTO);
            }

        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return this.prodsDTO;
    }

    @Override
    public ProdutoDTO getT(Integer id) throws SQLException {
        String sql = "SELECT * FROM  TIPO_PRODUTO AS T, PRODUTO AS D,"
                + " marca_produto AS M"
                + " WHERE D.ID_DESC_PRD=? AND D.ID_MARCA_PRD=M.ID_MARCA_PRD "
                + "AND D.ID_TIPO_PRD=T.ID_TIPO_PRD";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();

            this.descricao = new ProdutoEntity();
            this.descricao.setIdDescricao(rs.getInt("ID_DESC_PRD"));
            this.descricao.setCodBarras(rs.getString("COD_BARRAS"));
            this.descricao.setModelo(rs.getString("MODELO_PRD"));
            this.descricao.setCor(rs.getString("COR_PRD"));
            this.descricao.setEstoque(rs.getInt("QTD_EM_ESTOQUE_PRD"));
            this.descricao.setPreco(rs.getDouble("PRECO_PRD"));
            this.descricao.setEnable(rs.getBoolean("ENABLE"));

            this.produto = new TipoProdutoEntity(rs.getString("NOME_PRD"),
                    TipoInstrumentoEnum.valueOf(rs.getString("TIPO_PRD")));

            this.marca = new MarcaProdutoEntity(rs.getString("MARCA_PRD"));

            this.prodDTO = Utils.toProdutoDTO(descricao, marca, produto);

        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return this.prodDTO;
    }

    @Override
    public void update(ProdutoEntity d, MarcaProdutoEntity m, TipoProdutoEntity p) throws SQLException {
        String sql
                = "BEGIN "
                + "IF NOT EXISTS (SELECT * FROM TIPO_PRODUTO WHERE TIPO_PRD=? AND NOME_PRD=?)"
                + "BEGIN "
                + "INSERT INTO TIPO_PRODUTO (TIPO_PRD, NOME_PRD) VALUES(?,?); "
                + "END;"
                + "IF NOT EXISTS (SELECT * FROM marca_produto WHERE MARCA_PRD=?) "
                + "BEGIN "
                + "INSERT INTO marca_produto (MARCA_PRD) VALUES(?); "
                + "END;"
                + "UPDATE PRODUTO SET "
                + "ID_TIPO_PRD=(SELECT ID_TIPO_PRD FROM TIPO_PRODUTO WHERE TIPO_PRD=? AND NOME_PRD=?), "
                + "ID_MARCA_PRD=(SELECT ID_MARCA_PRD FROM marca_produto WHERE MARCA_PRD=?), "
                + "MODELO_PRD=?, COR_PRD=?, PRECO_PRD=?, "
                + "QTD_EM_ESTOQUE_PRD=?, COD_BARRAS=? WHERE ID_DESC_PRD=? "
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
            pst.setString(11, d.getCor());
            pst.setDouble(12, d.getPreco());
            pst.setInt(13, d.getEstoque());
            pst.setString(14, d.getCodBarras());
            pst.setInt(15, d.getIdDescricao());

            pst.execute();
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "UPDATE PRODUTO SET enable=? WHERE ID_DESC_PRD=?";

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
    public List<ProdutoDTO> search(String modelo) throws SQLException {
        this.prodsDTO = new ArrayList<>();
        String sql = "SELECT * FROM TIPO_PRODUTO AS T, PRODUTO AS D,"
                + " marca_produto AS M WHERE (UPPER(D.MODELO_PRD) LIKE UPPER(?)) "
                + "AND enable=? AND D.ID_MARCA_PRD=M.ID_MARCA_PRD AND D.ID_TIPO_PRD=T.ID_TIPO_PRD";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + modelo + "%");
            pst.setBoolean(2, true);

            rs = pst.executeQuery();

            while (rs.next()) {
                this.descricao = new ProdutoEntity();
                this.descricao.setIdDescricao(rs.getInt("ID_DESC_PRD"));
                this.descricao.setCodBarras(rs.getString("COD_BARRAS"));
                this.descricao.setModelo(rs.getString("MODELO_PRD"));
                this.descricao.setCor(rs.getString("COR_PRD"));
                this.descricao.setEstoque(rs.getInt("QTD_EM_ESTOQUE_PRD"));
                this.descricao.setPreco(rs.getDouble("PRECO_PRD"));
                this.descricao.setEnable(rs.getBoolean("ENABLE"));

                this.produto = new TipoProdutoEntity(rs.getInt("ID_TIPO_PRD"),
                        rs.getString("NOME_PRD"),
                        TipoInstrumentoEnum.valueOf(rs.getString("TIPO_PRD")));

                this.marca = new MarcaProdutoEntity(rs.getInt("ID_MARCA_PRD"),
                        rs.getString("MARCA_PRD"));

                this.prodDTO = Utils.toProdutoDTO(descricao, marca, produto);
                this.prodsDTO.add(prodDTO);
            }
        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }
        return this.prodsDTO;
    }

    @Override
    public ProdutoDTO getT(String codBarras) throws SQLException {
        String sql = "SELECT * FROM  TIPO_PRODUTO AS T, PRODUTO AS D,"
                + " marca_produto AS M"
                + " WHERE D.COD_BARRAS=? AND D.ID_MARCA_PRD=M.ID_MARCA_PRD "
                + "AND D.ID_TIPO_PRD=T.ID_TIPO_PRD";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, codBarras);
            rs = pst.executeQuery();
            rs.next();

            this.descricao = new ProdutoEntity();
            this.descricao.setIdDescricao(rs.getInt("ID_DESC_PRD"));
            this.descricao.setCodBarras(rs.getString("COD_BARRAS"));
            this.descricao.setModelo(rs.getString("MODELO_PRD"));
            this.descricao.setCor(rs.getString("COR_PRD"));
            this.descricao.setEstoque(rs.getInt("QTD_EM_ESTOQUE_PRD"));
            this.descricao.setPreco(rs.getDouble("PRECO_PRD"));
            this.descricao.setEnable(rs.getBoolean("ENABLE"));

            this.produto = new TipoProdutoEntity(rs.getString("NOME_PRD"),
                    TipoInstrumentoEnum.valueOf(rs.getString("TIPO_PRD")));

            this.marca = new MarcaProdutoEntity(rs.getString("MARCA_PRD"));

            this.prodDTO = Utils.toProdutoDTO(descricao, marca, produto);

        } finally {
            ConnectionFactory.closeConnection(conn, pst, rs);
        }

        return this.prodDTO;
    }

    @Override
    public void updateEstoque(Integer qtd, String codBarras) throws SQLException {
        String sql = "UPDATE  produto SET "
                + "QTD_EM_ESTOQUE_PRD=(QTD_EM_ESTOQUE_PRD - ?) WHERE cod_barras=?";

        try {
            this.conn = ConnectionFactory.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, qtd);
            pst.setString(2, codBarras);

            pst.execute();
        } finally {
            ConnectionFactory.closeConnection(conn, pst);
        }

    }
}
