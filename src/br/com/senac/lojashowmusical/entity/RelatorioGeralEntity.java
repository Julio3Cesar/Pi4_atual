package br.com.senac.lojashowmuscial.entity;

import java.util.Date;

public class RelatorioGeralEntity {

    private Date dataVenda;
    private Integer totalVendasRealizadas;
    private Integer parceladas;
    private Integer aVista;

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Integer getTotalVendasRealizadas() {
        return totalVendasRealizadas;
    }

    public void setTotalVendasRealizadas(Integer totalVendasRealizadas) {
        this.totalVendasRealizadas = totalVendasRealizadas;
    }

    public Integer getParceladas() {
        return parceladas;
    }

    public void setParceladas(Integer parceladas) {
        this.parceladas = parceladas;
    }

    public Integer getAVista() {
        return aVista;
    }

    public void setAVista(Integer aVista) {
        this.aVista = aVista;
    }

}
