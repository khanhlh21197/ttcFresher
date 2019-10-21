package Collections.Ex2;

public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();
        handler.add();
        System.out.println("Sap xep theo thu tu tang dan Money: ");
        handler.sortByMoney();
        handler.print(handler.bills);
        System.out.println("Ngay lap hoa don: ");
        handler.distinctDate();
        System.out.println("Money > 100000: ");
        handler.print(handler.moreThanOneMillion());
        System.out.println("Hoa don co cung ngay:");
        handler.sameDate();
    }
}
