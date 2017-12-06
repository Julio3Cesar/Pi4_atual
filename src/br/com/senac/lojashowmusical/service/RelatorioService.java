package br.com.senac.lojashowmuscial.service;

import br.com.senac.lojashowmuscial.entity.RelatorioDetalhadoEntity;
import br.com.senac.lojashowmuscial.entity.RelatorioGeralEntity;
import br.com.senac.lojashowmuscial.exception.RelatorioException;
import java.util.Date;
import java.util.List;

public interface RelatorioService {

    List<RelatorioDetalhadoEntity> getRelatorioDetalhado(Date dtInicial, Date dtFinal) throws RelatorioException;

    List<RelatorioGeralEntity> getRelatorioGeral(Date dtInicial, Date dtFinal) throws RelatorioException;

}
