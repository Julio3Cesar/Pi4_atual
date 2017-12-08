package br.com.senac.lojashowmusical.validations;

import br.com.senac.lojashowmusical.exception.DataException;
import br.com.senac.lojashowmusical.exception.RelatorioDataException;
import java.util.Date;

public class ValidadorRelatorio {

    public static void validar(Date dtInicial, Date dtFinal) throws RelatorioDataException, DataException {
        ValidadorData.validar(dtInicial);
        ValidadorData.validar(dtFinal);
        Date auxFinal = new Date(dtFinal.getTime());
        if (dtFinal.before(dtInicial)) {
            throw new RelatorioDataException("A data final deve ser maior que a inicial.");
        } else {
            int dias;
            for (dias = 0; auxFinal.after(dtInicial); dias++) {
                auxFinal.setDate(auxFinal.getDate() - 1);
            }

            if (dias > 31) {
                throw new RelatorioDataException("São gerados relatórios de no máximo 31 dias.");
            }
        }
    }
}
