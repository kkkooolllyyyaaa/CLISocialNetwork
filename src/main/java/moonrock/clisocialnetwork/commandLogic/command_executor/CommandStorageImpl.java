package moonrock.clisocialnetwork.commandLogic.command_executor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import moonrock.clisocialnetwork.commandLogic.Command;
import moonrock.clisocialnetwork.exceptions.CommandIsNotExistException;

import java.util.HashMap;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@NoArgsConstructor
public class CommandStorageImpl implements CommandStorage {
    @Getter
    private final HashMap<String, Command> commands = new HashMap<>();

    @Override
    public Command getCommand(String name) throws CommandIsNotExistException {
        if (commands.containsKey(name)) {
            return commands.get(name);
        } else {
            throw new CommandIsNotExistException("Command " + name + " is not exist");
        }
    }

    @Override
    public void addCommand(Command command) {
        commands.put(command.getName(), command);
    }
}
