package Lab5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity3 {
    public static void main(String[] args) {
        try {
            FileOutputStream output = new FileOutputStream("data.dat");
            DataOutputStream dataOutput = new DataOutputStream(output);
            for (int i = 0; i < 100; i++) {
                dataOutput.writeInt((int) (Math.random() * 100));
            }
            dataOutput.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}





