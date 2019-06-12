package algorithm.linkedlist.sort;

import java.util.Arrays;

/**
 * @author cc
 * @Date 2019-06-05 02:11:11 Wednesday
 */
public class BubbleSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            int sortBorder = array.length - 1;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                    sortBorder = j;
                    System.out.println("border:"+sortBorder);
                }
            }
            System.out.println("i:"+i);
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
