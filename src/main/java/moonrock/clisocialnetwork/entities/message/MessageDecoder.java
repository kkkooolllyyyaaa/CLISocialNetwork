package moonrock.clisocialnetwork.entities.message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class MessageDecoder implements Decoder.Text<Message> {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Message decode(String s) {
        return gson.fromJson(s, Message.class);
    }

    @Override
    public boolean willDecode(String s) {
        return s != null;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
