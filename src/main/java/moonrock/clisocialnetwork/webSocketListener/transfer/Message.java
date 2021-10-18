package moonrock.clisocialnetwork.webSocketListener.transfer;

import lombok.Getter;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class Message implements Serializable {
    private final static long serialVersionUID = -42244224L;
    @Getter
    private final String from;
    @Getter
    private final String to;
    @Getter
    private final ZonedDateTime time;
    @Getter
    private final String text;

    public Message(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
        time = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
    }
}
