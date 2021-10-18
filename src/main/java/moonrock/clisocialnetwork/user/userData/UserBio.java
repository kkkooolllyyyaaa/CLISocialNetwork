package moonrock.clisocialnetwork.user.userData;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.URL;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Data
@AllArgsConstructor
public class UserBio {
    private int age;
    private Sex sex;
    private MaritalStatus maritalStatus;
    private URL photo_url;
    private String aboutMe;
}
