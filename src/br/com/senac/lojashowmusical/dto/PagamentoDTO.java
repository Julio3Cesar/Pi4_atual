package br.com.senac.lojashowmusical.dto;

import br.com.senac.lojashowmusical.enums.TipoPagamentoEnum;


public class PagamentoDTO {

    private Double precoTotalVenda;
    private Integer parcelas;
    private TipoPagamentoEnum tipoPagamento;

    public PagamentoDTO() {
        this.precoTotalVenda = 0.0;
    }

    public Double getPrecoTotalVenda() {
        return precoTotalVenda;
    }

    public void setPrecoTotalVenda(Double precoTotalVenda) {
        this.precoTotalVenda = precoTotalVenda;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

}
