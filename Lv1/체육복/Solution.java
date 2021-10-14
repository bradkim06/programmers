import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n];
        Arrays.fill(clothes, 1);

        for (int i : reserve) {
            clothes[i - 1]++;
        }

        for (int i : lost) {
            clothes[i - 1]--;
        }

        for (int i = 0; i < clothes.length; i++) {

            if (clothes[i] < 1) {
                if ((i != 0) && (clothes[i - 1] > 1)) {
                    clothes[i - 1]--;
                    clothes[i]++;
                } else if ((i < clothes.length - 1) && (clothes[i + 1] > 1)) {
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }

        int answer = 0;

        for (int i : clothes) {
            if (i > 0) {
                answer++;
            }
        }

        return answer;

    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] lost = { 2, 4 };
        int[] reserve = { 1, 3, 5 };

        System.out.println(test.solution(5, lost, reserve));
    }
}
