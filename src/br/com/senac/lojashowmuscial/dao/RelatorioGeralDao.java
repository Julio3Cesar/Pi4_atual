package br.com.senac.lojashowmuscial.dao;

import br.com.senac.lojashowmuscial.entity.RelatorioGeralEntity;
import java.sql.SQLException;
import java.util.List;

public interface RelatorioGeralDao {

    List<RelatorioGeralEntity> listAll() throws SQLException;

}
