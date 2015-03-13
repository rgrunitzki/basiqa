package br.udesc.iqa.bean;

import br.udesc.iqa.controller.ConamaUC;
import br.udesc.iqa.controller.IQAUC;
import br.udesc.iqa.model.IQA;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class BasIQABean implements Serializable{

    private IQA iqa;
    private IQAUC iqauc;
    private ConamaUC conamaUC;
    private StreamedContent file;

    public BasIQABean() {
        this.iqa = new IQA();
        this.iqauc = new IQAUC();
        this.conamaUC = new ConamaUC();
    }

    public void novo() {
        this.iqa = new IQA();
    }

    public void calcular() {
        //Classificação de acordo com a resolução 315/2005 do CONAMA
        this.conamaUC.setIqa(iqa);
        this.conamaUC.classifica_conama();
        //Calculo do IQA
        this.iqauc.setIqa(iqa);
        this.iqauc.calcularIQA();
    }

    public void gerarRelatorio() throws JRException, IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ext = context.getExternalContext();
        String figura1 = context.getExternalContext().getRealPath("/resources/img/sanit.png");
        String figura2 = context.getExternalContext().getRealPath("/resources/img/udesc.png");
        Map param = new HashMap();

        param.put("CLASSE_CF", conamaUC.getColiformesFecais().getNome());
//        param.put("CLASSE_PH", conamaUC.getPh().getNome());
        param.put("CLASSE_PH", "-");
        param.put("CLASSE_DBO", conamaUC.getDemandaBioquimicaOxigenio().getNome());
        param.put("CLASSE_NT", conamaUC.getNitrogenioTotal().getNome());
        param.put("CLASSE_FT", conamaUC.getFosforoTotal().getNome());
//        param.put("CLASSE_VT", conamaUC.getTemperatura().getNome());
        param.put("CLASSE_VT", "-");
        param.put("CLASSE_TUR", conamaUC.getTurbidez().getNome());
        param.put("CLASSE_OD", conamaUC.getOxigenioDissolvido().getNome());
//        param.put("CLASSE_ST", conamaUC.getResiduoTotal().getNome());
        param.put("CLASSE_ST", conamaUC.getResiduoTotal().getNome());
        param.put("CLASSE_CONAMA", conamaUC.getClassificacaoGeral().getNome());

        JasperPrint print = iqauc.montaRelatorio("/RelatorioIQA.jasper", figura1, figura2, param);

        HttpServletResponse resp = (HttpServletResponse) ext.getResponse();
        resp.setContentType("application/pdf");
        resp.addHeader("Content-Disposition", "inline; filename=Relatório de Análise de Água IQA-BasIQA.pdf");

        JasperExportManager.exportReportToPdfStream(print, resp.getOutputStream());
        context.responseComplete();
    }

    public IQA getIqa() {
        return iqa;
    }

    public void setIqa(IQA iqa) {
        this.iqa = iqa;
    }

    public IQAUC getIqauc() {
        return iqauc;
    }

    public void setIqauc(IQAUC iqauc) {
        this.iqauc = iqauc;
    }

    public ConamaUC getConamaUC() {
        return conamaUC;
    }

    public void setConamaUC(ConamaUC conamaUC) {
        this.conamaUC = conamaUC;
    }

    public StreamedContent getFile() {
        InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/img/fundo.jpg");
        file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
}
