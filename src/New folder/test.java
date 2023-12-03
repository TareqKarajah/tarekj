import java.io.File;
//import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class test {
    Train t = new Train();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number from this menu :" +
                "\n\t 1. Read passenger file." +
                "\n\t 2. Reserve a new empty seat." +
                "\n\t 3. Delete a reserved seat." +
                "\n\t 4. Delete all reserved seats." +
                "\n\t 5. Update passenger file." +
                "\n\t 6. Quit.");

        try {


            File pass = new File("passenger.txt");
            Scanner reader = new Scanner(pass);
            while (reader.hasNextLine()) {
                String name = reader.nextLine();
                System.out.println(name);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }

//        t.reserve(2,"khaled");


        try {
            FileWriter writer= new FileWriter("passenger.txt");
            for(int i = 0; i<23 ; i++){
                for(int j=0; j<4; j++){
//                    if (!Seat.isEmpty)

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



        //        int s = in.nextInt();
//    int r=(s%4);
//    if (r==0){
//        System.out.println(s/4);
//    }
//    else {
//        System.out.println(s/4+1);
//    }
//        int d = (s % 4);
//        System.out.println(s%4);
//
//        if (d == 0) {
//            System.out.println(4);
//        } else {
//            System.out.println(s % 4 );
//        }

