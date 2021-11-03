class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 0; i < land.length - 1; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int max = 0;

                for (int k = 0; k < land[0].length; k++) {
                    if (k == j) {
                        continue;
                    }

                    max = Math.max(max, land[i][k]);
                }

                land[i + 1][j] += max;
            }
        }

        for (int num : land[land.length - 1]) {
            answer = Math.max(answer, num);
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        System.out.println(test.solution(land));

        int[][] land2 = { { 9, 5, 2, 3 }, { 9, 8, 6, 7 }, { 8, 9, 7, 1 }, { 100, 9, 8, 1 } }; // 125
        System.out.println(test.solution(land2));
    }
}
