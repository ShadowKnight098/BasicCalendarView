import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.YearMonth;

public class  BasicCalendarView {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calendar");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        // Get current date
        LocalDate today = LocalDate.now();
        YearMonth yearMonth = YearMonth.now();

        // Header (Month & Year)
        JLabel header = new JLabel(
                today.getMonth() + " " + today.getYear(),
                JLabel.CENTER
        );
        header.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(header, BorderLayout.NORTH);

        // Days panel
        JPanel panel = new JPanel(new GridLayout(7, 7));

        // Day names
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : days) {
            panel.add(new JLabel(day, JLabel.CENTER));
        }

        // First day of month
        int firstDay = yearMonth.atDay(1).getDayOfWeek().getValue();
        firstDay = firstDay % 7; // Adjust for Sunday start

        // Empty cells before first day
        for (int i = 0; i < firstDay; i++) {
            panel.add(new JLabel(""));
        }

        // Add dates
        int daysInMonth = yearMonth.lengthOfMonth();
        for (int i = 1; i <= daysInMonth; i++) {
            panel.add(new JLabel(String.valueOf(i), JLabel.CENTER));
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
