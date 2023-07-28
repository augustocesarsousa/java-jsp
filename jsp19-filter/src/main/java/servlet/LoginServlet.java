package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pages/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String urlDestino = request.getParameter("urlDestino") == null ? "logado.jsp" : request.getParameter("urlDestino");
		RequestDispatcher dispatcher;
		
		if(login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", login);
			dispatcher = request.getRequestDispatcher(urlDestino);
		} else {
			dispatcher = request.getRequestDispatcher("login.jsp");
		}
		
		dispatcher.forward(request, response);
	}

}
