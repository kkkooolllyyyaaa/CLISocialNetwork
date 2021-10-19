package moonrock.clisocialnetwork.webSocketListener;

import moonrock.clisocialnetwork.webSocketListener.transfer.Message;
import moonrock.clisocialnetwork.webSocketListener.transfer.MessageDecoder;
import moonrock.clisocialnetwork.webSocketListener.transfer.MessageEncoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@ServerEndpoint(value = "/web-socket-listener", decoders = {MessageDecoder.class}, encoders = {MessageEncoder.class})
public class WebSocketListener {
    private Session session;
    private final List<Session> sessions = new LinkedList<>();

    @OnOpen
    public void onOpen(Session session) {

    }

    @OnMessage
    public void onMessage(Session session, Message message) {

    }

    @OnClose
    public void onClose(Session session) {

    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }


}
