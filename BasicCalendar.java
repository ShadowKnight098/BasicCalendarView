import java.time.YearMonth;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class BasicCalendar {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to Basic Calendar View");
            LocalDate today = LocalDate.now();
            YearMonth yearMonth = YearMonth.now();
            System.out.println("Loading current month calendar ! ....");
            Thread.sleep(1500);
            System.out.println("      " + today.getMonth() + " " + today.getYear());
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");

            // First day of the month (1 = Monday, 7 = Sunday)
            int firstDay1 = yearMonth.atDay(1).getDayOfWeek().getValue();
            firstDay1 = firstDay1 % 7; // convert Sunday to 0

            for (int i = 0; i < firstDay1; i++) {
                System.out.print("    ");
            }

            int daysInMonth = yearMonth.lengthOfMonth();

            for (int day = 1; day <= daysInMonth; day++) {
                System.out.printf("%3d ", day);

                // Move to next line after Saturday
                if ((day + firstDay1) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println("Do you Want a Specific date ? (yes / no )");
            String choice = sc.nextLine();
            if (choice.equals("yes") || choice.equals("y")) {
                System.out.print("Enter month (1-12): ");
                int month = sc.nextInt();

                System.out.print("Enter year: ");
                int year = sc.nextInt();

                YearMonth ym = YearMonth.of(year, month);

                // -------- LOAD HOLIDAYS FROM FILE --------
                Map<Integer, String> holidays = new HashMap<>();

                BufferedReader br = new BufferedReader(new FileReader("holidays.txt"));
                String line;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String[] date = parts[0].split("-");

                    int d = Integer.parseInt(date[0]);
                    int m = Integer.parseInt(date[1]);

                    if (m == month) {
                        holidays.put(d, parts[1]);
                    }
                }
                br.close();
                Thread.sleep(500);
                // ----------------------------------------

                System.out.println("\nSun Mon Tue Wed Thu Fri Sat");

                int firstDay = ym.atDay(1).getDayOfWeek().getValue() % 7;

                for (int i = 0; i < firstDay; i++) {
                    System.out.print("    ");
                }

                int days = ym.lengthOfMonth();

                for (int day = 1; day <= days; day++) {

                    if (holidays.containsKey(day)) {
                        System.out.printf("%2d* ", day); // holiday
                    } else {
                        System.out.printf("%3d ", day);
                    }

                    if ((day + firstDay) % 7 == 0) {
                        System.out.println();
                    }
                }
                Thread.sleep(1000);

                // -------- LEGEND --------
                if (!holidays.isEmpty()) {
                    System.out.println("\n\nLegend:");
                    System.out.println("h - Holiday");
                    int count = 0;
                    System.out.println("\nHolidays:");
                    for (int d : holidays.keySet()) {
                        System.out.println(d + " - " + holidays.get(d));
                        count++;
                    }
                    System.out.println(count + " holidays are there ");
                }
            }else{
                System.out.println();
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally{
            System.out.println("thanks for using the basic calendar ");
        }
    }
}
