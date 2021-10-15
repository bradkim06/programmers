class Solution {
    static final int NUM_ALPHABET = 26;

    public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char fixed = (char) (c + n);

            if (c >= 'a') {
                if (fixed > 'z') {
                    fixed -= NUM_ALPHABET;
                }
            } else if (c >= 'A') {
                if (fixed > 'Z') {
                    fixed -= NUM_ALPHABET;
                }
            } else {
                answer += c;
                continue;
            }

            answer += fixed;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("AB", 1));
    }
}
