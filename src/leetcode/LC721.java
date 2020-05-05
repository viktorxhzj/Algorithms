package leetcode;

import java.util.*;

public class LC721 {
    public static int[] f  = new int[1010];
    public static void changeFather(int a, int b){
        int af = find(a);
        int bf = find(b);
        if(af == bf) return;
        f[bf] = af;

    }
    public static int find(int x) {
        while(x!=f[x]){
            x = f[x];
        }
        return x;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();

        // 每个名字一个ID，之后如果发现这两是一个人，那就合并ID
        for (int i = 0; i < 1010; i++) {
            f[i]=i;
        }

        HashMap<String ,Integer> m = new HashMap<>();


        for (int i = 0; i <len; i++) {

            List<String> list = accounts.get(i);

            // 对每一条信息里的邮箱进行遍历
            for (int j = 1; j < accounts.get(i).size(); j++) {

                // 如果存在当前邮箱
                if (m.containsKey(list.get(j))) {

                    // 就把当前邮箱对应的ID和Map里这个邮箱对应的ID合并
                    changeFather(m.get(list.get(j)),i);
                }
                // 不存在当前邮箱，就给当前邮箱当前对应的ID
                else{
                    m.put(list.get(j),f[i]);
                }
            }
        }
        //再循环一遍，更新所有邮箱对应的最终父级ID
        for(Map.Entry<String ,Integer> s:m.entrySet()){
            s.setValue(find(s.getValue()));
        }
        // ID和对应的邮箱列表
        Map<Integer,List<String>> mm = new HashMap<>();

        for (Map.Entry<String, Integer> e:m.entrySet()) {
            if(!mm.containsKey(e.getValue())){
                List<String> lll = new ArrayList<>();
                //把他父级的对应的名称拿过来
                lll.add(accounts.get(e.getValue()).get(0));
                mm.put(e.getValue(),lll);
            }
            //如果有名字了，直接添加
            mm.get(e.getValue()).add(e.getKey());
        }
        //把最后的结果加起来
        List<List<String>> ans = new LinkedList<>();
        for (Map.Entry<Integer,List<String>> e:mm.entrySet()) {
            List<String> lt = e.getValue();
            Collections.sort(lt);
            ans.add(lt);
        }
        return ans;
    }
}