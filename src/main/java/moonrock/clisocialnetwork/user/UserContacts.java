package moonrock.clisocialnetwork.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Entity
@Table(name = "contacts")
@NoArgsConstructor
@AllArgsConstructor
public class UserContacts {
    @Id
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String contactName;
}
