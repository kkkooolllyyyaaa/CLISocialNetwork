package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.database.DAOs.UsersDAO;
import moonrock.clisocialnetwork.database.DAOs.UsersDAOImpl;
import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.exceptions.DataExistException;

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

@WebServlet(name = "register-servlet", value = "/register-servlet")
public class RegisterServlet extends HttpServlet {
    private String destinationPage = "register.jsp";
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

        HttpSession httpSession = request.getSession();
        try {
            if (usersDAO.isUsernameExist(username)) {
                destinationPage = "register.jsp";
            } else {
                User newUser = new User(username, password);
                usersDAO.addUser(newUser);
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);
                destinationPage = "index.jsp";
            }
        } catch (DataExistException unexpected) {
            unexpected.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destinationPage);
        requestDispatcher.forward(request, response);
    }
}
