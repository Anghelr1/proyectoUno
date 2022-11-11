import java.util.Arrays;

public class TestFunciones {
    static int test1 = 0;
    public static void main(String[] args) {

        test1 = 10;

        System.out.println(test1);
        test();
        System.out.println(test1);

        for (int i = 0; i < 12; i++) {
            System.out.println(i);
        }

    }

    public static void test(){
        test1 = 90;
    }
}
