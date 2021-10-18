package moonrock.clisocialnetwork.webSocketListener;

import moonrock.clisocialnetwork.webSocketListener.transfer.Message;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
@ServerEndpoint("/web-socket-listener")
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
    public void onError(Session session) {

    }


}
