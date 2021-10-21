package moonrock.clisocialnetwork.database.DAOs;

import moonrock.clisocialnetwork.entities.user.User;
import moonrock.clisocialnetwork.entities.user.userData.UserBio;
import moonrock.clisocialnetwork.exceptions.DataExistException;
import moonrock.clisocialnetwork.exceptions.NoDataException;

import java.util.List;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public interface UsersDAO {
    boolean isExist(String username, String password) throws NoDataException;

    User getUserByUsername(String username) throws NoDataException;

    List<User> getAll();

    void addUser(User user) throws DataExistException;

    void deleteUser(User user) throws NoDataException;

    void updateUserBio(String username, UserBio userBio) throws NoDataException;
}
