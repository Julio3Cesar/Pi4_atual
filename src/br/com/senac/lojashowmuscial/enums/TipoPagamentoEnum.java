package br.com.senac.lojashowmuscial.enums;

public enum TipoPagamentoEnum {

    SELECIONE("SELECIONE"), CRÉDITO("CRÉDITO"), DINHEIRO("DINHEIRO"),
    BOLETO("BOLETO"), CHEQUE("CHEQUE"), DÉBITO("DÉBITO");

    private final String name;

    private TipoPagamentoEnum(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
