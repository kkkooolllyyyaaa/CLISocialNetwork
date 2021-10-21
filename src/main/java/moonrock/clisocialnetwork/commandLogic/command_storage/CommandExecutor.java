package moonrock.clisocialnetwork.commandLogic.command_storage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface CommandExecutor {
    String executeCommand(String commandName, HttpServletRequest req, HttpServletResponse resp);
}
