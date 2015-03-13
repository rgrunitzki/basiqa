package br.udesc.iqa.filter;

import java.io.IOException;
import javax.servlet.*;


/**
 * 
 * @author Ricardo Grunitzki
 */
public class CharacterEncodingFilter implements Filter {
	 
    /**
     * 
     * @param req
     * @param resp
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
	    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
	        req.setCharacterEncoding("UTF-8");
	        resp.setCharacterEncoding("UTF-8");
	        chain.doFilter(req, resp);
	    }
	 
            /**
             * 
             * @param filterConfig
             * @throws ServletException
             */
            @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	    }
	 
            /**
             * 
             */
            @Override
	    public void destroy() {
	    }
}