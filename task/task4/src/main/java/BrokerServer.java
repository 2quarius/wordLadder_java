import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BrokerServer implements Runnable {
    public static int SERVER_PORT = 9999;
    private final Socket socket;

    public BrokerServer(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while (true){
                System.out.println(in.ready());
                String str = in.readLine();
                if (str == null){
                    Thread.sleep(1000);
                    continue;
                }
                System.out.println("get message: "+str);
                if (str.equals("CONSUME")){
                    String message = Broker.consume();
                    System.out.println(message);
                    out.println(message);
                    out.flush();
                }
                else if (str.contains("SEND:")){
                    Broker.produce(str);
                    out.println("get message");
                    out.flush();
                }
                else {
                    System.out.println("wrong format.");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(SERVER_PORT);
        while (true) {
            BrokerServer brokerServer = new BrokerServer(server.accept());
            new Thread(brokerServer).start();
        }
    }
}
