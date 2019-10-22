package Date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class StringToDate {

    static Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    static Date calendarToDate(Calendar calendar){
        return calendar.getTime();
    }

    static Date stringToDate(String dateInString, SimpleDateFormat formatter) throws Exception{
            Date date = formatter.parse(dateInString);
            return date;
    }

    static LocalDate dateToLocalDate(Date date){
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    static String DateToString(Date date, SimpleDateFormat formatter) throws Exception{

        return "";
    }

    static void compare(String date1, String date2, SimpleDateFormat formatter) throws ParseException {
        Date d1 = formatter.parse(date1);
        Date d2 = formatter.parse(date2);
        if (d1.compareTo(d2) < 0) {
            System.out.println("date 1 < date 2");
        } else if (d1.compareTo(d2) == 0){
            System.out.println("date 1 == date 2");
        } else {
            System.out.println("date 1 > date 2");
        }
    }

    static Timestamp stringToTimestamp(String dateInString, SimpleDateFormat formatter) throws Exception{
        Date parseDate = formatter.parse(dateInString);
        Timestamp timestamp = new Timestamp(parseDate.getTime());
        return timestamp;
    }

    static void dateDiff(String date1, String date2, SimpleDateFormat formatter) throws Exception{
        Date d1 = formatter.parse(date1);
        Date d2 = formatter.parse(date2);

        LocalDate beginDate = dateToLocalDate(d1);
        LocalDate endDate = dateToLocalDate(d2);
        Period period = Period.between(beginDate, endDate);
        int days = period.getDays();
        int months = period.getMonths();
        int years = period.getYears();
        System.out.println(days+" days "+ months + " months "+ years +" years");
    }

    static void dayOfMonth(String dateInString, SimpleDateFormat formatter) throws Exception{
        Date date =  stringToDate(dateInString, formatter);
        Calendar calendar = dateToCalendar(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        LocalDate localDate = dateToLocalDate(date);
        System.out.println("Ngay dau tien cua thang: "+localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("Ngay cuoi cung cua thang: "+localDate.with(TemporalAdjusters.lastDayOfMonth()));

        int dayBeginOfWeek = calendar.getFirstDayOfWeek();
        System.out.println(dayBeginOfWeek);
        System.out.println("Ngay dau tien cua tuan: "+format.format(calendar.getTime()));

        calendar.add(Calendar.DATE, 100);
        Date dateFromCalendar = calendarToDate(calendar);

        String stringDate = format.format(dateFromCalendar);
        System.out.println("100 ngay sau: "+stringDate);
    }

    static void changeFormatter(String dateInString, SimpleDateFormat formatter) throws Exception{
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss");
        Date date = stringToDate(dateInString, formatter);
        String s1 = format1.format(date);
        String s2 = format2.format(date);

        System.out.println("Dinh dang yyyy-MM-dd HH:mm:ss: "+s1);
        System.out.println("Dinh dang MMM yyyy,dd HH:mm:ss: "+s2);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ngay dang: yyyy-MM-dd HH:mm:ss");//1998-11-20 07:08:09

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = sc.nextLine();

        System.out.println(stringToDate(dateInString, formatter));

        dayOfMonth(dateInString, formatter);

        System.out.println(stringToTimestamp(dateInString, formatter));
        changeFormatter(dateInString, formatter);

        System.out.println("Nhap ngay a dang: yyyy-MM-dd HH:mm:ss");
        String date1 = sc.nextLine();
        System.out.println("Nhap ngay b dang: yyyy-MM-dd HH:mm:ss");
        String date2 = sc.nextLine();
        compare(date1, date2, formatter);
        dateDiff(date1, date2, formatter);
    }
}
