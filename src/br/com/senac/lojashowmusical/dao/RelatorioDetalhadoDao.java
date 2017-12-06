package br.com.senac.lojashowmuscial.dao;

import br.com.senac.lojashowmuscial.entity.RelatorioDetalhadoEntity;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface RelatorioDetalhadoDao {

    List<RelatorioDetalhadoEntity> listBetweenDates(Date dtInicial,Date dtFinal) throws SQLException;
    
}
