package String;

import java.util.*;

public class Ex1 {


    static String listToString(List<String> strings){
        return String.join(", ", strings);
    }

    static void combinations(String string){
        System.out.println("Substrings of \"" + string + "\" are :-");
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = 1; j <= string.length() - i; j++) {
                String sub = string.substring(i, j + i);
                hs.add(sub);
            }
        }
        for (String s: hs){
            System.out.println(s);
        }
    }

    static List<String> stringToList (String s){
        List<String> strings = new ArrayList<>();
        String[] output = s.split(",");
        for (int i= 0; i< output.length; i++){
            strings.add(output[i]);
        }
        return strings;
    }

    static void wordCount(String s){
        char[] arrayC = new char[100];
        int[] arrayI = new int[100];
        Map<Character, Integer> wordMap = new HashMap<>();
        for (int i= 0; i< s.length(); i++){
            for (int j= i + 1; j< s.length(); j++){
                if (s.charAt(j) == s.charAt(i)){
                    arrayC[i] = s.charAt(i);
                    arrayI[i] ++;
                }
            }
        }
    }

    static void printAllCombinations(String soFar, String rest) {
        Set<String> hs = new HashSet<>();
        if(rest.isEmpty()) {
            System.out.println(soFar);
            hs.add(soFar);
        } else {
            printAllCombinations(soFar + rest.substring(0,1), rest.substring(1));
            printAllCombinations(soFar , rest.substring(1));
        }
        for (String s: hs){
            System.out.println(s);
        }
    }

    static String replace(String raw, String from, String to){
        String replaceString = null;
        if (raw.contains(from)){
            replaceString = raw.replace(from, to);
        }else{
            System.out.println("Khong tim duoc chuoi can thay the");
        }
        return replaceString;
    }

    static void count(char x, String s, int n){
        int count = 0;

        for (int i= 0; i< s.length(); i++){
            if (x == s.charAt(i)){
                count ++;
            }
        }
        System.out.println("So lan xh: "+count);
        System.out.println("Phan tu dau tien xh o vi tri: "+s.indexOf(x));
        System.out.println("Phan tu cuoi cung xh o vi tri: "+s.lastIndexOf(x));
        int dem = 0;
        for (int i= 0; i< s.length(); i++){
            if (x == s.charAt(i)){
                dem ++;
            }
            if (dem == n){
                System.out.println("Xuan hien lan thu "+n+" o vi tri: "+i);
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s;
        char x;

        System.out.println("Nhap chuoi s: ");
        s = sc.nextLine();
//        printAllCombinations("", s);
        System.out.println("----------------");
        combinations(s);
        System.out.println("Nhap ki tu x: ");
        x = (char) System.in.read();
        System.out.println("Nhap lan thu n xuat hien: ");
        int n= sc.nextInt();
        count(x, s, n);
        System.out.println(replace("I am fresher", "fresher", "junior"));

        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("def");
        System.out.println(listToString(strings));

        String toList = "abc,edg,adfad";
        List<String> stringss = stringToList(toList);
        for (String s1: stringss){
            System.out.println(s1);
        }
    }
}
