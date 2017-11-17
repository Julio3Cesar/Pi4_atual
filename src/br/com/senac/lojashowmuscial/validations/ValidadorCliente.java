package br.com.senac.lojashowmuscial.validations;

import br.com.senac.lojashowmuscial.dto.ClienteDTO;
import br.com.senac.lojashowmuscial.exception.ClienteException;

public class ValidadorCliente {

    public static ClienteDTO validar(ClienteDTO cliente) throws ClienteException {

        //Realização de  validações de negócio
        if (cliente == null) {
            throw new NullPointerException();
        } else {
            if (cliente.getNome() == null || cliente.getNome().equals("")) {
                throw new ClienteException("É necessário informar "
                        + "o nome do cliente válido.");
            }
            if (cliente.getCpf() == null
                    || cliente.getCpf().equals("")) {
                throw new ClienteException("É necessário informar o "
                        + "CPF do cliente.");
            }
            if (cliente.getRg() == null || cliente.getRg().equals("")) {
                throw new ClienteException("É necessário informar o "
                        + "RG do cliente.");
            }
            if ((cliente.getContato().getTelefone() == null && cliente.getContato().getCelular() == null)
                    || (cliente.getContato().getTelefone().equals("")
                    && cliente.getContato().getCelular().equals(""))) {
                throw new ClienteException("É necessário informar ao menos um "
                        + "Telefone do cliente.");
            }
            if (cliente.getEstadoCivil() == null || cliente.getEstadoCivil()
                    .getName().equals("SELECIONE")) {
                throw new ClienteException("É necessário informar o estado"
                        + " civil do cliente."
                );
            }
            if (cliente.getContato().getEmail() == null || cliente.getContato().getEmail().equals("")) {
                throw new ClienteException("É necessário informar o "
                        + "Email do cliente.");
            }
            if (cliente.getSexo() == null || cliente.getSexo()
                    .getName().equals("SELECIONE")) {
                throw new ClienteException("É necessário informar o "
                        + "Sexo do cliente.");
            }
            if (cliente.getEndereco().getBairro() == null || cliente.getEndereco().getBairro().equals("")) {
                throw new ClienteException("É necessário informar o "
                        + "bairro do cliente.");
            }
            if (cliente.getEndereco().getCep() == null
                    || cliente.getEndereco().getCep().equals("")) {
                throw new ClienteException("É necessário informar o "
                        + "CEP do cliente.");
            }
            if (cliente.getEndereco().getCidade() == null || cliente.getEndereco().getCidade().equals("")) {
                throw new ClienteException("É necessário informar o "
                        + "cidade do cliente.");
            }
            if (cliente.getEndereco().getLogradouro() == null || cliente.getEndereco().getLogradouro().equals("")) {
                throw new ClienteException("É necessário informar o "
                        + "logradouro do cliente.");
            }
            if (cliente.getEndereco().getNumero() == null || cliente.getEndereco().getNumero().equals("")) {
                throw new ClienteException("É necessário informar o "
                        + "numero do cliente.");
            }
            if (cliente.getEndereco().getUf() == null || cliente.getEndereco().getUf().equals("")) {
                throw new ClienteException("É necessário informar o "
                        + "UF do cliente.");
            }
            if (cliente.getEndereco().getUf().length() != 2) {
                throw new ClienteException("Digite 2 dígitos para UF.");
            }
            for (int i = 0; i < cliente.getEndereco().getUf().length(); i++) {
                if (Character.isDigit(cliente.getEndereco().getUf().charAt(i))) {
                    throw new ClienteException("Apenas letras são aceitas.");
                }
            }
        }
        return cliente;
    }
}
