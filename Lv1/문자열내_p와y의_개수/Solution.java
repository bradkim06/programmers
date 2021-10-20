class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int countP = 0;
        int countY = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'y' || ch == 'Y') {
                countY++;
            } else if (ch == 'p' || ch == 'P') {
                countP++;
            }
        }

        if (countY != countP) {
            answer = false;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("Pyy"));
    }
}
