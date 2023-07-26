package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lista")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> lista = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("item");
		
		lista.add(item);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
		request.setAttribute("lista", lista);
		dispacher.forward(request, response);
	}

}
