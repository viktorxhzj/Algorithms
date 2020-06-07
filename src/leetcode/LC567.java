package leetcode;

public class LC567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int[] need = new int[26];
        for (char c: str1) need[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (need[i] == 0) need[i] = -1;
        }

        int i = 0, j = 0, count = 0;
        while (j < str2.length) {
            if (need[str2[j] - 'a'] == -1) {
                while (i < j) {
                    need[str2[i] - 'a']++;
                    i++;
                }
                count = 0;
                i++;
                j++;
                continue;
            }
            if (need[str2[j] - 'a'] == 0) {
                while (need[str2[j] - 'a'] == 0) {
                    need[str2[i] - 'a']++;
                    count--;
                    i++;
                }
                continue;
            }

            if (need[str2[j] - 'a'] > 0) {
                need[str2[j] - 'a']--;
                count++;
                if (count == str1.length) return true;
                j++;
            }
        }

        return false;

    }
}
