import javafx.util.Pair;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMessage {

    private final static Integer delay = new Integer(10000);
    /**
     * for alarm and time report
     */
    private Timer timer;
    /**
     * String indicates which queue,
     * Integer indicates which index.
     */
    private Pair<String,Integer> position;
    /**
     * exact message content
     */
    private String message;
    public MyMessage(Pair<String,Integer> position,String message){
        this.position = position;
        this.message = message;
        /**
         * the delay in milliseconds
         */
        timer = new Timer(delay,clearMyself(position));
        timer.start();
    }

    public String getMessage() {
        return message;
    }

    public ActionListener clearMyself(final Pair<String,Integer> position){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("do");
                Broker.update(position);
            }
        };
        return actionListener;
    }
}
