package moonrock.clisocialnetwork.commandLogic.command_executor;

import moonrock.clisocialnetwork.commandLogic.Command;
import moonrock.clisocialnetwork.exceptions.CommandIsNotExistException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public String executeCommand(String commandName, HttpServletRequest req, HttpServletResponse resp) {
        CommandStorage commandStorage = (CommandStorage) req.getSession().getServletContext().getAttribute("commands");
        try {
            Command command = commandStorage.getCommand(commandName);
            return command.execute(req, resp);
        } catch (CommandIsNotExistException e) {
            return e.getMessage();
        }
    }
}
