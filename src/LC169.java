
public class LC169 {
    public int majorityElement(int[] nums) {
        // 1. 如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
        // 2. 如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
        int majority = nums[0], vote = 0;
        for (int num: nums) {
            if (vote == 0) majority = num;
            if (num == majority) vote++;
            else vote--;
        }
        return majority;
    }
}