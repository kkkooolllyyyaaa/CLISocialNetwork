package moonrock.clisocialnetwork.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author maxim-panchuk
 * @project CLISocialNetwork
 */
@WebServlet(name = "controller", value = "/controller")
public class ControllerServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter printWriter = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            System.out.println("No cookies found");
        } else {
            for (Cookie cookie : cookies) {


                String name = cookie.getName();
                if (name.equals("command")) {
                    System.out.println(cookie.getValue());
                }
                if (name.equals("option")) {
                    System.out.println(cookie.getValue());
                }
            }
        }
    }
}
