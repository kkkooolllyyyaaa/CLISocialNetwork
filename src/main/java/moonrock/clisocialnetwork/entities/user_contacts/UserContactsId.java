package moonrock.clisocialnetwork.entities.user_contacts;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Data
public class UserContactsId implements Serializable {
    private String username;
    private String contactName;
}
