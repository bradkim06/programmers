class Solution {
    final static int V = 0;
    final static int H = 1;

    public int solution(int[][] sizes) {
        int answer = 0;
        int maxV = 0;
        int maxH = 0;

        for (int i = 0; i < sizes.length; i++) {
            int v = Math.max(sizes[i][V], sizes[i][H]);
            int h = Math.min(sizes[i][V], sizes[i][H]);
            maxV = Math.max(maxV, v);
            maxH = Math.max(maxH, h);
        }

        answer = maxV * maxH;

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] testArr = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
        System.out.println(test.solution(testArr));
    }
}
