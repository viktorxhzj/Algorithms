package leetcode;

public class LC744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target < letters[0] || target >= letters[letters.length - 1]) return letters[0];
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (letters[mid] == target) left = mid + 1;
            else if (letters[mid] < target) left = mid + 1;
            else if (letters[mid] > target) right = mid;
        }
        return letters[left] == target? letters[++left]: letters[left];
    }
}
