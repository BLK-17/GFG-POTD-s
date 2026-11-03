
import java.util.*;

class Solution {

    int[] parent;
    long[] size;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    long union(int u, int v) {

        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return 0;

        long paths = size[rootU] * size[rootV];

        if (size[rootU] < size[rootV]) {
            int temp = rootU;
            rootU = rootV;
            rootV = temp;
        }

        parent[rootV] = rootU;
        size[rootU] += size[rootV];

        return paths;
    }

    public ArrayList<Integer> maximumWeight(
        int n, int[][] edges, int[] queries) {

        parent = new int[n + 1];
        size = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Arrays.sort(edges, (a, b) ->
            Integer.compare(a[2], b[2])
        );

        int q = queries.length;
        int[][] sortedQueries = new int[q][2];

        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        ArrayList<Integer> ans = new ArrayList<>(
            Collections.nCopies(q, 0)
        );

        long total = 0;
        int j = 0;

        for (int i = 0; i < q; i++) {

            int limit = sortedQueries[i][0];
            int idx = sortedQueries[i][1];

            while (j < edges.length &&
                   edges[j][2] <= limit) {

                total += union(
                    edges[j][0],
                    edges[j][1]
                );

                j++;
            }

            ans.set(idx, (int) total);
        }

        return ans;
    }
}
