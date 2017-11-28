package br.com.senac.lojashowmuscial.dao;

import br.com.senac.lojashowmuscial.entity.VendaEntity;
import java.sql.SQLException;

public interface VendaDao {

    void insert(VendaEntity v) throws SQLException;

    Integer getLastId() throws SQLException;
}
