package br.udesc.iqa.controller;

import br.udesc.iqa.model.IQA;
import br.udesc.iqa.model.Nivel;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Ricardo Grunitzki
 */
public class IQAUC {

    private IQA iqa;

    private String instituicao;
    private String numero_amostra;
    private String tipo_amostra = "Simples";
    private String natureza_amostra;
    private String ponto_amostragem;
    private String responsavel;
    private Date data;
    private String localizacao;
    private String observacoes;

    public IQA getIqa() {
        return iqa;
    }

    public void setIqa(IQA iqa) {
        this.iqa = iqa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getNumero_amostra() {
        return numero_amostra;
    }

    public void setNumero_amostra(String numero_amostra) {
        this.numero_amostra = numero_amostra;
    }

    public String getTipo_amostra() {
        return tipo_amostra;
    }

    public void setTipo_amostra(String tipo_amostra) {
        this.tipo_amostra = tipo_amostra;
    }

    public String getNatureza_amostra() {
        return natureza_amostra;
    }

    public void setNatureza_amostra(String natureza_amostra) {
        this.natureza_amostra = natureza_amostra;
    }

    public String getPonto_amostragem() {
        return ponto_amostragem;
    }

    public void setPonto_amostragem(String ponto_amostragem) {
        this.ponto_amostragem = ponto_amostragem;
    }

//    Calculo do IQA
    public void calcularIQA() {
        double valor;
        valor = Math.pow(coliformesFecais(iqa.getColiformes()), iqa.getPeso_coliformes());
        System.out.println("Coliformes: " + Math.pow(coliformesFecais(iqa.getColiformes()), iqa.getPeso_coliformes()));

        valor *= Math.pow(ph(iqa.getPh()), iqa.getPeso_ph());
        System.out.println("pH: " + Math.pow(ph(iqa.getPh()), iqa.getPeso_ph()));

        valor *= Math.pow(demandaBioquimicaOxigenio(iqa.getDbo()), iqa.getPeso_dbo());
        System.out.println("dbo: " + Math.pow(demandaBioquimicaOxigenio(iqa.getDbo()), iqa.getPeso_dbo()));

        valor *= Math.pow(nitrogenioTotal(iqa.getNitrogenioTotal()), iqa.getPeso_nitrogenioTotal());
        System.out.println("nt: " + Math.pow(nitrogenioTotal(iqa.getNitrogenioTotal()), iqa.getPeso_nitrogenioTotal()));

        valor *= Math.pow(fosforoTotal(iqa.getFosforoTotal()), iqa.getPeso_fosforoTotal());
        System.out.println("ft: " + Math.pow(fosforoTotal(iqa.getFosforoTotal()), iqa.getPeso_fosforoTotal()));

        valor *= Math.pow(temperatura(iqa.getVariacaoTemperatura()), iqa.getPeso_variacaoTemperatura());
        System.out.println("temp: " + Math.pow(temperatura(iqa.getVariacaoTemperatura()), iqa.getPeso_variacaoTemperatura()));

        valor *= Math.pow(turbidez(iqa.getTurbidez()), iqa.getPeso_turbidez());
        System.out.println("tur: " + Math.pow(turbidez(iqa.getTurbidez()), iqa.getPeso_turbidez()));

        valor *= Math.pow(oxigenioDissolvido(iqa.getOd()), iqa.getPeso_od());
        System.out.println("od: " + Math.pow(oxigenioDissolvido(iqa.getOd()), iqa.getPeso_od()));

        valor *= Math.pow(residuoTotal(iqa.getSolidosTotais()), iqa.getPeso_solidosTotais());
        System.out.println("rt: " + Math.pow(residuoTotal(iqa.getSolidosTotais()), iqa.getPeso_solidosTotais()));

//        BigDecimal valorExatao = new BigDecimal(valor).setScale(2, RoundingMode.HALF_DOWN);
//        valor = valorExatao.doubleValue();
        iqa.setResultado(valor);
        this.calculaNivelDeQualidade();
    }

//    Classifica de acordo com o CONAMA
    private void calculaNivelDeQualidade() {
        if (iqa.getResultado() >= 0 && iqa.getResultado() <= 25) {
            iqa.setNivel(Nivel.MUITO_RUIM);
        } else if (iqa.getResultado() > 25 && iqa.getResultado() <= 50) {
            iqa.setNivel(Nivel.RUIM);
        } else if (iqa.getResultado() > 50 && iqa.getResultado() <= 70) {
            iqa.setNivel(Nivel.MEDIO);
        } else if (iqa.getResultado() > 70 && iqa.getResultado() <= 90) {
            iqa.setNivel(Nivel.BOM);
        } else if (iqa.getResultado() > 90 && iqa.getResultado() <= 100) {
            iqa.setNivel(Nivel.EXCELENTE);
        }
    }

    public String corNivelQualidade() {
        switch (iqa.getNivel()) {
            case EXCELENTE:
                return "inputBlue";
            case BOM:
                return "inputBlue";
            case MEDIO:
                return "inputBlue";
            case RUIM:
                return "inputBlue";
            case MUITO_RUIM:
                return "inputBlue";
            default:
                return "inputBlue";
        }
    }

//    Calculo dos Qis
    private double coliformesFecais(double cf) {
        if (cf > 100000) {
            return 3.0;
        } else {
            return (98.03 - 36.45 * Math.log10(cf) + 3.14 * Math.pow(Math.log10(cf), 2) + 0.067 * Math.pow(Math.log10(cf), 3));
        }
    }

    private double ph(double ph) {
        if (ph <= 2) {
            return 2.0;
        } else if (ph >= 12) {
            return 3.0;
        } else {
            return (0.05421 * (Math.pow(ph, 1.23 * ph - 0.09873 * (Math.pow(ph, 2)))) + 5.213);
        }
    }

    private double demandaBioquimicaOxigenio(double dbo) {
        if (dbo > 30) {
            return 2.0;
        } else {
            return (102.6 * Math.exp(-0.1101 * dbo));
        }
    }

    private double nitrogenioTotal(double nt) {
        if (nt > 90) {
            return 1.0;
        } else {
            return (98.96 * (Math.pow(nt, -0.2232 + (-0.006457 * nt))));
        }
    }

    private double fosforoTotal(double ft) {
        if (ft > 10) {
            return 5.0;
        } else {
            return (213.7 * Math.exp(-1.68 * (Math.pow(ft, 0.3325))));
        }
    }

    private double temperatura(double t) {
        if (t > 15) {
            return 9.0;
        } else {
            return (1 / (0.0003869 * Math.pow((t + 0.1815), 2) + 0.01081));
        }
    }

    private double turbidez(double tur) {
        if (tur > 100) {
            return 5.0;
        } else {
            return (97.34 * Math.exp(-0.01139 * tur - 0.04917 * Math.pow(tur, 0.5)));
        }
    }

    private double oxigenioDissolvido(double od) {
        if (od > 140) {
            return 47.0;
        } else {
            return (100.8 * Math.exp((Math.pow(od - 106, 2) / -3745)));
        }
    }

    private double residuoTotal(double rt) {
        if (rt > 500) {
            return 30.0;
        } else {
            return (80.26 * Math.exp(-0.00107 * rt + 0.03009 * Math.pow(rt, 0.5)) - 0.1185 * rt);
        }
    }

//    Monta Relatório
    public JasperPrint montaRelatorio(String local, String figura1, String figura2, Map param) throws JRException {

        InputStream stream = getClass().getResourceAsStream(local);
        if (!observacoes.equals("")) {
            param.put("observacoes", observacoes);
        }

        param.put("instituicao", instituicao);
        param.put("numero_amostra", numero_amostra);
        param.put("natureza", natureza_amostra);
        param.put("tipo", tipo_amostra);
        param.put("ponto", ponto_amostragem);
        param.put("responsavel", responsavel);
        param.put("data", data);
        param.put("localizacao", localizacao);
        param.put("cf", iqa.getColiformes());
        param.put("ph", iqa.getPh());
        param.put("dbo", iqa.getDbo());
        param.put("nt", iqa.getNitrogenioTotal());
        param.put("ft", iqa.getFosforoTotal());
        param.put("vt", iqa.getVariacaoTemperatura());
        param.put("tur", iqa.getTurbidez());
        param.put("od", iqa.getOd());
        param.put("st", iqa.getSolidosTotais());
        param.put("resultado", iqa.getResultado());
        param.put("nivel", iqa.getNivel().toString());
        param.put("figura1", figura1);
        param.put("figura2", figura2);

        JasperReport report = (JasperReport) JRLoader.loadObject(stream);
        JasperPrint print = JasperFillManager.fillReport(report, param, new JREmptyDataSource());
        return print;
    }
}
