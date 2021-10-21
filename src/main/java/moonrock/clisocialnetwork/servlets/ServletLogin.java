package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.database.DAOs.UsersDAOImpl;

import javax.servlet.RequestDispatcher;
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

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String destinationPage;

        UsersDAOImpl usersDAO = new UsersDAOImpl();
        if (usersDAO.isUserExist(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            destinationPage = "home.jsp";
        } else {
            destinationPage = "login.jsp";
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destinationPage);
        requestDispatcher.forward(request, response);
    }
}
