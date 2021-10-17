package moonrock.clisocialnetwork.user;

import moonrock.clisocialnetwork.user.userData.UserBio;
import moonrock.clisocialnetwork.user.userData.UserInfo;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class CommonUser extends User {

    public CommonUser(UserInfo info) {
        super(info);
    }

    public CommonUser(UserInfo info, UserBio userBio) {
        super(info);
        setBio(userBio);
    }

}
