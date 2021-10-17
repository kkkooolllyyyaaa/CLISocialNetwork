package moonrock.clisocialnetwork.commandLogic.commandStructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@AllArgsConstructor
public abstract class Command {
    @Getter
    private final String name;
    @Getter
    private final CommandDescription description;

    public abstract void execute(String[] args);
}
