package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final int HORA_DIA = 24;
	private Date dataCalculada;

	public DataServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String dataInicial = request.getParameter("data-inicial");
			int tempo = Integer.parseInt(request.getParameter("tempo-horas"));
			
			if(tempo < HORA_DIA) {
				dataCalculada = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicial);
			} else {
				Double totalDias = .0;
				totalDias = (double) (tempo / HORA_DIA);
				Date dataInformada = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicial);
				Calendar calendar = Calendar.getInstance();
					
				calendar.setTime(dataInformada);
				calendar.add(Calendar.DATE, totalDias.intValue());
					
				dataCalculada = calendar.getTime();				
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("dataFinal", new SimpleDateFormat("dd/MM/yyyy").format(dataCalculada));
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
