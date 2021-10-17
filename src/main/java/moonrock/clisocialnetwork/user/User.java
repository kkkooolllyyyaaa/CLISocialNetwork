package moonrock.clisocialnetwork.user;

import lombok.Data;
import moonrock.clisocialnetwork.user.userData.UserBio;
import moonrock.clisocialnetwork.user.userData.UserInfo;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Data
public abstract class User {
    private final UserInfo info;
    private UserBio bio;

    public User(UserInfo info) {
        this.info = info;
    }
}
