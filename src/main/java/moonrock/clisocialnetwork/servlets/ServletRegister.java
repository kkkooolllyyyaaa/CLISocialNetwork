package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.database.DAOs.UsersDAOImpl;
import moonrock.clisocialnetwork.entities.user.User;

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

@WebServlet(name = "ServletRegister", value = "/reg")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        UsersDAOImpl usersDAO = new UsersDAOImpl();

        HttpSession httpSession = request.getSession();
        String destinationPage;

        if (usersDAO.isUsernameExist(username)) {
            destinationPage = "register.jsp";
        } else {
            User newUser = new User(username, password);
            usersDAO.addUser(newUser);
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);
            destinationPage = "home.jsp";
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destinationPage);
        requestDispatcher.forward(request, response);
    }
}
