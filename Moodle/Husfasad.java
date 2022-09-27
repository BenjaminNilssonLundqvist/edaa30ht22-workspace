import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

// Generera tal från start till stop med intervallet
// räkna antal varje siffra används i intervallet
// mata in i TreeMap som nyckelvärdespar
public class Husfasad {
    public static Map<Integer, Integer> digitMap(int start, int stop, int interval) {
        TreeMap<Integer, Integer> nbrmap = new TreeMap<>();
        ArrayList<Integer> tal = new ArrayList<>();
        for (int i = start; i <= stop; i++) { // Generera tal från start till stop med intervallet
            while (start < stop) {
                tal.add(start);
                start = start + interval;
            }
        }
        String text = tal.toString();
        int zero = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;

        for (String s : text.split("")) { // räkna antal varje siffra används i intervallet
            if (s.equals("0")) {
                zero++;
            } else if(s.equals("1")){
                one++;
            }else if (s.equals("2")) {
                two++;
            } else if (s.equals("3")) {
                three++;
            } else if (s.equals("4")) {
                four++;
            } else if (s.equals("5")) {
                five++;
            } else if (s.equals("6")) {
                six++;
            } else if (s.equals("7")) {
                seven++;
            } else if (s.equals("8")) {
                eight++;
            } else if (s.equals("9")) {
                nine++;

            }

        }
        nbrmap.put(0, zero);
        nbrmap.put(1, one);
        nbrmap.put(2, two);
        nbrmap.put(3, three);
        nbrmap.put(4, four);
        nbrmap.put(5, five);
        nbrmap.put(6, six);
        nbrmap.put(7, seven);
        nbrmap.put(8, eight);
        nbrmap.put(9, nine);

        return nbrmap;

    }

    public static void main(String[] args) {
        /*
         * int start = 101;
         * int stop = 125;
         * int interval = 2;
         * ArrayList<Integer> tal = new ArrayList<>();
         * for (int i = start; i <= stop; i++) {
         * while (start < stop) {
         * tal.add(start);
         * start = start + interval;
         * // System.out.println(tal);
         * }
         * 
         * }
         * String text = tal.toString();
         * int zero = 0;
         * int one = 0;
         * int two = 0;
         * int three = 0;
         * int four = 0;
         * int five = 0;
         * int six = 0;
         * int seven = 0;
         * int eight = 0;
         * int nine = 0;
         * for (String s : text.split("")) {
         * if (s.equals("1")) {
         * one++;
         * } else if (s.equals("2")) {
         * two++;
         * } else if (s.equals("3")) {
         * three++;
         * } else if (s.equals("4")) {
         * four++;
         * } else if (s.equals("5")) {
         * five++;
         * } else if (s.equals("6")) {
         * six++;
         * } else if (s.equals("7")) {
         * seven++;
         * } else if (s.equals("8")) {
         * eight++;
         * } else if (s.equals("9")) {
         * nine++;
         * 
         * }
         * 
         * }
         * System.out.println(zero + " " + one + " " + two + " " + three + " " + four +
         * " " + five + " " + six + " "
         * + seven + " " + eight + " " + nine);
         * }
         */
        System.out.println(digitMap(101, 125, 2));
    }

}
