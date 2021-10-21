package moonrock.clisocialnetwork.filters;

import moonrock.clisocialnetwork.database.HibernateConfigurer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author maxim-panchuk
 * @project CLISocialNetwork
 * Implements HibernateConfigurer
 * configure database and init entities in constructor
 */
@WebFilter("/*")
public class AuthorizationCheckFilter implements HibernateConfigurer, Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) req;
        final HttpServletResponse httpResponse = (HttpServletResponse) res;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        String loginURI = httpRequest.getContextPath() + "/login";

        HttpSession httpSession = httpRequest.getSession();


        boolean isLoggedIn = (httpSession != null && httpSession.getAttribute("username") != null);
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        System.out.println("isLoggedIn: " + isLoggedIn + "  " + httpSession.getAttribute("username"));
        System.out.println(httpRequest.getRequestURL().toString());

        if (isLoggedIn && (isLoginRequest || isLoginPage))
            httpRequest.getRequestDispatcher("/").forward(httpRequest, httpResponse);
        else if(!isLoggedIn && httpRequest.getRequestURL().toString().equals("http://localhost:8080/CLISocialNetwork-1.0-SNAPSHOT/")) {
            String loginPage = "/login.jsp";
            RequestDispatcher requestDispatcher = httpRequest.getRequestDispatcher(loginPage);
            requestDispatcher.forward(httpRequest, httpResponse);
        } else {
            chain.doFilter(httpRequest, httpResponse);
        }
    }
}
