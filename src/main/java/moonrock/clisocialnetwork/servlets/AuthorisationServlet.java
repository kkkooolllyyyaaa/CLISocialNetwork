package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.user.authorization.UserAuthorizer;
import moonrock.clisocialnetwork.user.authorization.UserAuthorizerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@WebServlet(name = "authorization-servlet", value = "/authorization-servlet")
public class AuthorisationServlet extends HttpServlet {
    private final String authUrl = "/";
    UserAuthorizer authorizer;

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
            PrintWriter printWriter = resp.getWriter();
            printWriter.print("<html>");
            printWriter.print("<body>");
            printWriter.print("<h1>Student Registration Form Data</h1>");
            printWriter.print("<p> username :: " + username + "</p>");
            printWriter.print("<p> password :: " + password + "</p>");
            printWriter.print("</body>");
            printWriter.print("</html>");
            printWriter.close();
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
