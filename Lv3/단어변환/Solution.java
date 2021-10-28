class Solution {
    static boolean[] visited;
    static int answer = 0;

    public int solution(String begin, String target, String[] words) {
        answer = words.length + 1;
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        if (answer == words.length + 1) {
            return 0;
        }

        return answer;
    }

    private static void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            if (count < answer) {
                answer = count;
            }
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            int diff = 0;

            for (int j = 0; j < target.length(); j++) {
                char ch = words[i].charAt(j);

                if (begin.charAt(j) != ch) {
                    diff++;
                }
            }

            if (diff == 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        System.out.println(test.solution("hit", "cog", words));
    }
}
