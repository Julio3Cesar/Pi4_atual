package br.com.senac.lojashowmusical.validations;

import br.com.senac.lojashowmusical.exception.RelatorioDataException;
import java.util.Date;

public class ValidadorRelatorio {

    public static void validar(Date dtInicial, Date dtFinal) throws RelatorioDataException {
        if (dtFinal.before(dtInicial)) {
            throw new RelatorioDataException("A data final deve ser maior que a inicial.");
        } else {
            int dias;
            for (dias = 0; dtFinal.after(dtInicial); dias++) {
                dtFinal.setDate(dtFinal.getDate() - 1);
            }

            if (dias > 31) {
                throw new RelatorioDataException("Relatórios de no máximo 31 dias são gerados.");
            }

        }
    }
}
