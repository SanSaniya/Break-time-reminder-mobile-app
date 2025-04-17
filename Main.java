import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter break length in minutes: ");        //taking user input for how long they want their break to be
        int breakLength = scanner.nextInt();
        System.out.print("Enter break frequency in minutes: ");     //taking user input for the frequency for the break
        int breakFrequency = scanner.nextInt();

        //creating instance of the BreakTimeReminderApp and sending length and frequency of break as parameters to initialize the new instance
        BreakReminderApp app = new BreakReminderApp(breakLength, breakFrequency);
        //calling the method startSchedule to start the timer
        app.startSchedule();

        //if in any case user wants to stop/quit the timer
        System.out.println("Press 's' to stop the schedule or 'q' to quit.");
        while (true) {
            String input = scanner.next();      //s to stop and q to quit
            if (input.equals("s")) {
                app.stopSchedule();                 //schedule stopped
            }
            else if (input.equals("q")) {
                if (app.isRunning()) {              //checking whether the method is still running
                    app.stopSchedule();             //schedule quit
                }
                break;      //after quitting, simply get out of this block and end the program
            }
        }

        scanner.close();
    }
}