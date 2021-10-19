package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.user.User;
import moonrock.clisocialnetwork.user.userData.UserBio;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface UsersDAO {
    User getUserByUsername(String username);

    CopyOnWriteArrayList<User> getAll();

    void addUser(User user);

    void deleteUser(User user);

    void updateUserBio(User user, UserBio userBio);
}
