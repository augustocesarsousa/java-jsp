package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.UsuarioDAO;

@WebServlet("/UsuarioServlet")
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
		String dadosValidados = validarDados(request.getParameter("login"), request.getParameter("senha"));
		Usuario usuario = new Usuario(
				request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : null, 
				request.getParameter("login"), 
				request.getParameter("senha"));
		
		if(dadosValidados != null) {
			if(usuario.getId() == null) {
				redirecionar(request, response, "cadastrar", usuario, true, dadosValidados);				
			} else {
				redirecionar(request, response, "editar", usuario, true, dadosValidados);			
			}			
		} else {			
			Usuario usuarioLogin = usuarioDAO.consultaUsuarioPorLogin(usuario.getLogin());
			
			if(usuarioLogin != null && !usuario.equals(usuarioLogin)) {
				if(usuario.getId() == null) {
					redirecionar(request, response, "cadastrar", usuario, true, "Usuário já cadastrado!");					
				} else {
					redirecionar(request, response, "editar", usuario, true, "Usuário já cadastrado!");			
				}				
			} else {				
				if(usuario.getId() == null) {
					usuarioDAO.cadastrar(usuario);
					redirecionar(request, response, "listar", null, false, null);
				} else {
					usuarioDAO.update(usuario);
					redirecionar(request, response, "listar", null, false, null);
				}				
			}			
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
	
	private String validarDados(String login, String senha) {				
		if(login == null || login.replace(" ", "").length() < 4) {
			return "Usuário precisa ter pelo menos 4 dígitos";
		}				
		if(senha == null || senha.replace(" ", "").length() < 4) {
			return "Senha precisa ter pelo menos 4 dígitos";
		}
		return null;
	}
}
