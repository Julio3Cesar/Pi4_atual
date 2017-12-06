package br.com.senac.lojashowmuscial.dao;

import br.com.senac.lojashowmuscial.entity.RelatorioGeralEntity;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface RelatorioGeralDao {

    List<RelatorioGeralEntity> listBetweenDates(Date dtInicial,Date dtFinal) throws SQLException;

}
