class Solution {
    final String[] friends = { "A", "C", "F", "J", "M", "N", "R", "T" };
    int answer;

    public int solution(int n, String[] data) {
        answer = 0;
        boolean[] visited = new boolean[friends.length];

        dfs(data, "", visited);

        return answer;
    }

    private void dfs(String[] data, String str, boolean[] visited) {
        if (str.length() == friends.length) {
            if (checkData(str, data)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(data, str + friends[i], visited);
            visited[i] = false;
        }
    }

    private boolean checkData(String str, String[] datas) {
        for (String data : datas) {
            int diff = Math.abs(str.indexOf(data.charAt(0)) - str.indexOf(data.charAt(2))) - 1;
            char op = data.charAt(3);
            int index = Character.getNumericValue(data.charAt(4));

            if (op == '=') {
                if (diff != index) {
                    return false;
                }
            } else if (op == '>') {
                if (diff <= index) {
                    return false;
                }
            } else if (op == '<') {
                if (diff >= index) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] data = { "N~F=0", "R~T>2" };

        System.out.println(test.solution(2, data));
    }
}
