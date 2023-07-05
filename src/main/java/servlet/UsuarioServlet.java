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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario(login, senha);
		
		if(usuarioDAO.cadastrar(usuario)) {
			try {
				RequestDispatcher dispacher = request.getRequestDispatcher("cadastro-usuario.jsp");
				request.setAttribute("usuarios", usuarioDAO.listar());
				dispacher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
