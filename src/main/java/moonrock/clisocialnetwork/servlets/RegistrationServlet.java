package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.user.authorization.UserAuthorizer;
import moonrock.clisocialnetwork.user.authorization.UserAuthorizerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class RegistrationServlet extends HttpServlet {
    private final String authUrl = "/";
    private UserAuthorizer authorizer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToAuth(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "";
        String password = "";
        try {
            username = getParam(req, "username");
            password = getParam(req, "password");
            resp.setContentType("text/html");

        } catch (NullPointerException e) {
            forwardToAuth(req, resp);
        }
        authorizer = new UserAuthorizerImpl();
    }

    private String getParam(HttpServletRequest req, String paramName) throws NullPointerException {
        String param = req.getParameter(paramName);
        if (param != null && param.length() > 0)
            return param;
        else
            throw new NullPointerException();
    }

    private void forwardToAuth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(authUrl).forward(req, resp);
    }
}
