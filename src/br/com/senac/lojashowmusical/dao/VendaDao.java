package br.com.senac.lojashowmusical.dao;

import br.com.senac.lojashowmusical.entity.VendaEntity;
import java.sql.SQLException;

public interface VendaDao {

    void insert(VendaEntity v) throws SQLException;

    Integer getLastId() throws SQLException;
}
