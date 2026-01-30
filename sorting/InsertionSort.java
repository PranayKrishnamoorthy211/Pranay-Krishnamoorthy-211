package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        int n = input.length;
        for (int i = 1; i < n; i++){
            int key = input[i];
            int j = i - 1;

            while (j >=0 && input[i] > key) {
                input[j + 1] = input[j];
                j = j + 1
            }
            input[j + 1] = key;
        }
    }
}
