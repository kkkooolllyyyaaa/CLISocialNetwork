package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.database.HibernateConfigurer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tsypk
 * @project CLISocialNetwork
 * Implements HibernateConfigurer
 * configure database and init entities in constructor
 */
@WebServlet(name = "controller", value = "/controller")
public class ControllerServlet extends HttpServlet implements HibernateConfigurer {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("sign_up") != null && req.getParameter("sign_up").equals("sign_up")) {
            req.getRequestDispatcher("/registration-servlet").forward(req, resp);
        } else if (req.getParameter("sign_in") != null && req.getParameter("sign_in").equals("sign_up")) {
            req.getRequestDispatcher("/authorization-servlet").forward(req, resp);
        }
    }

    public ControllerServlet() {
        configure();
    }
}
