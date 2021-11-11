import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        // You cannot use Date class to extract individual Date fields
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        System.out.print("Input your date(YY/MM/DD HR:MIN): ");
        String date = s.nextLine();
        try {
            Pattern p = Pattern.compile("[0-9]{4}[\\S]?[0-9]{2}[\\S]?[0-9]{2}[\\s]?[0-9]{2}[:]?[0-9]{2}");
            Matcher m = p.matcher(date);
            if (!m.matches()) {
                throw new Exception();

            }
        } catch (Exception e) {
            System.out.println("Wrong date format");
            return;
        }
        StringTokenizer tokenizer = new StringTokenizer(date, "/");
        int uyear = Integer.parseInt(tokenizer.nextToken());
        int umonth = Integer.parseInt(tokenizer.nextToken());
        int uday = Integer.parseInt(tokenizer.nextToken(" ").substring(1));
        int uhour = Integer.parseInt(tokenizer.nextToken(":").substring(1));
        int uminute = Integer.parseInt(tokenizer.nextToken(":"));

        if ((year == uyear) && (minute == uminute) && (umonth == month) && (uday == day) && (uhour == hour)) {
            System.out.println("Time equals");
            System.out.printf("Program and your calendar time: %4d/%02d/%02d %02d:%02d\n", year, month + 1, day, hour, minute);
        } else {
            System.out.println("Time doesn't equals");
            System.out.printf("Your calendar time: %4d/%02d/%02d %02d:%02d\n", uyear, umonth + 1, uday, uhour, uminute);
            System.out.printf("Program calendar time: %4d/%02d/%02d %02d:%02d\n", year, month + 1, day, hour, minute);
        }
        //2012/08/17 12:30
    }
}
