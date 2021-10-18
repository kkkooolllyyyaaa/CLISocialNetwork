package moonrock.clisocialnetwork.user.authorization;

import moonrock.clisocialnetwork.user.User;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface UserAuthorizer {
    void authorize(User user);

    void register(User user);

}
