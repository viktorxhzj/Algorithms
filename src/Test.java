import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    static String s = "林";
    static {
        String s = "丽";
        System.out.println(s);
    }
    public static void main(String[] args) {
        new Son(s);
    }
}

class Father {
    static int m = 100;
    public Father() {
        m = 999;
    }
    static {
        m = 10000;
        System.out.println("父类" + m);
    }
}

class Son extends Father {
    int m;
    {
        super.m = 5;
    }
    static {
        System.out.println("static block");
    }
    public Son(String name) {
        System.out.println(name);
        System.out.println(m);
        System.out.println(super.m);
    }
}