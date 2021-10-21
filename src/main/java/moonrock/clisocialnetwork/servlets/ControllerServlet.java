package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.database.HibernateConfigurer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author maxim-panchuk
 * @project CLISocialNetwork
 */
@WebServlet(name = "controller", value = "/controller")
public class ControllerServlet extends HttpServlet implements HibernateConfigurer {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            System.out.println("No cookies found");
        } else {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();


            }
        }
    }

    public ControllerServlet() {
        configure();
    }


}
