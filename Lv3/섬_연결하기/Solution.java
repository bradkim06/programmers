import java.util.*;

class Solution {
    int[] island;

    public int solution(int n, int[][] costs) {
        int sum = 0;
        island = makeSet(n);

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < costs.length; i++) {
            int node1 = costs[i][0];
            int node2 = costs[i][1];

            if (find(node1) != find(node2)) {
                unite(island, node1, node2);
                sum += costs[i][2];
            }
        }

        return sum;
    }

    private int[] makeSet(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        return arr;
    }

    private int find(int x) {
        if (island[x] == x)
            return x;
        return island[x] = find(island[x]);
    }

    private void unite(int[] island, int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a > b) {
            island[a] = b;
        } else {
            island[b] = a;
        }
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] costs = { { 0, 1, 1 }, { 3, 1, 1 }, { 0, 2, 2 }, { 0, 3, 2 }, { 0, 4, 100 } };

        System.out.println(test.solution(5, costs));
    }
}
