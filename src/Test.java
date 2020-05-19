import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
    }
}

class A {
    public static void methodA() {}
}

interface B {
    public static void methodB() {}
}

class C extends A implements B {
    public static void methodC() {
        methodA();
        B.methodB();
    }
}
