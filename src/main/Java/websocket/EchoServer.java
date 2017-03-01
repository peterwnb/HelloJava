package websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by zzqno on 2017-2-28.
 * 注解式端点
 */
@ServerEndpoint("/echo")
public class EchoServer {

    @OnMessage
    public String echo(String incomingMessage){
        return "I got this("+incomingMessage+")"+" so I am sending it back!";
    }
}
