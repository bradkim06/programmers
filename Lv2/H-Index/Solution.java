import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (h <= citations[i]) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] citations = { 3, 0, 6, 1, 5 };
        System.out.println(test.solution(citations));
    }
}
