package moonrock.clisocialnetwork.commandLogic.commands;

import moonrock.clisocialnetwork.commandLogic.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        return null;
    }
}
