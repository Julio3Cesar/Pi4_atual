package br.com.senac.lojashowmuscial.enums;

public enum SexoEnum {
    SELECIONE("Selecione"), M("M"), F("F");
    
    private final String name;
    
    SexoEnum(String s){
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
