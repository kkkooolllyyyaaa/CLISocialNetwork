package moonrock.clisocialnetwork.user.authorisation;

import moonrock.clisocialnetwork.user.User;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface UserAuthoriser {
    void authorize(User user);

    void register(User user);


}
