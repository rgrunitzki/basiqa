package br.udesc.iqa.model;

public class IQA {

    private Double coliformes;

    private Double ph = null;

    private Double dbo;

    private Double nitrogenioTotal;

    private Double fosforoTotal;

    private Double variacaoTemperatura;

    private Double turbidez;

    private Double od;

    private Double solidosTotais;

    private Double peso_coliformes = 0.15;

    private Double peso_ph = 0.12;

    private Double peso_dbo = 0.10;

    private Double peso_nitrogenioTotal = 0.10;

    private Double peso_fosforoTotal = 0.10;

    private Double peso_variacaoTemperatura = 0.10;

    private Double peso_turbidez = 0.08;

    private Double peso_od = 0.17;

    private Double peso_solidosTotais = 0.08;

    private Double resultado;

    private Nivel nivel;

    public Double getColiformes() {
        return coliformes;
    }

    public void setColiformes(Double coliformes) {
        this.coliformes = coliformes;
    }

    public Double getDbo() {
        return dbo;
    }

    public void setDbo(Double dbo) {
        this.dbo = dbo;
    }

    public Double getFosforoTotal() {
        return fosforoTotal;
    }

    public void setFosforoTotal(Double fosforoTotal) {
        this.fosforoTotal = fosforoTotal;
    }

    public Double getNitrogenioTotal() {
        return nitrogenioTotal;
    }

    public void setNitrogenioTotal(Double nitrogenioTotal) {
        this.nitrogenioTotal = nitrogenioTotal;
    }

    public Double getOd() {
        return od;
    }

    public void setOd(Double od) {
        this.od = od;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public Double getSolidosTotais() {
        return solidosTotais;
    }

    public void setSolidosTotais(Double solidosTotais) {
        this.solidosTotais = solidosTotais;
    }

    public Double getTurbidez() {
        return turbidez;
    }

    public void setTurbidez(Double turbidez) {
        this.turbidez = turbidez;
    }

    public Double getVariacaoTemperatura() {
        return variacaoTemperatura;
    }

    public void setVariacaoTemperatura(Double variacaoTemperatura) {
        this.variacaoTemperatura = variacaoTemperatura;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Double getPeso_coliformes() {
        return peso_coliformes;
    }

    public void setPeso_coliformes(Double peso_coliformes) {
        this.peso_coliformes = peso_coliformes;
    }

    public Double getPeso_ph() {
        return peso_ph;
    }

    public void setPeso_ph(Double peso_ph) {
        this.peso_ph = peso_ph;
    }

    public Double getPeso_dbo() {
        return peso_dbo;
    }

    public void setPeso_dbo(Double peso_dbo) {
        this.peso_dbo = peso_dbo;
    }

    public Double getPeso_nitrogenioTotal() {
        return peso_nitrogenioTotal;
    }

    public void setPeso_nitrogenioTotal(Double peso_nitrogenioTotal) {
        this.peso_nitrogenioTotal = peso_nitrogenioTotal;
    }

    public Double getPeso_fosforoTotal() {
        return peso_fosforoTotal;
    }

    public void setPeso_fosforoTotal(Double peso_fosforoTotal) {
        this.peso_fosforoTotal = peso_fosforoTotal;
    }

    public Double getPeso_variacaoTemperatura() {
        return peso_variacaoTemperatura;
    }

    public void setPeso_variacaoTemperatura(Double peso_variacaoTemperatura) {
        this.peso_variacaoTemperatura = peso_variacaoTemperatura;
    }

    public Double getPeso_turbidez() {
        return peso_turbidez;
    }

    public void setPeso_turbidez(Double peso_turbidez) {
        this.peso_turbidez = peso_turbidez;
    }

    public Double getPeso_od() {
        return peso_od;
    }

    public void setPeso_od(Double peso_od) {
        this.peso_od = peso_od;
    }

    public Double getPeso_solidosTotais() {
        return peso_solidosTotais;
    }

    public void setPeso_solidosTotais(Double peso_solidosTotais) {
        this.peso_solidosTotais = peso_solidosTotais;
    }
    
    
}
