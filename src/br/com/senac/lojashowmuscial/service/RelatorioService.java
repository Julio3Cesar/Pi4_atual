package br.com.senac.lojashowmuscial.service;

import br.com.senac.lojashowmuscial.entity.RelatorioDetalhadoEntity;
import br.com.senac.lojashowmuscial.entity.RelatorioGeralEntity;
import br.com.senac.lojashowmuscial.exception.RelatorioException;
import java.util.List;

public interface RelatorioService {

    List<RelatorioDetalhadoEntity> getAllRelatorioDetalhado() throws RelatorioException;

    List<RelatorioGeralEntity> getAllRelatorioGeral() throws RelatorioException;

}
