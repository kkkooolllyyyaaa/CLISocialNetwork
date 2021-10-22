package moonrock.clisocialnetwork.entities.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import moonrock.clisocialnetwork.entities.user.userData.UserBio;

import javax.persistence.*;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "bio")
    private String displayBio;
    @Transient
    private UserBio bio;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void initDisplayBio() {
        displayBio = bio.getJson();
    }


}
