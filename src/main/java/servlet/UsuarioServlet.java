package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
		
		Usuario usuario = new Usuario(id, login, senha, nome, sobrenome, email, telefone, logradouro, numero, bairro, cidade, estado, cep);
		String acao = usuario.getId() == null ? "cadastrar" : "editar";
		String dadosValidados = validarDados(usuario);
		
		try {
			if(ServletFileUpload.isMultipartContent(request)) {
				Part fotoUsuario = request.getPart("foto");
				new Base64();
				String fotoBase64 = Base64.encodeBase64String(converteStreamParaByte(fotoUsuario.getInputStream()));
				System.out.println(fotoBase64);
				System.out.println(fotoUsuario.getContentType());
			}
			
			if (dadosValidados != null) {
				redirecionar(request, response, acao, usuario, true, dadosValidados);
			} else {
				if (acao.equals("cadastrar")) {
					//usuarioDAO.cadastrar(usuario);
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
