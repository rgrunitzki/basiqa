package br.udesc.iqa.controller;

import br.udesc.iqa.model.Classe;
import br.udesc.iqa.model.IQA;

public class ConamaUC {

    private Classe coliformesFecais = Classe.CLASSE_1;
    private Classe ph = Classe.CLASSE_1;
    private Classe demandaBioquimicaOxigenio = Classe.CLASSE_1;
    private Classe nitrogenioTotal = Classe.CLASSE_1;
    private Classe fosforoTotal = Classe.CLASSE_1;
    private Classe temperatura = Classe.CLASSE_1;
    private Classe turbidez = Classe.CLASSE_1;
    private Classe oxigenioDissolvido = Classe.CLASSE_1;
    private Classe residuoTotal = Classe.CLASSE_1;
    private Classe classificacaoGeral = Classe.CLASSE_1;
    private IQA iqa;

    public void classifica_conama() {
        classifica_cf(this.iqa.getColiformes());
//        classifica_ph(this.iqa.getPh()); //pendente: todos são de 6 a 9 de acordo com a resolução
        classifica_dbo(this.iqa.getDbo());
        classifica_nt(this.iqa.getNitrogenioTotal());
        classifica_ft(this.iqa.getFosforoTotal());
//        classifica_t(this.iqa.getVariacaoTemperatura()); //pendente: não existe
        classifica_turbidez(this.iqa.getTurbidez()); //pendente: valores iguais: classe 2 e 3
        classifica_od(this.iqa.getOd()); //verificar
//        classifica_st(this.iqa.getSolidosTotais()); //pendente: não existe
        classificacao_geral();
    }

    public void classificacao_geral() {
        if (coliformesFecais.ordinal() > classificacaoGeral.ordinal()) {
            classificacaoGeral = coliformesFecais;
        }
        if (demandaBioquimicaOxigenio.ordinal() > classificacaoGeral.ordinal()) {
            classificacaoGeral = demandaBioquimicaOxigenio;
        }
        if (nitrogenioTotal.ordinal() > classificacaoGeral.ordinal()) {
            classificacaoGeral = nitrogenioTotal;
        }
        if (fosforoTotal.ordinal() > classificacaoGeral.ordinal()) {
            classificacaoGeral = fosforoTotal;
        }
        if (turbidez.ordinal() > classificacaoGeral.ordinal()) {
            classificacaoGeral = turbidez;
        }
        if (oxigenioDissolvido.ordinal() > classificacaoGeral.ordinal()) {
            classificacaoGeral = oxigenioDissolvido;
        }
            if (residuoTotal.ordinal() > classificacaoGeral.ordinal()) {
                classificacaoGeral = residuoTotal;
            }
    }

    public void classifica_cf(double cf) {
        if (cf <= 200) {
            this.coliformesFecais = Classe.CLASSE_1;
                } else if ((cf > 200) && (cf <= 1000)) {
            this.coliformesFecais = Classe.CLASSE_2;
        } else if ((cf > 1000) && (cf <= 4000)) {
            this.coliformesFecais = Classe.CLASSE_3;
        }
    }

    public void classifica_ph(double ph) {
        //resolver problema dos valores iguais
    }

    public void classifica_dbo(double dbo) {
        if (dbo <= 3) {
            this.demandaBioquimicaOxigenio = Classe.CLASSE_1;
        } else if ((dbo > 3) && (dbo <= 5)) {
            this.demandaBioquimicaOxigenio = Classe.CLASSE_2;
        } else if ((dbo > 5) && (dbo <= 10)) {
            this.demandaBioquimicaOxigenio = Classe.CLASSE_3;
        }
    }

    public void classifica_nt(double nt) {
        //ver com carinho
        if (iqa.getPh() <= 7.5) {
            if (nt <= 3.7) {
                nitrogenioTotal = Classe.CLASSE_1;
            } else if ((nt > 3.7) && (nt <= 13.3)) {
                nitrogenioTotal = Classe.CLASSE_3;
            }
        }else if((iqa.getPh() > 7.5) && (iqa.getPh() <= 8)) {
            if (nt <= 2) {
                nitrogenioTotal = Classe.CLASSE_1;
            } else if ((nt > 2) && (nt <= 5.6)) {
                nitrogenioTotal = Classe.CLASSE_3;
            }
        }else if((iqa.getPh()>8)&&(iqa.getPh()<=8.5)){
            if (nt <= 1) {
                nitrogenioTotal = Classe.CLASSE_1;
            } else if ((nt > 1) && (nt <= 2.2)) {
                nitrogenioTotal = Classe.CLASSE_3;
            }
        }else if((iqa.getPh()>8.5)){
            if (nt <= 0.5) {
                nitrogenioTotal = Classe.CLASSE_1;
            } else if ((nt > 0.5) && (nt <= 1)) {
                nitrogenioTotal = Classe.CLASSE_3;
            }
        }
    }

    public void classifica_ft(double ft) {
        if (ft <= 0.1) {
            this.fosforoTotal = Classe.CLASSE_2;
        } else if ((ft > 0.1) && (ft <= 0.15)) {
            this.fosforoTotal = Classe.CLASSE_3;
        }
    }

    public void classifica_t(double t) {
        // nom existe
    }

    public void classifica_turbidez(double tur) {
        if (tur <= 40) {
            this.turbidez = Classe.CLASSE_1;
        } else if ((tur > 40) && (tur <= 100)) {
            this.turbidez = Classe.CLASSE_2;
        }
        // Quando vai ser classe 3?
    }

    public void classifica_od(double od) {
        if (od >= 6) {
            this.oxigenioDissolvido = Classe.CLASSE_1;
        } else if ((od < 6) && (od >= 4)) {
            this.oxigenioDissolvido = Classe.CLASSE_2;
        } else if (od < 4) {
            this.oxigenioDissolvido = Classe.CLASSE_3;
        }
    }

    public void classifica_st(double st) {
        this.residuoTotal = Classe.CLASSE_1;
    }

    public Classe getColiformesFecais() {
        return coliformesFecais;
    }

    public void setColiformesFecais(Classe coliformesFecais) {
        this.coliformesFecais = coliformesFecais;
    }

    public Classe getPh() {
        return ph;
    }

    public void setPh(Classe ph) {
        this.ph = ph;
    }

    public Classe getDemandaBioquimicaOxigenio() {
        return demandaBioquimicaOxigenio;
    }

    public void setDemandaBioquimicaOxigenio(Classe demandaBioquimicaOxigenio) {
        this.demandaBioquimicaOxigenio = demandaBioquimicaOxigenio;
    }

    public Classe getNitrogenioTotal() {
        return nitrogenioTotal;
    }

    public void setNitrogenioTotal(Classe nitrogenioTotal) {
        this.nitrogenioTotal = nitrogenioTotal;
    }

    public Classe getFosforoTotal() {
        return fosforoTotal;
    }

    public void setFosforoTotal(Classe fosforoTotal) {
        this.fosforoTotal = fosforoTotal;
    }

    public Classe getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Classe temperatura) {
        this.temperatura = temperatura;
    }

    public Classe getTurbidez() {
        return turbidez;
    }

    public void setTurbidez(Classe turbidez) {
        this.turbidez = turbidez;
    }

    public Classe getOxigenioDissolvido() {
        return oxigenioDissolvido;
    }

    public void setOxigenioDissolvido(Classe oxigenioDissolvido) {
        this.oxigenioDissolvido = oxigenioDissolvido;
    }

    public Classe getResiduoTotal() {
        return residuoTotal;
    }

    public void setResiduoTotal(Classe residuoTotal) {
        this.residuoTotal = residuoTotal;
    }

    public Classe getClassificacaoGeral() {
        return classificacaoGeral;
    }

    public void setClassificacaoGeral(Classe classificacaoGeral) {
        this.classificacaoGeral = classificacaoGeral;
    }

    public IQA getIqa() {
        return iqa;
    }

    public void setIqa(IQA iqa) {
        this.iqa = iqa;
    }
}