package Collections.Ex2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Handler {

    public ArrayList<Bill> bills;

    public void add() {
        Bill b0 = new Bill(1, "LHKhanh 1", 1000000, "2019-10-18");
        Bill b1 = new Bill(1, "LHKhanh 1", 1000000, "2019-10-18");
        Bill b2 = new Bill(2, "LHKhanh 2", 1200000, "2019-10-17");
        Bill b3 = new Bill(3, "LHKhanh 3", 1500000, "2017-10-19");
        Bill b4 = new Bill(4, "LHKhanh 4", 900000, "2018-09-30");
        Bill b5 = new Bill(5, "LHKhanh 5", 1400000, "2018-09-30");
        Bill b6 = new Bill(6, "LHKhanh 6", 500000, "2016-09-16");
        Bill b7 = new Bill(7, "LHKhanh 7", 800000, "2014-09-20");
        Bill b8 = new Bill(8, "LHKhanh 8", 90000, "2018-09-12");
        Bill b9 = new Bill(8, "LHKhanh 8", 90000, "2018-09-12");
        Bill b10 = new Bill(8, "LHKhanh 8", 90000, "2018-09-12");

        bills = new ArrayList<>();
        bills.add(b1);
        bills.add(b2);
        bills.add(b3);
        bills.add(b4);
        bills.add(b5);
        bills.add(b6);
        bills.add(b7);
        bills.add(b8);
        bills.add(b9);
        bills.add(b10);
    }

    public void print(ArrayList<Bill> listOfBills) {
        for (Bill b : listOfBills) {
            System.out.println(b.toString());
        }
    }

    public void sortByMoney() {
        Collections.sort(bills, new MoneyComparator());
    }

    public ArrayList<Bill> moreThanOneMillion(){
        ArrayList<Bill> lists = new ArrayList<>();
        for(Bill b: bills){
            if (b.getMoney() >= 1000000){
                lists.add(b);
            }
        }
        return lists;
    }

    public void distinctDate(){
        Set<String> dates = new HashSet<>();
        for (Bill b: bills){
            dates.add(b.getDate());
        }
        for (String s: dates){
            System.out.println(s);
        }
    }

    public void distinctIdAndName(){
        Set<Bill> billSet = new HashSet<>(bills);
        for (Bill b: billSet){
            System.out.println(b);
        }
    }

    public void sameDate() {
        List<Bill> listB = new ArrayList<>();
//        Map<String, List<String>> has = bills.stream().collect(
//                Collectors.groupingBy(Bill::getDate,
//                        Collectors.mapping(Bill::getName, Collectors.toList()))
//        );
        Map<String, List<Bill>> has = new HashMap<>();
        for (Bill b: bills){
            if (!has.containsKey(b.getDate())){
                listB.add(b);
                has.put(b.getDate(), listB);
            }else{

            }
        }
    }

    public class MoneyComparator implements Comparator<Bill> {
        @Override
        public int compare(Bill b1, Bill b2) {
            if (b1.getMoney() == b2.getMoney()) {
                return 0;
            } else if (b1.getMoney() > b2.getMoney()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
