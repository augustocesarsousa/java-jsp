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
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();	
	private LoginDAO loginDAO = new LoginDAO();
    
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Login loginBean = new Login();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		try {
			if(loginDAO.validarLogin(login, senha)) {
				listar(request, response);
			} else {
				RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
				request.setAttribute("erro", true);
				request.setAttribute("mensagem", "Usuário ou senha inválido!");
				dispacher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher dispacher = request.getRequestDispatcher("acesso-liberado.jsp");
			request.setAttribute("usuarios", usuarioDAO.listar());
			dispacher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}

}
