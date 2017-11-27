package br.com.senac.lojashowmuscial.enums;

public enum TipoPagamentoEnum {

    SELECIONE("SELECIONE"), CARTÃO("CARTÃO"), DINHEIRO("DINHEIRO"),
    BOLETO("BOLETO"), CHEQUE("CHEQUE");

    private final String name;

    private TipoPagamentoEnum(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
