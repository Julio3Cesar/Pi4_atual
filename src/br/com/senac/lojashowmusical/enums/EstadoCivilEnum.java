package br.com.senac.lojashowmuscial.enums;

public enum EstadoCivilEnum {
    SELECIONE("SELECIONE"), SOLTEIRO("SOLTEIRO"), CASADO("CASADO"),
    DIVORCIADO("DIVORCIADO"), VIÚVO("VIÚVO"), SEPARADO("SEPARADO");

    private final String name;

    private EstadoCivilEnum(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
