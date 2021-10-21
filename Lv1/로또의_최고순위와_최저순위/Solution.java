import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = { 0, 0 };

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for (int num : lottos) {
            if (num == 0) {
                answer[0]++;
            } else {
                for (int winNum : win_nums) {
                    if (num == winNum) {
                        answer[0]++;
                        answer[1]++;
                    }
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            switch (answer[i]) {
                case 1:
                case 0:
                    answer[i] = 6;
                    break;

                default:
                    answer[i] = 7 - answer[i];
                    break;
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] lottos = { 44, 1, 0, 0, 31, 25 };
        int[] win_nums = { 31, 10, 45, 1, 6, 19 };
        System.out.println(Arrays.toString(test.solution(lottos, win_nums)));
    }
}
