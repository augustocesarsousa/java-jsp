package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import factories.DataTableFactory;
import models.DataTableObject;

@WebServlet("/datatable")
public class DataTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DataTableServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataTableObject dataTableObject = DataTableFactory.createDataTableObject();
		Gson gson = new Gson();
		String json = gson.toJson(dataTableObject);
		
		response.setStatus(200);
		response.getWriter().write(json);
	}

}
