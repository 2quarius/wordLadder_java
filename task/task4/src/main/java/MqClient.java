import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MqClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public MqClient(Socket socket) {
        try {
            this.socket = socket;
            this.out = new PrintWriter(socket.getOutputStream());
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void produce(String message) throws Exception {
        try  {
            out.println(message);
            out.flush();
            while (true){
                if (!in.readLine().isEmpty()){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //消费消息
    public String consume() throws Exception {
        //先向消息队列发送命令
        out.println("CONSUME");
        out.flush();

        //再从消息队列获取一条消息
        StringBuilder message = new StringBuilder();
        String msg;
        while (!(msg= in.readLine()).isEmpty()) {
            message.append(msg);
            message.append("\n");
        }
        return message.toString();
    }
}
