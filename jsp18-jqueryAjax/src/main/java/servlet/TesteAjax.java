package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste-ajax")
public class TesteAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TesteAjax() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			double numero1 = Double.parseDouble(request.getParameter("numero1"));
			double numero2 = Double.parseDouble(request.getParameter("numero2"));
			String operacao = request.getParameter("operacao");
			double resultado = 0;
			
			switch (operacao) {
				case "+": {
					resultado = numero1 + numero2;
					break;
				}
				case "-": {
					resultado = numero1 - numero2;
					break;
				}
				case "*": {
					resultado = numero1 * numero2;
					break;
				}
				case "/": {
					if(numero2 == 0) {
						throw new Exception("divisao por 0");
					}
					resultado = numero1 / numero2;
					break;
				}
			}
			
			response.setStatus(200);
			response.getWriter().write("Dados processados com sucesso: " + numero1 + " " + operacao + " " + numero2 + " = " + resultado);
		} catch (Exception e) {
			response.setStatus(422);
			response.getWriter().write("Erro ao processar os dados: " + e.getMessage());
		}
	}

}
