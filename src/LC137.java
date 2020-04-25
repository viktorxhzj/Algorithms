
public class LC137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for (int num: nums) {
                num >>= i;
                sum += num & 1;
            }
            // 点金之笔
            res |= (sum % 3) << i;
        }
        return res;
    }
}