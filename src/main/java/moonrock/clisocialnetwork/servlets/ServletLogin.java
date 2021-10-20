package moonrock.clisocialnetwork.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String destinationPage;

        if (login.equals("Makson")) {
            HttpSession session = request.getSession();
            session.setAttribute("login", "Makson");
            session.setAttribute("password", password);
            destinationPage = "home.jsp";
        } else {
            destinationPage = "login.jsp";
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destinationPage);
        requestDispatcher.forward(request, response);
    }
}
