package cn.fancy.io.buffer;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("1.txt")));
        out.writeChars("Hello World!");
        out.flush();
        FileInputStream in = new FileInputStream("1.txt");
        int len = in.available();
        byte[] b = new byte[len];
        in.read(b);
        String str = new String(b);
        System.out.println(str);
    }
}
