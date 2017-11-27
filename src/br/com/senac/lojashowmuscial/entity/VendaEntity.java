package br.com.senac.lojashowmuscial.entity;

import br.com.senac.lojashowmuscial.enums.TipoPagamentoEnum;
import java.util.Date;

public class VendaEntity {

    private Integer idVenda;
    private Integer idCliente;
    private TipoPagamentoEnum tipoPagamento;
    private Integer parcelas;
    private Double precoTotalVenda;
    private Date dataVenda;

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Double getPrecoTotalVenda() {
        return precoTotalVenda;
    }

    public void setPrecoTotalVenda(Double precoTotalVenda) {
        this.precoTotalVenda = precoTotalVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

}
