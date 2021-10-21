package moonrock.clisocialnetwork.entities.message;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "messages")
public class Message {
    @Id
    private Integer id;
    @Column(name = "user1")
    private String from;
    @Column(name = "user2")
    private String to;
    private ZonedDateTime time;
    private String content;

    public Message() {
        if (time == null)
            time = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
    }

    public Message(Integer id, String from, String to, String content) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Message message = (Message) o;
        return id != null && Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
