package br.com.senac.lojashowmusical.validations;

import br.com.senac.lojashowmuscial.exception.VendaException;
import br.com.senac.lojashowmusical.bean.ProdutoQtd;
import br.com.senac.lojashowmusical.dto.VendaDTO;
import java.util.List;

public class ValidadorVenda {

    public static void validarCpf(String cpf) throws VendaException {
        if (cpf == null) {
            throw new VendaException("É necessário informar "
                    + "o cpf do cliente.");
        }
        cpf = cpf.replace(".", "").replace("-", "");

        if (cpf.replace("           ", "").equals("")) {
            throw new VendaException("É necessário informar "
                    + "o cpf do cliente.");
        }
    }

    public static void validarCodBarras(String codBarras) throws VendaException {
        if (codBarras == null || codBarras.equals("")) {
            throw new VendaException("É necessário informar "
                    + "o código de barras");
        }

        if (codBarras.length() > 40) {
            throw new VendaException("O código de barras tem no máximo 40 caracteres.");
        }
    }

    public static void validarQtd(String qtd, Integer estoque) throws VendaException {
        if (qtd == null || qtd.equals("")) {
            throw new VendaException("É necessário informar "
                    + "uma quantidade.");
        }

        if (Integer.parseInt(qtd) < 1) {
            throw new VendaException("Quantidade inválida.");
        }

        if (Integer.parseInt(qtd) > estoque) {
            throw new VendaException("Quantidade indisponivel no estoque, temos apenas " + estoque + " peças.");
        }
    }

    public static void validarQtd(String qtd, Integer estoque, String nomeProduto) throws VendaException {
        if (qtd == null || qtd.equals("")) {
            throw new VendaException("É necessário informar "
                    + "uma quantidade para o produto " + nomeProduto);
        }

        if (Integer.parseInt(qtd) < 1) {
            throw new VendaException("Quantidade inválida para o produto " + nomeProduto);
        }

        if (Integer.parseInt(qtd) > estoque) {
            throw new VendaException("Quantidade indisponivel no estoque, "
                    + "temos apenas " + estoque + " peças para o produto " + nomeProduto);
        }

    }

    public static void validarListaProd(List<ProdutoQtd> carrinho) throws VendaException {
        if (carrinho.isEmpty()) {
            throw new VendaException("Carrinho está vazio!");
        }
    }

    public static void validar(VendaDTO venda) throws VendaException {
        validarListaProd(venda.getProdutosQtd());
        for (ProdutoQtd p : venda.getProdutosQtd()) {
            validarCodBarras(p.getProduto().getCodBarras());
            validarQtd(p.getQuantidade().toString(),
                    p.getProduto().getDescricao().getEstoque(),
                    p.getProduto().getCodBarras());
        }
        validarCpf(venda.getCliente().getCpf());
    }
}
