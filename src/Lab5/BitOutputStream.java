package Lab5;

import java.io.File;

public class BitOutputStream {
    public BitOutputStream(File file) {
    }

    public void writeBit(char bit) {
//        make the method to store the bits in a byte and write the byte to the file when it is full
        byte b = 0;
        if (bit == '1'|| bit == '0') {
            b = (byte) (b | 1);
        }


    }
}