package org.example.code.C_13_Serialiazble;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class TestController {
    public static void main(String[] args) throws IOException {

        HelloSerialize helloSerialize = new HelloSerialize();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(helloSerialize);

        byte [] serialized;
        serialized = byteArrayOutputStream.toByteArray();

        System.out.println("serialized = "+ Arrays.toString(serialized));
        /*
serialized = [-84, -19, 0, 5, 115, 114, 0, 37, 99, 111, 100, 101, 46, 67, 95, 49, 51, 95, 83, 101, 114, 105, 97, 108, 105, 97, 122, 98, 108, 101, 46, 72, 101, 108, 108, 111, 83, 101, 114, 105, 97, 108, 105, 122, 101, 3, 119, -100, -75, -47, -63, 38, -60, 2, 0, 0, 120, 112]
         */
    }
}
