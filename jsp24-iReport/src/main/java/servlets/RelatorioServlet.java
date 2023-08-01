package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UsuarioDAO;
import entities.Usuario;
import services.RelatorioService;

@WebServlet("/relatorio")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RelatorioService relatorioService = new RelatorioService();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private List<Usuario> usuarios = usuarioDAO.getAll();
       
    public RelatorioServlet() {
    }

	@SuppressWarnings({ "unused", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			String tipoArquivoRelatorio = request.getParameter("tipoArquivoRelatorio");
			ServletContext context = request.getServletContext();
			
			//Cria o arquivo
			String arquivoURL = relatorioService.createRelatorio(usuarios, new HashMap(), "relatorio_usuarios", "relatorio_usuarios", context, tipoArquivoRelatorio);	
			File arquivo = new File(arquivoURL);
			FileInputStream inputStream = new FileInputStream(arquivo);
			
			//Obtem o tipo MIME do arquivo
			String mimeTipe = context.getMimeType(arquivoURL);

			//Define como tipo binário se o mapeamento mime não for encontrado
			if(mimeTipe == null) {
				mimeTipe = "application/octet-stream";
			}
			
			//Define atributos da resposta
			response.setContentType(mimeTipe);
			response.setContentLength((int) arquivo.length());
			
			//Define cabeçalho da resposta
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", arquivo.getName());
			response.setHeader(headerKey, headerValue);
			
			//Obtem fluxo de saída da resposta
			OutputStream outputStream = response.getOutputStream();			
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			
			//Escreve os bytes lidos a partir do fluxo de entrada para o fluxo de saida
			while((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			
			inputStream.close();
			outputStream.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
