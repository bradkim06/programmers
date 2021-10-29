import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    String[] answer;
    boolean[] visited;
    ArrayList<String> list;
    static final String startAirport = "ICN";

    public String[] solution(String[][] tickets) {
        int len = tickets.length;
        visited = new boolean[len];
        list = new ArrayList<>();

        dfs(tickets, startAirport, startAirport, 0);
        Collections.sort(list);

        answer = list.get(0).split(" ");

        return answer;
    }

    private void dfs(String[][] tickets, String airport, String path, int count) {
        if (tickets.length == count) {
            list.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (tickets[i][0].equals(airport)) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], path + " " + tickets[i][1], count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
                { "ATL", "SFO" } };
        System.out.println(Arrays.toString(test.solution(tickets)));
    }
}
