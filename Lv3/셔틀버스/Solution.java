import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int time = 9 * 60;
        int answer = time;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < timetable.length; i++) {
            String[] str = timetable[i].split(":");

            for (int j = 0; j < str.length - 1; j += 2) {
                int h = Integer.parseInt(str[j]);
                int min = Integer.parseInt(str[j + 1]);

                pq.add(h * 60 + min);
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt = 0;

            while (!pq.isEmpty()) {
                int next = pq.peek();

                if (next <= time && cnt < m) {
                    pq.poll();
                    cnt++;
                } else {
                    break;
                }

                answer = next - 1;
            }

            time += t;
        }

        if (cnt < m) {
            answer = time - t;
        }

        return String.format("%02d", answer / 60) + ":" + String.format("%02d", answer % 60);
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] timetable = { "08:00", "08:01", "08:02", "08:03" };
        // String[] timetable = { "09:10", "09:09", "08:00" };
        // String[] timetable = { "23:59" };
        // String[] timetable = { "00:01", "00:01", "00:01", "00:01", "00:01" };
        // String[] timetable = { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
        // "23:59", "23:59", "23:59", "23:59",
        // "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" };

        System.out.println(test.solution(1, 1, 5, timetable));
    }
}
