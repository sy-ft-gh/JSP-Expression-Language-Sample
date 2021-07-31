package filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ErrorHandlingFilter
 */
@WebFilter(filterName = "ErrorHandlingFilter" , urlPatterns = "/*")
public class ErrorHandlingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ErrorHandlingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
	        ServletContext context = request.getServletContext();
	        context.log("ErrorHandlingFilter-doFilter");    
			
			chain.doFilter(request, response);
		} catch(Exception ex) {
			ex.printStackTrace();
		    // 設定されたフォワード先にフォワード
			request.setAttribute("msg", ex.getMessage());
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp");
		    dispatcher.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
