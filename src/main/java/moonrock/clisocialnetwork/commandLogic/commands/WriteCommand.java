package moonrock.clisocialnetwork.commandLogic.commands;

import moonrock.clisocialnetwork.commandLogic.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class WriteCommand extends Command {
    public WriteCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String fullCommand = (String) session.getAttribute("command");
        String username = getArg1(fullCommand);
        String content = getArg2(fullCommand);

        return null;
    }

    private String getArg1(String str) {
        String[] args = str.split("\\s", 2);
        return args[1];
    }

    private String getArg2(String str) {
        String[] args = str.split("\\s", 2);
        return args[2];
    }
}
