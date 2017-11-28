package br.com.senac.lojashowmuscial.dto;

import br.com.senac.lojashowmusical.bean.ProdutoQtd;
import br.com.senac.lojashowmuscial.enums.TipoPagamentoEnum;
import java.util.Date;
import java.util.List;

public class VendaDTO {
    
    
    private Date dataVenda;
    private ClienteDTO cliente;
    private List<ProdutoQtd> produtosQtd;
    private Double precoTotalVenda;
    private Integer parcelas;
    private TipoPagamentoEnum tipoPagamento;

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<ProdutoQtd> getProdutosQtd() {
        return produtosQtd;
    }

    public void setProdutosQtd(List<ProdutoQtd> produtosQtd) {
        this.produtosQtd = produtosQtd;
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
