package moonrock.clisocialnetwork.commandLogic.commands;

import moonrock.clisocialnetwork.commandLogic.commandStructure.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand extends Command {

    public String name = "";

    public String option = "";

    public LogoutCommand() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public void execute (HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("username");
            session.removeAttribute("password");
            String destinationPage = "login.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(destinationPage);
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
