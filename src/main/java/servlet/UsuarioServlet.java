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
		
		if(acao.equalsIgnoreCase("listar")) {
			listar(request, response);	
		}
		
		if(acao.equalsIgnoreCase("delete")) {
			if(usuarioDAO.deletar(id)) {
				listar(request, response);				
			}
		}
		
		if(acao.equalsIgnoreCase("editar")) {
			try {
				Usuario usuario = usuarioDAO.consultaUsuario(id);
				try {
					RequestDispatcher dispacher = request.getRequestDispatcher("editar-usuario.jsp");
					request.setAttribute("usuario", usuario);
					dispacher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(id == null || id.isEmpty()) {
			System.out.println("Insert");
			if(usuarioDAO.cadastrar(new Usuario(login, senha))) {
				listar(request, response);		
			}			
		} else {
			System.out.println("Update");
			if(usuarioDAO.update(new Usuario(Integer.parseInt(id), login, senha))) {
				listar(request, response);				
			}
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
