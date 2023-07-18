package servlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.codec.binary.Base64;

import beans.Usuario;
import dao.UsuarioDAO;

@WebServlet("/UsuarioServlet")
@MultipartConfig
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public UsuarioServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String tipoArquivoDownload = request.getParameter("tipo");
		String usuarioId = request.getParameter("id");
		
		switch (acao) {
			case "listar": {
				redirecionar(request, response, "listar", null, false, null);
				break;
			}
			case "delete": {
				usuarioDAO.deletar(usuarioId);
				redirecionar(request, response, "listar", null, false, null);
				break;
			}
			case "editar": {
				Usuario usuario = usuarioDAO.consultaUsuarioPorId(usuarioId);
				redirecionar(request, response, "editar", usuario, false, null);
				break;
			}
			case "download": {
				String arquivoBase64Download = null;
				
				if(tipoArquivoDownload.equalsIgnoreCase("foto")) {
					arquivoBase64Download = usuarioDAO.consultaFoto(Long.parseLong(usuarioId));
				} else if(tipoArquivoDownload.equalsIgnoreCase("curriculo")) {
					arquivoBase64Download = usuarioDAO.consultaCurriculo(Long.parseLong(usuarioId));
				}
				
				if(arquivoBase64Download != null) {
					gerarArquivoParaDownload(arquivoBase64Download, response);						
				} else {
					redirecionar(request, response, "listar", null, false, null);
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + acao);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = request.getParameter("id") != null ? Long.parseLong(request.getParameter("id")) : null;
		String login = request.getParameter("login").replace(" ", "");
		String senha = request.getParameter("senha").replace(" ", "");
		String nome = request.getParameter("nome").replace(" ", "");
		String sobrenome = request.getParameter("sobrenome").replace(" ", "");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String logradouro = request.getParameter("logradouro");
		Integer numero = Integer.parseInt(request.getParameter("numero").equals("") ? "-1" : request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String cep = request.getParameter("cep");
		String fotoBase64 = null;
		String curriculoBase64 = null;
		Usuario usuario = null;
		String acao = null;
		String dadosValidados = null;
		
		try {
			if(ServletFileUpload.isMultipartContent(request)) {
				Part arquivo = request.getPart("foto");
				new Base64();
				
				if (arquivo.getSize() > 0) {
					fotoBase64 = "data:" + arquivo.getContentType() + ";base64," + Base64.encodeBase64String(converterStreamParaByte(arquivo.getInputStream()));					
				} else if (id != null){
					fotoBase64 = usuarioDAO.consultaFoto(id);						
				}
				
				arquivo = request.getPart("curriculo");
				
				if (arquivo.getSize() > 0) {
					curriculoBase64 = "data:" + arquivo.getContentType() + ";base64," + Base64.encodeBase64String(converterStreamParaByte(arquivo.getInputStream()));					
				} else if (id != null){
					curriculoBase64 = usuarioDAO.consultaCurriculo(id);						
				}				
			}			

			usuario = new Usuario(id, login, senha, nome, sobrenome, email, telefone, logradouro, numero, bairro, cidade, estado, cep, fotoBase64, curriculoBase64);
			acao = usuario.getId() == null ? "cadastrar" : "editar";
			dadosValidados = validarDados(usuario);
			
			if (dadosValidados != null) {
				redirecionar(request, response, acao, usuario, true, dadosValidados);
			} else {
				if (acao.equals("cadastrar")) {
					usuarioDAO.cadastrar(usuario);
				} else {
					usuarioDAO.update(usuario);
				}
				redirecionar(request, response, "listar", null, false, null);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void redirecionar(HttpServletRequest request, HttpServletResponse response, String acao, Usuario usuario, boolean erro, String mensagem) {
		try {
			RequestDispatcher dispacher;
			
			switch (acao) {
				case "listar": {
					dispacher = request.getRequestDispatcher("acesso-liberado.jsp");
					request.setAttribute("usuarios", usuarioDAO.listar());
					break;
				}
				case "editar": {
					dispacher = request.getRequestDispatcher("editar-usuario.jsp");
					request.setAttribute("usuario", usuario);
					break;
				}
				case "cadastrar": {
					dispacher = request.getRequestDispatcher("cadastro-usuario.jsp");
					request.setAttribute("usuario", usuario);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + acao);
			}
			
			if(erro) {
				request.setAttribute("erro", true);
				request.setAttribute("mensagem", mensagem);
			}		
		
			dispacher.forward(request, response);
		} catch (ServletException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String validarDados(Usuario usuario) {				
		if(usuario.getLogin() == null || usuario.getLogin().length() < 4) {
			return "Usuário precisa ter pelo menos 4 dígitos";
		}				
		if(usuario.getSenha() == null || usuario.getSenha().length() < 4) {
			return "Senha precisa ter pelo menos 4 dígitos";
		}				
		if(usuario.getNome() == null || usuario.getNome().isEmpty()) {
			return "Informe o nome do usuário";
		}				
		if(!Pattern.compile("^(.+)@(.+)$").matcher(usuario.getEmail()).matches()) {
			return "Email inválido";
		}				
		if(!Pattern.compile("^(\\d{10,11})$").matcher(usuario.getTelefone()).matches()) {
			return "Telefone inválido";
		}				
		if(usuario.getLogradouro() == null || usuario.getLogradouro().isEmpty()) {
			return "Logradouro inválido";
		}				
		if(usuario.getNumero() == null || usuario.getNumero() < 0) {
			return "Numero inválido";
		}				
		if(usuario.getBairro() == null || usuario.getBairro().isEmpty()) {
			return "Bairro inválido";
		}				
		if(usuario.getCidade() == null || usuario.getCidade().isEmpty()) {
			return "Cidade inválido";
		}				
		if(usuario.getEstado() == null || usuario.getEstado().isEmpty()) {
			return "Estado inválido";
		}				
		if(usuario.getCep() == null || usuario.getCep().isEmpty()) {
			return "Cep inválido";
		}
		if(usuario.getFotoBase64() != null) {
			String type = usuario.getFotoBase64().split("[/;]")[1];
			if(!type.equalsIgnoreCase("jpeg") && !type.equalsIgnoreCase("jpg") && !type.equalsIgnoreCase("png")) {
				return "Foto deve ser em formatos JPEG, JPG, PNG";
			}			
		}
		if(usuario.getCurriculoBase64() != null) {
			String type = usuario.getCurriculoBase64().split("[/;]")[1];
			if(!type.equalsIgnoreCase("pdf")) {
				return "Currículo deve ser em formato PDF";
			}			
		}
		
		Usuario usuarioLogin = usuarioDAO.consultaUsuarioPorLogin(usuario.getLogin());
		
		if(usuarioLogin != null && !usuario.equals(usuarioLogin)) {
			return "Usuário já cadastrado!";
		}
		return null;
	}
	
	private byte[] converterStreamParaByte(InputStream imagem) throws Exception {
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		int reads = imagem.read();
		while (reads != -1) {
			byteArray.write(reads);
			reads = imagem.read();
		}
		return byteArray.toByteArray();
	}
	
	private void gerarArquivoParaDownload(String arquivoBase64Download, HttpServletResponse response) {	
		try {
			response.setHeader("Content-Disposition", "attachment;filename=arquivo." + arquivoBase64Download.split("[/;]")[1]);
			
			/*Converte a base64 da imagem do bacno para byte[]*/
			new Base64();
			byte[] arquivoBase64Bytes = Base64.decodeBase64(arquivoBase64Download.split("base64,")[1]);
			
			/*Coloca os bytes em um objeto de entrada para processr*/
			InputStream inputStream = new ByteArrayInputStream(arquivoBase64Bytes);
			
			/*Inicio da resposta para o navegador*/
			int read = 0;
			byte[] bytes = new byte[1024];
			OutputStream outputStream = response.getOutputStream();		
			
			while((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			
			outputStream.flush();
			outputStream.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
