package br.com.senac.lojashowmuscial.validations;

import br.com.senac.lojashowmuscial.dto.ProdutoDTO;
import br.com.senac.lojashowmuscial.exception.ProdutoException;

public class ValidadorProduto {

    public static ProdutoDTO validar(ProdutoDTO produto) throws ProdutoException {

        //Realização de validações de negócio
        if (produto == null) {
            throw new NullPointerException();
        } else {
            if (produto.getNome() == null || produto.getDescricao().equals("")) {
                throw new ProdutoException("É necessário informar "
                        + "o nome do Produto.");
            }
            if (produto.getMarca() == null || produto.getMarca().equals("")) {
                throw new ProdutoException("É necessário informar "
                        + "a marca do produto.");
            }
            if (produto.getTipo() == null || produto.getTipo().getName().equals("SELECIONE")) {
                throw new ProdutoException("É necessário informar "
                        + "o tipo do produto.");
            }
            if (produto.getDescricao().getCor() == null || produto.getDescricao().getCor().equals("")) {
                throw new ProdutoException("É necessário informar "
                        + "a cor do produto.");
            }
            if (produto.getDescricao().getModelo() == null || produto.getDescricao().getModelo().equals("")) {
                throw new ProdutoException("É necessário informar "
                        + "o modelo do produto.");

            }
            if (produto.getDescricao().getPreco() == null || produto.getDescricao().getPreco() == 0.0) {
                throw new ProdutoException("É necessário informar "
                        + "o valor do produto.");
            }
        }
        return produto;
    }
}
