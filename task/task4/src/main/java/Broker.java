
import javafx.util.Pair;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Broker {
    private final static int THRESHOLD = 3;
    private final static char BELOW_THRESHOLD = 'b';
    private final static char OVER_THRESHOLD = 'o';
    private static ConcurrentLinkedQueue<MyMessage> belowThresholdMQ = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedDeque<MyMessage> overThresholdMQ = new ConcurrentLinkedDeque<>();


    public static void produce(String msg){
        if (belowThresholdMQ.size()<THRESHOLD){
            Pair<String,Integer> pos = new Pair<>(String.valueOf(BELOW_THRESHOLD),belowThresholdMQ.size());
            MyMessage myMessage = new MyMessage(pos,msg);

            belowThresholdMQ.offer(myMessage);
            System.out.println("succeed in offering: "+msg);
            System.out.println("now there are "+belowThresholdMQ.size()+" messages.");
        }
        else {
            Pair<String,Integer> pos = new Pair<>(String.valueOf(OVER_THRESHOLD),overThresholdMQ.size());
            MyMessage myMessage = new MyMessage(pos,msg);

            overThresholdMQ.push(myMessage);
            System.out.println("succeed in offering: "+msg+"\n");
            System.out.println("now there are "+overThresholdMQ.size()+" messages.");

//            System.out.println("please wait");
        }
        System.out.println("----------------");
    }
    public static String consume(){
        StringBuilder msg= new StringBuilder();
        while (overThresholdMQ.size()>0){
            msg.append(overThresholdMQ.pop().getMessage());
            System.out.println("consume: "+msg);
            System.out.println("now there are "+overThresholdMQ.size()+" messages.");
            msg.append("\n");
        }
        while (belowThresholdMQ.size()>0){
            msg.append(belowThresholdMQ.poll().getMessage());
            if (msg!=null){
                System.out.println("consume: "+msg);
                System.out.println("now there are "+belowThresholdMQ.size()+" messages.");
                msg.append("\n");
            }
            else {
                System.out.println("no message available");
            }
        }
        System.out.println("----------------");
        return msg.toString();
    }

    /**
     * if position is an invalid number, it will return false,
     * else it will remove element in that position and return true
     * @param position
     * @return
     */
    public static boolean update(Pair<String,Integer> position){
        System.out.println("do sth");
        switch (position.getKey().charAt(0)){
            case BELOW_THRESHOLD:{
                if (position.getValue()>=0&&belowThresholdMQ.size()>position.getValue()){
                    /**
                     * it is definitely that the first in element will be
                     * remove first, so we just use poll()
                     */
//                    belowThresholdMQ.poll();
                    System.out.println("update: remove "+belowThresholdMQ.poll().getMessage());
                    System.out.println("now there are "+belowThresholdMQ.size()+" messages.");
                    return true;
                }
                else break;
            }
            case OVER_THRESHOLD:{
                if (position.getValue()>=0&&overThresholdMQ.size()>position.getValue()){
                    /**
                     * it is definitely that the first in element will be
                     * remove first and it is store at the end tail, so we just use pollLast()
                     */
                    System.out.println("update: remove "+overThresholdMQ.pollLast().getMessage());
                    System.out.println("now there are "+overThresholdMQ.size()+" messages.");
                    return true;
                }
                else break;
            }
        }
        return false;
    }
}
