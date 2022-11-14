package others;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        Button buttonStart = new Button("Start");
        buttonStart.addActionListener(new EventHandler());
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent Occurred !!! ");
            }
        });

        new EventHandler();

        MyFunction f = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };
        int maxNum = f.max(3, 50);
    }

}

@FunctionalInterface
interface MyFunction{
    public abstract int max(int a, int b);
}

//interface others.MyFunction {
//    public abstract int max(int a, int b);
//}

class EventHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionEvent Occurred !!! ");
    }
}