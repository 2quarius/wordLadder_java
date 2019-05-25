import java.net.InetAddress;
import java.net.Socket;

public class ProduceClient implements Runnable{
    public void run(){
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVER_PORT);
            MqClient client = new MqClient(socket);

            String string = Double.toHexString(Math.random());
            client.produce("SEND:" + string + "-1 Hello World");
            client.produce("SEND:" + string + "-2 Hello broker");
            client.produce("SEND:" + string + "-3 Hello World");
            client.produce("SEND:" + string + "-4 Hello broker");
            client.produce("SEND:" + string + "-5 Hello World");
            client.produce("SEND:" + string + "-6 Hello broker");
            client.produce("SEND:" + string + "-7 Hello World");
            client.produce("SEND:" + string + "-8 Hello broker");
            client.produce("SEND:" + string + "-9 Hello World");
            client.produce("SEND:" + string + "-10 Hello broker");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 5; i++)
        {
            ProduceClient produceClient = new ProduceClient();
            new Thread(produceClient).start();
        }
    }
}
