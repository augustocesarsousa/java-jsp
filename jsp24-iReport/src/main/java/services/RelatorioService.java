package services;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class RelatorioService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static final String PASTA_RELATORIOS = "/relatorios";
	private String subPastaRelatorios = null;
	private String caminhoArquivoRelatorio = null;
	private String separator = File.separator;
	private JRExporter exporter = null;
	private File arquivoGerado = null;
	
	public String createRelatorio(List<?> listDataBeanCollection, HashMap parametrosRelatorio,
			String nomeRelatorioJasper, String nomeRelatorioSaida, ServletContext servletContext) throws Exception {
		
		//Cria a lista de BeanCollectionDataSource que carrega os dados para o relatório
		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(listDataBeanCollection);
		
		//Informa o caminho físico até a pasta que contém os relatórios .jasper
		String caminhoRelatorio = servletContext.getRealPath(PASTA_RELATORIOS);
		File file = new File(caminhoRelatorio + separator + nomeRelatorioJasper + ".jasper");		
		if(caminhoRelatorio == null 
				|| (caminhoRelatorio != null && caminhoRelatorio.isEmpty()
				|| !file.exists())) {
			caminhoRelatorio = this.getClass().getResource(PASTA_RELATORIOS).getPath();
			separator = "";
		}
		
		//Caminho para imagens
		parametrosRelatorio.put("REPORT_PARAMETERS_IMG", caminhoRelatorio);
		
		//Caminho completo até o relatório
		String caminhoArquivosJasper = caminhoRelatorio + separator + nomeRelatorioJasper + ".jasper";
		
		//Carrega o relatório
		JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivosJasper);
		
		//Seta parametro SUBREPORT_DIR com o caminho físico para sub relatório
		subPastaRelatorios = caminhoRelatorio + separator;
		parametrosRelatorio.put("SUBREPORT_DIR", subPastaRelatorios);
		
		//Carrega o arquivo
		JasperPrint jasperPrint = JasperFillManager.fillReport(nomeRelatorioJasper, parametrosRelatorio, jrBeanCollectionDataSource);
		
		exporter = new JRPdfExporter();
		
		//Caminho relatório exportado
		caminhoArquivoRelatorio = caminhoRelatorio + separator + nomeRelatorioSaida + ".pdf";
		
		//Cria novo arquivo exportado
		arquivoGerado = new File(caminhoArquivoRelatorio);
		
		//Prepara a impressão
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
		
		//Executa a exportação
		exporter.exportReport();
		
		//Remove arquivo do servidor após o download
		arquivoGerado.deleteOnExit();
		
		return caminhoArquivoRelatorio;
	}
	
}
