package moonrock.clisocialnetwork.commandLogic.commandStructure;

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
    private String name;
    @Getter
    private String option;

    public Command() {

    }

    public abstract void setName(String name);

    public abstract void setOption(String option);

    public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
