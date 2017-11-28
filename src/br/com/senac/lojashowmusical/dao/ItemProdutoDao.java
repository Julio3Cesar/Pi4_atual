package br.com.senac.lojashowmuscial.dao;

import br.com.senac.lojashowmuscial.entity.ItensVendaEntity;
import java.sql.SQLException;

public interface ItemProdutoDao {

    void insert(ItensVendaEntity item) throws SQLException;

}
