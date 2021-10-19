package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.user.userData.UserBio;
import moonrock.clisocialnetwork.entities.user.User;

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
