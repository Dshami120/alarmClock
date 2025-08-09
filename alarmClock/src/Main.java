import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main
{

    public static void main(String[] args)
    {

        Scanner kbd = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime alarmTime = null;

        System.out.println(" the current time is:  " + formatter.format(LocalDateTime.now())); // display current time (int proper format)

        while(alarmTime == null) {
            try {
                System.out.print("Enter alarm time (HH:mm): ");
                String inputTime = kbd.nextLine();
                alarmTime = LocalTime.parse(inputTime, formatter); // parse alarm time so it can display or take in our format
                System.out.println(" the alarm is set to: " + alarmTime);
            } catch (DateTimeParseException e) {
                System.out.println(" Invalid format. Please use HH:MM"); // this is all dangerous code, so we use this exception handler to avoid it breakign if something diff than a time is entered like a food item.
            }
        }



        kbd.close();
    }
}