import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int xLen = arr1.length;
        int yLen = arr1[0].length;

        int[][] answer = new int[xLen][yLen];

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] arr1 = { { 1 }, { 2 } };
        int[][] arr2 = { { 3 }, { 4 } };
        System.out.println(Arrays.deepToString(test.solution(arr1, arr2)));
    }
}
