package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.database.DAOs.UsersDAO;
import moonrock.clisocialnetwork.database.DAOs.UsersDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author maxim-panchuk
 * @project CLISocialNetwork
 */

@WebServlet(name = "authorize-servlet", value = "/authorize-servlet")
public class AuthorizeServlet extends HttpServlet {
    private String destinationPage = "login.jsp";
    private UsersDAO usersDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(destinationPage).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        usersDAO = new UsersDAOImpl();
        if (usersDAO.isUserExist(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            destinationPage = "index.jsp";
        } else {
            destinationPage = "login.jsp";
        }
        request.getRequestDispatcher(destinationPage).forward(request, response);
    }
}
