package moonrock.clisocialnetwork.filters;

import moonrock.clisocialnetwork.database.HibernateConfigurer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;
        final HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (isAttributesSet(req, "username", "password")) {
            moveToMenu(req, res);
        } else if (username.equals("username") && password.equals("password")) {
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", username);

            moveToMenu(req, res);
        } else {
            moveToLogin(req, res);
        }

        chain.doFilter(req, res);
    }

    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, res);
    }

    private void moveToLogin(final HttpServletRequest req,
                             final HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/auth.jsp").forward(req, res);
    }

    private boolean isAttributesSet(HttpServletRequest req, String... args) {
        for (String str : args) {
            if (req.getParameter(str) == null)
                return false;
        }
        return true;
    }
}
