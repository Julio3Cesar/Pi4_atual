package br.com.senac.lojashowmusical.util;

import br.com.senac.lojashowmusical.bean.ProdutoQtd;
import br.com.senac.lojashowmuscial.dto.ContatoDTO;
import br.com.senac.lojashowmuscial.dto.EnderecoDTO;
import br.com.senac.lojashowmuscial.entity.ClienteEntity;
import br.com.senac.lojashowmuscial.entity.ContatoEntity;
import br.com.senac.lojashowmuscial.entity.EnderecoEntity;
import br.com.senac.lojashowmuscial.entity.ProdutoEntity;
import br.com.senac.lojashowmuscial.entity.MarcaProdutoEntity;
import br.com.senac.lojashowmuscial.entity.TipoProdutoEntity;
import br.com.senac.lojashowmusical.dto.ClienteDTO;
import br.com.senac.lojashowmusical.dto.ProdutoDTO;
import br.com.senac.lojashowmusical.dto.VendaDTO;
import br.com.senac.lojashowmusical.entity.ItensVendaEntity;
import br.com.senac.lojashowmusical.entity.VendaEntity;

public class Utils {

    //CLIENTE
    public static ClienteDTO toClienteDTO(ClienteEntity c, EnderecoEntity e,
            ContatoEntity co) {
        EnderecoDTO en = new EnderecoDTO(e.getCep(), e.getLogradouro(),
                e.getNumero(), e.getBairro(), e.getCidade(), e.getUf());

        ContatoDTO con = new ContatoDTO(co.getTelefone(), co.getCelular(),
                co.getEmail());

        return new ClienteDTO(c.getId(), en, con, c.getNome(), c.getCpf(),
                c.getRg(), c.getSexo(), c.getEstadoCivil(), c.getDataDeNascimento());
    }

    public static ClienteEntity toClienteEntity(ClienteDTO c) {
        return new ClienteEntity(c.getId(), c.getNome(), c.getCpf(), c.getRg(), c.getSexo(), c.getEstadoCivil(), c.getDataDeNascimento());
    }

    public static EnderecoEntity toEnderecoEntity(ClienteDTO c) {
        return new EnderecoEntity(c.getEndereco().getCep(), c.getEndereco().getLogradouro(),
                c.getEndereco().getNumero(), c.getEndereco().getBairro(),
                c.getEndereco().getCidade(), c.getEndereco().getUf());
    }

    public static ContatoEntity toContatoEntity(ClienteDTO c) {
        return new ContatoEntity(c.getContato().getTelefone(),
                c.getContato().getCelular(), c.getContato().getEmail());
    }

    //PRODUTO
    public static ProdutoDTO toProdutoDTO(ProdutoEntity descE, MarcaProdutoEntity marcE, TipoProdutoEntity prodE) {
        return new ProdutoDTO(descE.getIdDescricao(), prodE.getNome(), prodE.getTipo(),
                marcE, descE, descE.getCodBarras());
    }

    public static MarcaProdutoEntity toMarcaEntity(ProdutoDTO p) {
        return new MarcaProdutoEntity(p.getMarca().getMarca());
    }

    public static TipoProdutoEntity toTipoProdutoEntity(ProdutoDTO p) {
        return new TipoProdutoEntity(p.getIdProduto(), p.getNome(), p.getTipo());
    }

    public static ProdutoEntity toProdutoEntity(ProdutoDTO p) {
        return new ProdutoEntity(p.getDescricao().getIdDescricao(), p.getIdProduto(),
                p.getMarca().getIdMarca(), p.getDescricao().getCor(),
                p.getDescricao().getModelo(), p.getDescricao().getEstoque(),
                p.getDescricao().getPreco(), p.getCodBarras());

    }

    public static VendaEntity toVendaEntity(VendaDTO venda) {
        return new VendaEntity(venda.getCliente().getId(), venda.getPagamento().getTipoPagamento(),
                venda.getPagamento().getParcelas(),
                venda.getPagamento().getPrecoTotalVenda(), venda.getDataVenda());
    }

    public static ItensVendaEntity toItensVendaEntity(Integer id, ProdutoQtd p) {
        return new ItensVendaEntity(id, p.getProduto().getIdProduto(), p.getQuantidade(),
                p.getProduto().getDescricao().getPreco());
    }

}
