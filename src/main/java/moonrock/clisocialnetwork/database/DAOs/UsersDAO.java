package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.entities.user.userData.UserBio;

import java.util.List;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface UsersDAO {
    boolean isExist(String username, String password);

    User getUserByUsername(String username);

    List<User> getAll();

    void addUser(User user);

    void deleteUser(User user);

    void updateUserBio(String username, UserBio userBio);
}
