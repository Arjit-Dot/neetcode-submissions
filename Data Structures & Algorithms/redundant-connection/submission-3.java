class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] size = new int[n + 1];
        int[] parents = new int[n + 1];
        
        Arrays.fill(size, 1);
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            // 1. Always resolve both nodes to their true set roots first
            int root1 = find(parents, edge[0]);
            int root2 = find(parents, edge[1]);

            // 2. If they already share the same root, this edge creates the cycle
            if (root1 == root2) {
                return edge;
            }

            // 3. Union by Size: attach the smaller root under the larger root
            if (size[root1] >= size[root2]) {
                parents[root2] = root1;
                size[root1] += size[root2];
            } else {
                parents[root1] = root2;
                size[root2] += size[root1];
            }
        }

        return new int[0];
    }

    // Path Compression (standardly named 'find')
    private int find(int[] parents, int node) {
        if (parents[node] == node) return node;
        return parents[node] = find(parents, parents[node]);
    }
}