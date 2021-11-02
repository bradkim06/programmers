import java.util.*;

class Solution {
    class Task {
        int start;
        int time;

        public Task(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Task> heap = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);

        int now = 0;
        int count = 0;
        int index = 0;
        int len = jobs.length;

        while (count < len) {
            while (index < len && jobs[index][0] <= now) {
                heap.add(new Task(jobs[index][0], jobs[index++][1]));
            }

            if (heap.isEmpty()) {
                now = jobs[index][0];
                continue;
            }

            Task task = heap.poll();
            now += task.time;
            answer += now - task.start;
            count++;
        }

        answer = (int) Math.floor(answer / jobs.length);

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 1, 6 } };

        System.out.println(test.solution(jobs));
    }
}
