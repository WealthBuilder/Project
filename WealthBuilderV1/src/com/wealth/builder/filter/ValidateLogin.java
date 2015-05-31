package com.wealth.builder.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateLogin implements Filter {

	private static Logger logger = Logger.getLogger("ValidateLogin");
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain arg2) throws IOException, ServletException {
		logger.info("doFilter");
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		
		if(httpReq.getSession().getAttribute("USER") == null)	{
			
			req.setAttribute("ERRORS", "Opps you are not logged in or your session has expired. Please login");
			
			req.getRequestDispatcher("login.jsp").forward(httpReq, httpResp);
			
			return;
		}
		
		arg2.doFilter(httpReq, httpResp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
