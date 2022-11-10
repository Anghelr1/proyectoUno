import java.util.Arrays;

public class TestFunciones {
    public static void main(String[] args) {

        int[] values = {1,1,1,1,1,1};
        int[] values1 = {2,2,2,2,2,2};
        int[] values2 = {3,3,3,3,3,3};
        int[] values3 = {4,4,4,4,4,4};
        int target = 1;




        boolean found = Arrays.stream(values).anyMatch(i -> i == target);

        int arreglos = values.length + values1.length + values2.length + values3.length;
        int[] baraja = new int[arreglos];


        for (int i = 0; i < arreglos; i++) {
            while (i <= values.length) {
                baraja[i] = values[i];
            }
            while (i <= values1.length) {
                baraja[i] = values1[i];
            }
            while (i <= values2.length) {
                baraja[i] = values2[i];
            }
            while (i <= values3.length) {
                baraja[i] = values3[i];
            }
        }

        for (int i = 0; i < baraja.length; i++) {
            System.out.println(baraja[i]);
        }





    }
}
