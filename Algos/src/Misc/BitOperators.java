package Misc;

public class BitOperators {
    public static void main(String[] args) {
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);
        
        //x << y means x shifted y bits to the left
        int n = 4;
        System.out.println(n << 2);
        
        int a = Integer.parseInt("100", 2);
        System.out.println("a: " + a);
     
     //   int num = 0b100;
    }
}
