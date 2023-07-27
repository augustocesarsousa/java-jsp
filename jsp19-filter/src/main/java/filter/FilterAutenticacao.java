package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/pages/*")
public class FilterAutenticacao implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getServletPath();
		
		System.out.println(session.getAttribute("usuario"));
		System.out.println(url);
		
		if(session.getAttribute("usuario") == null && !url.equalsIgnoreCase("/pages/login")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?url="+url);
			dispatcher.forward(request, response);
			return;
		}		
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
				
	}
	
}
