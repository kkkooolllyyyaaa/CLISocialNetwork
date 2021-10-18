package moonrock.clisocialnetwork.webSocketListener.transfer;

import lombok.Data;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@Data
public class Message {
    private final String from;
    private final String to;
    private final String text;
}
