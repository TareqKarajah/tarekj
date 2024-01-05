package Lab5;

public class Activity4 {
    public static void main(String[] args) {
        int sum = 0;

        try {
            java.io.DataInputStream input = new java.io.DataInputStream(new java.io.FileInputStream("data.dat"));
            while (true) {
                sum += input.readInt();


            }
        } catch(java.io.EOFException ex){
        } catch(java.io.IOException ex){
                    System.out.println("Error: " + ex.getMessage());
                }
        System.out.println("Sum of numbers in file: " + sum);

    }

}