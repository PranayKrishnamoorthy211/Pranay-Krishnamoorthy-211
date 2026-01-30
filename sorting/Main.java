package sorting;

public class Main {
    public static void main(String[] args)
    {

        int[] testInput = randomArray(5);

        TestSuite.run(testInput, 1);
    }

    public static int[] randomArray(int length)
    {
        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            int b = (int) Math.random() * 101;
            a[i] = b;
        }
        return a;
    }

}
