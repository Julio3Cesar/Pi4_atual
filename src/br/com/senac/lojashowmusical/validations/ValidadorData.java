package br.com.senac.lojashowmusical.validations;

import br.com.senac.lojashowmusical.exception.DataException;
import java.util.Date;

public class ValidadorData {

    public static void validar(Date data) throws DataException {
        if (data == null) {
            throw new DataException("Data inválida");
        } else {
            Integer dia = data.getDay();
            Integer mes = data.getMonth();
            Integer ano = data.getYear();
            Date atual = new Date();
            
            System.out.println(atual);
            
            if (dia < 1 || dia > 31) {
                throw new DataException("Data inválida");
            }
            if (mes < 1 || mes > 12) {
                throw new DataException("Data inválida");
            }
            if (ano < 1900 || ano > atual.getYear()) {
                throw new DataException("Data inválida");
            }
        }
    }
}
