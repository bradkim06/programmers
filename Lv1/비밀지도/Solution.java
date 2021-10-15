import java.util.Arrays;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = "";
            int block = (arr1[i] | arr2[i]);

            for (int j = n - 1; j >= 0; j--) {
                int search = 1 << j;

                if ((block & search) != 0) {
                    temp += "#";
                } else {
                    temp += " ";
                }

            }

            answer[i] = temp;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] arr1 = { 9, 20, 28, 18, 11 };
        int[] arr2 = { 30, 1, 21, 17, 28 };

        System.out.println(Arrays.toString(test.solution(5, arr1, arr2)));
    }
}
