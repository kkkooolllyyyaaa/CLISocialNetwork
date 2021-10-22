package moonrock.clisocialnetwork.commandLogic;

import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@AllArgsConstructor
public abstract class Command {
    private final String name;
    private final String description;

    public abstract String execute(HttpServletRequest req, HttpServletResponse resp);

    public final String getName() {
        return name;
    }

    public final String getDescription() {
        return description;
    }
}
