package Date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    static String getDay(String date){
        return date.substring(8,10);
    }

    static int getIntDay(String date){
        return Integer.parseInt(date.substring(8,10));
    }

    static String getMonth(String date){
        return date.substring(5,7);
    }

    static int getIntMonth(String date){
        return Integer.parseInt(date.substring(5,7));
    }

    static String getYear(String date){
        return date.substring(0,4);
    }

    static int getIntYear(String date){
        return Integer.parseInt(date.substring(0,4));
    }

    static void dateDiff(String date1, String date2, SimpleDateFormat formatter) throws Exception{
        Date d1 = formatter.parse(date1);
        Date d2 = formatter.parse(date2);

        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long diffMonths = diff / (24 * 60 * 60 * 1000) % 12;
        long diffYears = diffDays % 365;

        System.out.print(diffYears + " years,");
        System.out.print(diffMonths + " months,");
        System.out.print(diffDays + " days, ");
        System.out.print(diffHours + " hours, ");
        System.out.print(diffMinutes + " minutes, ");
        System.out.print(diffSeconds + " seconds.");
    }

    static void dayOfMonth(String dateInString, SimpleDateFormat formatter) throws Exception{
        Date date =  stringToDate(dateInString, formatter);
        Calendar calendar = dateToCalendar(date);
        System.out.println(getIntMonth(dateInString)+"");

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        int beginOfMonth = calendar.getActualMinimum(Calendar.DATE);
        calendar.set(getIntYear(dateInString), getIntMonth(dateInString), beginOfMonth);
        System.out.println("Ngay dau tien cua thang: "+format.format(calendar.getTime()));

        int endOfMonth = calendar.getMaximum(Calendar.DATE);
        calendar.set(getIntYear(dateInString), getIntMonth(dateInString), endOfMonth);
        System.out.println("Ngay cuoi cung cua thang: "+format.format(calendar.getTime()));

        int dayBeginOfWeek = calendar.getFirstDayOfWeek();
        calendar.set(getIntYear(dateInString), getIntMonth(dateInString) - 1, dayBeginOfWeek);
        System.out.println("Ngay dau tien cua tuan: "+format.format(calendar.getTime()));

        calendar.add(Calendar.DATE, 100);
        Date dateFromCalendar = calendarToDate(calendar);
//        System.out.println(beginDay);
//        System.out.println(endDay);
//        System.out.println(dayBeginOfWeek);
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
