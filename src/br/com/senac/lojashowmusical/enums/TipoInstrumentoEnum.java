package br.com.senac.lojashowmuscial.enums;

public enum TipoInstrumentoEnum {

    SELECIONE("SELECIONE"), CORDA("CORDA"), SOPRO("SOPRO"), PERCUSSÃO("PERCUSSÃO");

    private final String name;

    private TipoInstrumentoEnum(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

}
