package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;

@WebServlet("/pesquisa")
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomePesquisa");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		RequestDispatcher dispacher = request.getRequestDispatcher("listar.jsp");
		if(nome != null && !nome.isEmpty()) {
			request.setAttribute("usuarios", usuarioDAO .listar(nome));			
		}else {
			request.setAttribute("usuarios", usuarioDAO .listar(null));
		}
		
		dispacher.forward(request, response);
	}

}
