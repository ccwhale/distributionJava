package algorithm.linkedlist.sort;

/**
 * @author cc
 * @Date 2019-06-12 08:11:11 Wednesday
 */
public class QuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, startIndex + 1, endIndex);
    }

    // 双边循环法
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            // 右边的元素小于中轴,停止
            while (left < right && arr[right] > pivot) {
                right--;
            }
            // 左边的元素大于中轴,停止
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    // 单边循环法
    // 一次循环后,比中轴大的在左边,比中轴小的在右边
    private static int partitionV2(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }


}
