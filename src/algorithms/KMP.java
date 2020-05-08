package algorithms;

public class KMP {

    public int[] produceNext(char[] arr) {
        int[] next = new int[arr.length];
        int i = 0, j = 1;

        while (j < arr.length) {
            if (arr[j] == arr[i]) next[j++] = ++i;
            else {
                while (i > 0) {
                    i = next[i - 1];
                    if (arr[i] == arr[j]) {
                        next[j] = ++i;
                        break;
                    }
                }
                j++;
            }
        }
        return next;
    }

    public int kmpSearch(int[] next, char[] str, char[] pattern) {
        int p1 = 0, p2 = 0;
        while (p1 < str.length) {
            if (str[p1] == pattern[p2]) {
                p1++;
                p2++;
            }
            else if (p2 != 0) p2 = next[p2 - 1];
            else p1++;

            if (p2 == pattern.length) return p1 - p2;
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String str = "agctagcagctagctg";
        System.out.println(kmp.kmpSearch(kmp.produceNext(str.toCharArray()), str.toCharArray(), "tagct".toCharArray()));
    }
}
