package moonrock.clisocialnetwork.commandLogic.commands;

import moonrock.clisocialnetwork.commandLogic.Command;
import moonrock.clisocialnetwork.database.DAOs.UsersDAO;
import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.exceptions.NoDataException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class ProfileCommand extends Command {
    private final UsersDAO usersDAO;

    public ProfileCommand(String name, String description, UsersDAO usersDAO) {
        super(name, description);
        this.usersDAO = usersDAO;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String username = getArg((String) req.getSession().getAttribute("command"));
        if (username != null && usersDAO.isUsernameExist(username)) {
            try {
                User user = usersDAO.getUserByUsername(username);
                return user.getDisplayBio();
            } catch (NoDataException unexpected) {
                unexpected.printStackTrace();
                return null;
            }
        } else if (username == null) {
            return "username arg required";
        } else {
            return "user isn't exist";
        }
    }

    private String getArg(String str) {
        String[] args = str.split("\\s", 2);
        return args[1];
    }
}
