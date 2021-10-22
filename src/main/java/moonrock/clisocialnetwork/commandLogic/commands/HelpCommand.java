package moonrock.clisocialnetwork.commandLogic.commands;

import moonrock.clisocialnetwork.commandLogic.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class HelpCommand extends Command {
    public HelpCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        @SuppressWarnings("unchecked")
        HashMap<String, Command> commands = (HashMap<String, Command>) session.getServletContext().getAttribute("commands");
        StringBuilder res = new StringBuilder();
        for (Command command : commands.values()) {
            res.append(command.getName()).append(": ").append(command.getDescription()).append("\n");
        }
        return res.toString();
    }
}
