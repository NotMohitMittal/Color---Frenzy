package in.TimerForGame;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;

import in.GameLogic.GameFrame;

public class CountDownTimer extends JFrame {

    public int secondsLimit;
    Timer countDown;
    JLabel label;
    boolean flag;
    

    public CountDownTimer(int secondsLimit, JLabel label) {
        this.secondsLimit = secondsLimit;
        this.label = label;
    }
    public void startTimer() {
        flag = false;
        countDown = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("" + secondsLimit);
                secondsLimit--;
                if(secondsLimit <= 0) {
                    label.setText("Lost");
                    countDown.stop();
                    flag = true;
                    notifyTimeOver();
                }
            }
        });
        countDown.start();
    }

    public void stopTimer() {
        if(countDown != null) {
            countDown.stop();
        }
    }

    public boolean isTimeOver() {
        return flag;
    }

    public void notifyTimeOver() {
        if(isTimeOver()) {
            GameFrame gameFrame = new GameFrame();
            gameFrame.isPlayerOutOfTime();
        }
    }

    
}
