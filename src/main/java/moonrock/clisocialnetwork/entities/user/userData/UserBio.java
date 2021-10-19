package moonrock.clisocialnetwork.entities.user.userData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBio {
    private Integer age;
    private Sex sex;
    private MaritalStatus maritalStatus;
    private URL photo_url;
    private String aboutMe;

    public String getJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
