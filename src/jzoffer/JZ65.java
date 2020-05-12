package jzoffer;

public class JZ65 {
    public int add(int a, int b) {
        int s, c;
        while (b != 0) {
            s = a ^ b;
            c = (a & b) << 1;
            a = s;
            b = c;
        }
        return a;
    }
}
