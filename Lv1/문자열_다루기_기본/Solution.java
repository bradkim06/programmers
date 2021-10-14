class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        int strLen = s.length();

        if (strLen != 4 && strLen != 6) {
            return false;
        }

        for (int i = 0; i < strLen; i++) {
            if (Character.isDigit(s.charAt(i)) == false) {
                return false;
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("1a34"));
    }
}
