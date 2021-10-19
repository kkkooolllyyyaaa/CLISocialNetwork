package moonrock.clisocialnetwork.entities.message;

import lombok.Getter;
import lombok.Setter;
import moonrock.clisocialnetwork.utils.StringComparator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Entity
@Table(name = "messages")
@IdClass(MessageId.class)
public class Message {
    @Id
    private String user1;
    @Id
    private String user2;
    @Getter
    @Setter
    private ZonedDateTime time;
    @Getter
    @Setter
    private String content;


    public Message() {
        time = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
    }

    public void initUsers() {
        StringComparator comparator = new StringComparator(user1, user2);
        this.user1 = comparator.getFirst();
        this.user2 = comparator.getSecond();
    }
}
