class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(computers, i, visited);
                answer++;
            }
        }

        return answer;
    }

    boolean[] dfs(int[][] computers, int index, boolean[] visited) {
        visited[index] = true;

        for (int i = 0; i < computers.length; i++) {
            if (i == index || computers[index][i] == 0) {
                continue;
            }

            if (visited[i] == false) {
                visited = dfs(computers, i, visited);
            }

        }
        return visited;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(test.solution(3, computers));
    }
}
