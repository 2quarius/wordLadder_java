import java.net.InetAddress;
import java.net.Socket;

public class ConsumeClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVER_PORT);
        MqClient client = new MqClient(socket);
        String message = client.consume();

        System.out.println("获取的消息为：" + message);
    }
}
