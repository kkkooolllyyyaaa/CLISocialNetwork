package moonrock.clisocialnetwork.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@WebServlet(name = "controller", value = "/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("sign_up") != null && req.getParameter("sign_up").equals("sign_up")) {

        } else if (req.getParameter("sign_in") != null && req.getParameter("sign_in").equals("sign_up")) {

        }
    }
}
