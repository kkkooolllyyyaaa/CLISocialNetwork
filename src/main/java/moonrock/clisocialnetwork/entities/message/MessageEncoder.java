package moonrock.clisocialnetwork.entities.message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class MessageEncoder implements Encoder.Text<Message> {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String encode(Message message) {
        return gson.toJson(message);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
