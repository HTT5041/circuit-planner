package util;

import java.util.HashMap;

public class Scheduler {

    private HashMap<SchedulerCallback, Long> scheduledEvents = new HashMap<SchedulerCallback, Long>();

    public Scheduler() {
        //start new thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(100);

                        //check if any events are due
                        for(SchedulerCallback callback : scheduledEvents.keySet()){
                            if(scheduledEvents.get(callback) < System.currentTimeMillis()){
                                callback.callback();
                                scheduledEvents.remove(callback);
                            }
                        }

                    } catch (InterruptedException e) {
                        System.out.println("Scheduler thread interrupted");
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void scheduleEvent(SchedulerCallback callback, int delay_s){
        scheduledEvents.put(callback, System.currentTimeMillis() + (delay_s * 1000L));
    }

}
