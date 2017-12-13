package br.com.senac.lojashowmusical.validations;

import br.com.senac.lojashowmusical.exception.DataException;
import java.util.Date;

public class ValidadorData {
    
    public static void validar(String data) throws DataException {
        if (data.replace("/", "").replace(" ", "").equals("")) {
            throw new DataException("Data em branco.");
        }
        String[] dt = data.split("/");
        if (dt == null) {
            throw new DataException("Data inválida");
        } else {
            if (Integer.parseInt(dt[0]) < 1 || Integer.parseInt(dt[0]) > 31) {
                throw new DataException("Data inválida");
            }
            if (Integer.parseInt(dt[1]) < 1 || Integer.parseInt(dt[1]) > 12) {
                throw new DataException("Data inválida");
            }
            Date atual = new Date();
            int a = atual.getYear();
            if (Integer.parseInt(dt[2]) < 1900 || Integer.parseInt(dt[2]) > atual.getYear() + 1900) {
                throw new DataException("Data inválida");
            }
        }
    }
}
