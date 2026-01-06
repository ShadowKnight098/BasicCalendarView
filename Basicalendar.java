import java.time.LocalDate;
import java.time.YearMonth;
import java.lang.Thread;
import java.util.*;
// class TimeMethood{
//     public void Timeparameter(){

//     }
// }
public class Basicalendar {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to Basic Calendar View");
            LocalDate today = LocalDate.now();
            YearMonth yearMonth = YearMonth.now();
            Thread.sleep(1000);
            System.out.println("      " + today.getMonth() + " " + today.getYear());
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");

            // First day of the month (1 = Monday, 7 = Sunday)
            int firstDay = yearMonth.atDay(1).getDayOfWeek().getValue();
            firstDay = firstDay % 7; // convert Sunday to 0

            // Print spaces before first date
            for (int i = 0; i < firstDay; i++) {
                System.out.print("    ");
            }

            int daysInMonth = yearMonth.lengthOfMonth();

            for (int day = 1; day <= daysInMonth; day++) {
                System.out.printf("%3d ", day);

                // Move to next line after Saturday
                if ((day + firstDay) % 7 == 0) {
                    System.out.println();
                }
            }
            //!  for specific date 
            Thread.sleep(1000);
            System.out.println("Do you want to search for specific date (yes / no )");
            String choice = sc.nextLine().toLowerCase();
            if (choice.equals("yes")  || choice.equals("y")) {
                System.out.println("Which date you wannna check  ");
                System.out.println("enter the month (1 - 12 ) ");
                int month = sc.nextInt();


                System.out.println("enter the year (Ex : 2000 ,.... ): ");
                int year = sc.nextInt();


                // ! the statement will return month and year
                YearMonth ym = yearMonth.of(year, month);
                System.out.println("the month is " + ym.getMonth() + " year : " + year);

                //? normal layout of wweeks
                System.out.println("Sun Mon Tue Wed Thu Fri Sat");
                int firstDay1 = ym.atDay(1).getDayOfWeek().getValue() % 7;
                for (int i = 0; i < firstDay1; i++) {
                    System.out.print("    ");
                }

                int daysInMonth1 = ym.lengthOfMonth();

                for (int day = 1; day <= daysInMonth1; day++) {
                    System.out.printf("%3d ", day);

                    if ((day + firstDay1) % 7 == 0) {
                        System.out.println();
                    }
                }

            }
            else{
                System.out.println("Have a Good day ");
            }
        }
        catch (Exception e){
            System.out.println("An error occured : " + e.getMessage());

        }
        finally {
            System.out.println("Thanks for using us ");

        }
    }

}
