
class Solution {
    public int largestSumCycle(int edge[]) {

        int N = edge.length;

        boolean[] visited = new boolean[N];
        int[] position = new int[N];

        java.util.Arrays.fill(position, -1);

        long ans = -1;

        for (int i = 0; i < N; i++) {

            if (visited[i]) {
                continue;
            }

            int curr = i;
            int step = 0;

            while (curr != -1 && !visited[curr]) {
                visited[curr] = true;
                position[curr] = step++;

                curr = edge[curr];
            }

            if (curr != -1 && position[curr] != -1) {

                long sum = 0;
                int node = curr;

                do {
                    sum += node;
                    node = edge[node];
                } while (node != curr);

                ans = Math.max(ans, sum);
            }

            curr = i;

            while (curr != -1 && position[curr] != -1) {
                int next = edge[curr];
                position[curr] = -1;
                curr = next;
            }
        }

        return (int) ans;
    }
}
