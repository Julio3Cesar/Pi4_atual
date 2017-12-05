package br.com.senac.lojashowmusical.dao;

import br.com.senac.lojashowmusical.entity.ItensVendaEntity;
import java.sql.SQLException;

public interface ItemProdutoDao {

    void insert(ItensVendaEntity item) throws SQLException;

}
