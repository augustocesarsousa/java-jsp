package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Upload() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imagem = request.getParameter("imagem");
		
		System.out.println(imagem);
		
		if(imagem != null) {
			response.getWriter().write("Upload realizado com sucesso");			
		}else {
			response.setStatus(422);
			response.getWriter().write("Não foi possível realizar o upload");				
		}
	}

}
