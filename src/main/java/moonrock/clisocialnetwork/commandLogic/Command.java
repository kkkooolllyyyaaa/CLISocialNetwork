package moonrock.clisocialnetwork.commandLogic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@AllArgsConstructor
public abstract class Command {
    @Getter
    private final String name;
    @Getter
    private final String description;

    public abstract String execute(HttpServletRequest req, HttpServletResponse resp);

}
