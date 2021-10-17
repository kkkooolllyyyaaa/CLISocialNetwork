package moonrock.clisocialnetwork.user.userData;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Data
@AllArgsConstructor
public class UserInfo {
    private String firstName;
    private String secondName;
    private String password;
}
