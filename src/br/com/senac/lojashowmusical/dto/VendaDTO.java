package br.com.senac.lojashowmusical.dto;

import br.com.senac.lojashowmusical.bean.ProdutoQtd;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendaDTO {

    private Date dataVenda;
    private ClienteDTO cliente;
    private List<ProdutoQtd> produtosQtd;
    private PagamentoDTO pagamento;

    public VendaDTO() {
        this.produtosQtd = new ArrayList<>();
        cliente = new ClienteDTO();
    }

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

    public PagamentoDTO getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoDTO pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "Venda:"
                + "\nData da venda: " + sdf.format(dataVenda)
                + "\nCliente: " + cliente.getNome()
                + "\nProdutos:\n" + produtosQtd
                + "\nValor total da venda: " + pagamento.getPrecoTotalVenda()
                + "\nParcelas: " + pagamento.getParcelas()
                + "\nForma de pagamento: " + pagamento.getTipoPagamento();
    }

}
