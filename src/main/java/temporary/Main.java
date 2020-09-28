package temporary;

import java.util.function.Function;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        out.println("Hello");
        out.println(abs(-10));

        out.println(Test.sqrt(Test.fun, 10));
    }

    static int abs(int a) {
        if (a<0) return -a;
        else return a;
    }
}

class Test {
    public Test() {
        out.println("Konstruktor");
    }

    public static Function<Integer, Integer> fun = x -> { return x*x;};

    public static Integer sqrt(Function<Integer, Integer> f, Integer x) {
        return f.apply(x);
    }

}
