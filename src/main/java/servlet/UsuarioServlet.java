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
		String id = request.getParameter("id");
		
		switch (acao) {
			case "listar": {
				redirecionar(request, response, "listar", null, false, null);
				break;
			}
			case "delete": {
				usuarioDAO.deletar(id);
				redirecionar(request, response, "listar", null, false, null);
				break;
			}
			case "editar": {
				Usuario usuario = usuarioDAO.consultaUsuarioPorId(id);
				redirecionar(request, response, "editar", usuario, false, null);
				break;
			}
			case "download": {
				String fotoBase64Download = usuarioDAO.consultaFoto(Long.parseLong(id));
				String attachament = "attachament;arquivo." + fotoBase64Download.split("[/;]")[1];
				System.out.println(attachament);
				response.setHeader("Content-Disposition", "attachament;arquivo." + fotoBase64Download.split("[/;]")[1]);
				/*Converte a base64 da imagem do bacno para byte[]*/
				new Base64();
				byte[] imageFotoBytes = Base64.decodeBase64(fotoBase64Download);
				/*Coloca os bytes em um objeto de entrada para processr*/
				InputStream inputStream = new ByteArrayInputStream(imageFotoBytes);
				/*Inicio da resposta para o navegador*/
				int read = 0;
				byte[] bytes = new byte[1024];
				OutputStream outputStream = response.getOutputStream();				
				while((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				outputStream.flush();
				outputStream.close();
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
		final String FOTO_USUARIO_PADRAO_BASE_64 = "data:image/jpeg;base64,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";
		String fotoBase64 = FOTO_USUARIO_PADRAO_BASE_64;
		Usuario usuario = null;
		String acao = null;
		String dadosValidados = null;
		
		try {
			if(ServletFileUpload.isMultipartContent(request)) {
				Part fotoUsuario = request.getPart("foto");
				if (fotoUsuario.getSize() > 0) {
					new Base64();
					fotoBase64 = "data:" + fotoUsuario.getContentType() + ";base64," + Base64.encodeBase64String(converteStreamParaByte(fotoUsuario.getInputStream()));					
				} else if (id != null){
					fotoBase64 = usuarioDAO.consultaFoto(id);						
				} 
			}			

			usuario = new Usuario(id, login, senha, nome, sobrenome, email, telefone, logradouro, numero, bairro, cidade, estado, cep, fotoBase64);
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
		
		Usuario usuarioLogin = usuarioDAO.consultaUsuarioPorLogin(usuario.getLogin());
		
		if(usuarioLogin != null && !usuario.equals(usuarioLogin)) {
			return "Usuário já cadastrado!";
		}
		return null;
	}
	
	private byte[] converteStreamParaByte(InputStream imagem) throws Exception {
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		int reads = imagem.read();
		while (reads != -1) {
			byteArray.write(reads);
			reads = imagem.read();
		}
		return byteArray.toByteArray();
	}
}
