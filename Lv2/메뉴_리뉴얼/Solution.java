import java.util.*;

class Solution {
    HashMap<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {

        String[][] splitOrders = new String[orders.length][26];

        for (int i = 0; i < orders.length; i++) {
            splitOrders[i] = orders[i].split("");
        }

        map = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            boolean[] visited = new boolean[orders[i].length()];

            dfs(splitOrders[i], visited, "", course[course.length - 1], 0);
        }

        String answer = "";

        for (int i = 0; i < course.length; i++) {
            int max = 2;
            String str = "";

            for (String key : map.keySet()) {
                if (key.length() == course[i]) {
                    if (max < map.get(key)) {
                        str = key + " ";
                        max = map.get(key);
                    } else if (max == map.get(key)) {
                        str += key + " ";
                    }
                }
            }
            answer += str;
        }

        String[] arr = answer.split(" ");
        Arrays.sort(arr);

        return arr;
    }

    private void dfs(String[] orders, boolean[] visited, String str, int max, int index) {
        if (str.length() > 1) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            str = new String(arr);
            map.put(str, map.getOrDefault(str, 0) + 1);
            // System.out.println(str + map);

            if (str.length() == max) {
                return;
            }
        }

        for (int i = index; i < orders.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(orders, visited, str + orders[i], max, i);
            visited[i] = false;
        }
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        String[] orders2 = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
        String[] orders3 = { "XYZ", "XWY", "WXA" };

        int[] course = { 2, 3, 4 };
        int[] course2 = { 2, 3, 5 };
        int[] course3 = { 2, 3, 4 };

        System.out.println(Arrays.toString(test.solution(orders, course)));
        System.out.println(Arrays.toString(test.solution(orders2, course2)));
        System.out.println(Arrays.toString(test.solution(orders3, course3)));
    }
}
