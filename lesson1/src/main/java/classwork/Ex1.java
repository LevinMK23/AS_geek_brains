package classwork;

import java.util.ArrayList;

public class Ex1 {
    public static void main(String[] args) {
        int a = (-25); // 4b = 32bit
        //2^31 0 2^31-1
        //1100
        //a -> [-1 << 31 ; (1 << 31) - 1] 0 ... 127
        //System.out.println(Integer.toBinaryString(a));
        System.out.println("byte 8 bit");
        System.out.print("[-" + ((byte)1 << 7) + "; ");
        System.out.println(((1 << 7) - 1) + "]");
        System.out.println("short 16 bit");
        System.out.print("[-" + ((short)1 << 15) + "; ");
        System.out.println((((short)1 << 15) - 1) + "]");
        System.out.println("int 32 bit");
        System.out.print("[" + (1 << 31) + "; ");
        System.out.println(((1 << 31)-1) + "]");
        System.out.println("long 64 bit");
        System.out.print("[" + (1L << 63) + "; ");
        System.out.println(((1L << 63)-1) + "]");
        System.out.println(1 << 24);
        System.out.println(1 / 3f);
        System.out.printf("%.20f", 1 / 3.);
    }
}
