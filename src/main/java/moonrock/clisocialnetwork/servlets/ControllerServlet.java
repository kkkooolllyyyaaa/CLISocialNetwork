package moonrock.clisocialnetwork.servlets;

import moonrock.clisocialnetwork.database.HibernateConfigurer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author tsypk
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
        if (req.getParameter("sign_up") != null && req.getParameter("sign_up").equals("sign_up")) {
            req.getRequestDispatcher("/registration-servlet").forward(req, resp);
        } else if (req.getParameter("sign_in") != null && req.getParameter("sign_in").equals("sign_up")) {
            req.getRequestDispatcher("/authorization-servlet").forward(req, resp);
        }
    }

    public ControllerServlet() {
        configure();
    }

    public static String getBody (HttpServletRequest request) throws IOException {
        String body;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        body = stringBuilder.toString();
        return body;
    }
}
