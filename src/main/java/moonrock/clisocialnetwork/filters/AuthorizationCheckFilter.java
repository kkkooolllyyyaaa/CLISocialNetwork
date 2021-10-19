package moonrock.clisocialnetwork.filters;

import moonrock.clisocialnetwork.database.HibernateConfigurer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @author tsypk
 * @project CLISocialNetwork
 * Implements HibernateConfigurer
 * configure database and init entities in constructor
 */
@WebFilter(filterName = "authorization-filter", value = "/authorization-filter")
public class AuthorizationCheckFilter extends HttpFilter implements HibernateConfigurer {

    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
        configure();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        
    }
}
