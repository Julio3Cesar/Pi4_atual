package br.com.senac.lojashowmuscial.dao;

import br.com.senac.lojashowmuscial.entity.RelatorioDetalhadoEntity;
import java.sql.SQLException;
import java.util.List;

public interface RelatorioDetalhadoDao {

    List<RelatorioDetalhadoEntity> listAll() throws SQLException;
    
}
