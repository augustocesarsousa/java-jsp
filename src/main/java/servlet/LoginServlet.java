package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Login;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login loginBean = new Login();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(loginBean.acesso(login, senha)) {
			RequestDispatcher dispacher = request.getRequestDispatcher("acesso-liberado.jsp");
			dispacher.forward(request, response);
		} else {
			RequestDispatcher dispacher = request.getRequestDispatcher("acesso-negado.jsp");
			dispacher.forward(request, response);
		}
	}

}
