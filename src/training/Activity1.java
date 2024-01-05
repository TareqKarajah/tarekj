package training;

import java.util.ArrayList;
import java.util.Scanner;

public class Activity1 {
    public static void main(String[] args) {
        ArrayList<String> list1 =new ArrayList<>();
        String s="hello";
        String s1="hello";
        list1.add(s);
        list1.add(s1);
System.out.println(list1.get(0)==list1.get(1)+" "+list1.get(0).equals(list1.get(1)));
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println("enter numbers and when you finish inter 0 ");
        Scanner in=new Scanner(System.in);
        int user=in.nextInt();
        while (user!=0) {
            user = in.nextInt();
            list.add(user);
        }
System.out.println("the max integer in the array list :"+max((list)));


    }

    public static Integer max(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return null;

        }
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max)
                max = list.get(i);

        }
        return max;
    }
}
