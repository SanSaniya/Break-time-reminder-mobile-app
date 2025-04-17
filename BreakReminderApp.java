import java.util.Timer;
import java.util.TimerTask;

class BreakReminderApp {
    private int breakLength; // length of break in minutes
    private int breakFrequency; // length of the break in minutes
    private Timer timer;            //that's a datatype of type "timer" :)
    private boolean isBreakTime;        //is true when it is break time else false

    //initializing the values of length and frequency of break for the given instance
    public BreakReminderApp(int breakLength, int breakFrequency) {
        this.breakLength = breakLength;
        this.breakFrequency = breakFrequency;
        this.isBreakTime = false;
    }

    //this will start the timer and now ur time is being counted for break time
    public void startSchedule() {
        if (timer == null) {            //if time just started
            timer = new Timer();        //you create a new "timer" dynamically using "Timer()" class
            TimerTask task = new TimerTask() {          //"task" is the new instance of TimerTask() class and it schedules a repeated execution of the fellow methods
                @Override
                public void run() {             //runs the repeated execution to be performed by the class
                    if (isBreakTime) {          //when iyts time to take a break
                        System.out.println("Your break is over :) time to get back to work :)");
                        isBreakTime = false;
                    } else {                    //when the break is over
                        System.out.println("It's break time!");
                        isBreakTime = true;
                    }
                }
            };
            // a given method to schedule the specified task for repeated fixed-rate (period) execution, beginning after the specified delay(delay)
            timer.scheduleAtFixedRate(task, 0, breakFrequency * 60 * 1000); // convert minutes to milliseconds
        }
        //the timer has started and the schedule is in running state already.
        else {
            System.out.println("Schedule is already running.");
        }
    }

    //method to stop the schedule
    public void stopSchedule() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            System.out.println("Schedule stopped.");
        } else {
            System.out.println("Schedule is not running.");
        }
    }

    //method to check whether the schedule is still running or not
    public boolean isRunning() {
        return timer != null;
    }
}