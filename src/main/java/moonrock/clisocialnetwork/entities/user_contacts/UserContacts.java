package moonrock.clisocialnetwork.entities.user_contacts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Entity
@Table(name = "contacts")
@IdClass(UserContactsId.class)
@NoArgsConstructor
@AllArgsConstructor
public class UserContacts {
    @Id
    @Getter
    @Setter
    private String username;
    @Id
    @Getter
    @Setter
    @Column(name = "contact_name")
    private String contactName;
}
