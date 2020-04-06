import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Algorithms {

    // Find the target difference
    public static class ResultForDiff {
        boolean finded;
        int i;
        int j;

        public ResultForDiff(boolean givenFinded, int givenI, int givenJ) {
            finded = givenFinded;
            i = givenI;
            j = givenJ;
        }
    }
    public static ResultForDiff findDifference(int diff, int[] array) {
        int length = array.length;
        if (length == 1) {
            return new ResultForDiff(false, -1, -1);
        }
        int i = 0;
        int j = 1;
        while ((i <= j) && (j < length)) {
            if ((array[j] - array[i]) == diff) {
                return new ResultForDiff(true, i, j);
            }
            else if ((array[j] - array[i]) > diff) {
                i++;
            }
            else {
                j++;
            }
        }
        return new ResultForDiff(false, -1, -1);
    }

    // QuickSort
    public static int randomizedPartition(int[] array, int low, int high) {
        Random rand = new Random();
        int r = low + rand.nextInt(high - low + 1);
        int temp = array[low];
        array[low] = array[r];
        array[r] = temp;
        int pivot = array[low];
        while (low < high) {
            while ((low < high) && (pivot <= array[high])) {
                high--;
            }
            array[low] = array[high];
            while ((low < high) && (pivot >= array[low])) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low]; //选第一个元素作为枢纽元
        while(low < high)
        {
            while(low < high && array[high] >= pivot) high--;
            array[low] = array[high]; //从后面开始找到第一个小于pivot的元素，放到low位置
            while(low < high && array[low] <= pivot) low++;
            array[high] = array[low]; //从前面开始找到第一个大于pivot的元素，放到high位置
        }
        array[low] = pivot; //最后枢纽元放到low的位置
        return low;
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int q = randomizedPartition(array, low, high);
            quickSort(array, low, q - 1);
            quickSort(array, q + 1, high);
        }
    } // O(nlogn)

    public static int quickSelect(int[] array, int low, int high, int target) {
        int pivot = partition(array, low, high);
        if (target == pivot - low + 1) return array[pivot];
        else if (target < pivot - low + 1) return quickSelect(array, low, pivot - 1, target);
        else return quickSelect(array, pivot + 1, high, target - (pivot - low + 1));
    }
    // MergeSort
    public static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    } // O(nlogn)
    public static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        ArrayList<Integer> helpArray = new ArrayList<>();
        while ((i <= mid) && (j <= high)) {
            if (array[i] <= array[j]) {
                helpArray.add(array[i]);
                i++;
            }
            else {
                helpArray.add(array[j]);
                j++;
            }
        }
        if (i > mid) {
            while (j <= high) {
                helpArray.add(array[j]);
                j++;
            }
        }
        else {
            while (i <= mid) {
                helpArray.add(array[i]);
                i++;
            }
        }
        int helpIndex = 0;
        for (int index = low; index <= high; index++) {
            array[index] = helpArray.get(helpIndex);
            helpIndex++;
        }

    }

    // Find Max Subarray
    public static class Result {
        int low;
        int high;
        int sum;

        Result(int givenLow, int givenHigh, int givenSum) {
            low = givenLow;
            high = givenHigh;
            sum = givenSum;
        }
    }
    public static Result findMaxArray(int[] array, int low, int high) {
        if (high == low) {
            return new Result(low, high, array[low]);
        }
        else {
            int mid = (low + high) / 2;
            Result leftResult = findMaxArray(array, low, mid);
            Result rightResult = findMaxArray(array, mid + 1, high);
            Result crossResult = findMaxCrossArray(array, low, mid, high);
            if ((leftResult.sum >= rightResult.sum) && (leftResult.sum >= crossResult.sum)) {
                return leftResult;
            }
            else if ((rightResult.sum >= leftResult.sum) && (rightResult.sum >= crossResult.sum)) {
                return rightResult;
            }
            else {
                return crossResult;
            }
        }
    } // O(nlogn)
    public static Result findMaxCrossArray(int[] array, int low, int mid, int high) {
        int leftSum = -999999;
        int rightSum = -999999;
        int sum = 0;
        int maxLeft = mid;
        int maxRight = mid;
        for (int i = mid; i >= low; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += array[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return new Result(maxLeft, maxRight, leftSum + rightSum);
    }

    // Count the change
    public static int countChange(int n, int[] coins, int m) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (m == 0) {
            return 0;
        }

        return countChange(n - coins[m - 1], coins, m) + countChange(n, coins, m -1);

    }

    public static void main(String[] args) {
        System.out.println((12 & 1) == 1);
    }
}
