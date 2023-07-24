package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import beans.Login;
import dao.LoginDAO;
import dao.UsuarioDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();	
	private LoginDAO loginDAO = new LoginDAO();
    
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login").trim();
		String senha = request.getParameter("senha").trim();
		String dadosValidados = validarDados(login, senha);
		
		if (dadosValidados == null) {
			if (loginDAO.validarLogin(login, senha)) {
				redirecionar(request, response, "liberar", false, null);
			} else {
				redirecionar(request, response, "bloquear", true, "Usuário ou senha inválido!");				
			}
		} else {
			redirecionar(request, response, "bloquear", true, dadosValidados);	
		}
	}
	
	private String validarDados(String login, String senha) {
		if(login == null || login.isEmpty()) {
			return "Informe um usuário";
		}
		if(senha == null || senha.isEmpty()) {
			return "Informe uma senha";
		}
		return null;
	}
	
	private void redirecionar(HttpServletRequest request, HttpServletResponse response, String acao, Boolean erro, String mensagem) {
		try {
			RequestDispatcher dispacher;
			
			switch (acao) {
				case "bloquear": {
					dispacher = request.getRequestDispatcher("index.jsp");
					break;
				}
				case "liberar": {
					dispacher = request.getRequestDispatcher("listar.jsp");
					request.setAttribute("usuarios", usuarioDAO.listar());
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

}
