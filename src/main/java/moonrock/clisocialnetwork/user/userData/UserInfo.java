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
    private String username;
    private String password;
}
