package moonrock.clisocialnetwork.commandLogic.command_storage;

import moonrock.clisocialnetwork.commandLogic.Command;
import moonrock.clisocialnetwork.exceptions.CommandIsNotExistException;

import java.util.HashMap;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface CommandStorage {
    Command getCommand(String name) throws CommandIsNotExistException;

    void addCommand(Command command);

    HashMap<String, Command> getCommands();
}
