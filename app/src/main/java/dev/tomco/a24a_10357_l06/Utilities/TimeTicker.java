package dev.tomco.a24a_10357_l06.Utilities;

import java.util.Timer;
import java.util.TimerTask;

import dev.tomco.a24a_10357_l06.Interfaces.Callback_Timer;

public class TimeTicker {

    private final int DELAY = 1000;
    private Timer timer;
    private Callback_Timer callbackTimer;

    public TimeTicker(Callback_Timer callbackTimer) {
        timer = new Timer();
        this.callbackTimer = callbackTimer;
    }

    public void startTimer(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                callbackTimer.tick();
            }
        }, DELAY, DELAY);
    }

    public void stopTimer(){
        timer.cancel();
    }
}
