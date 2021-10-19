package moonrock.clisocialnetwork.authorization;

import moonrock.clisocialnetwork.entities.user.User;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface UserAuthorizer {
    void authorize(User user);

    void register(User user);

}
