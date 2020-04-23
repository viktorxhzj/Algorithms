public class LC96 {
    public int numTrees(int n) {

        // G[n] n个节点组成的二叉搜索树的数量
        // G[n] = f[1][n] + ... + f[n][n]

        // f[i][n] 以i节点为根节点的n个节点组成的二叉搜索树的数量
        // f[i][n] = G[i - 1] * G[n - i]

        // G[n] = G[0] * G[n - 1] + G[1] * G[n - 2] + ... + G[n - 1] * G[0]

        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j <= i - 1; j++) {
                G[i] += G[j] * G[i - 1 - j];
            }
        }
        return G[n]; 
    }
}