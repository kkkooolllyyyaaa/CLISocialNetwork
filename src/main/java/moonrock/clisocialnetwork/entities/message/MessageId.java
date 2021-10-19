package moonrock.clisocialnetwork.entities.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@NoArgsConstructor
@AllArgsConstructor
public class MessageId implements Serializable {
    @Getter
    @Setter
    private String user1;
    @Getter
    @Setter
    private String user2;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MessageId))
            return false;
        MessageId other = (MessageId) o;
        return this.user1.equals(other.user1) && this.user2.equals(other.user2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }
}
