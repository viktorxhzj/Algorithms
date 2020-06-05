package leetcode;

public class LC744 {
    public char nextGreatestLetter(char[] arr, char T) {
        int L = 0, R = arr.length;

        while (L < R) {
            int M = (L + R) >> 1;
            if (arr[M] == T) L = M + 1;
            if (arr[M] < T) L = M + 1;
            if (arr[M] > T) R = M;
        }

        return L == arr.length? arr[0]: arr[L];
    }
}
