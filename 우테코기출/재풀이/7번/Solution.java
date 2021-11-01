class Solution {
    public String solution(String cryptogram) {
        String answer = "";
        boolean changed = true;

        StringBuilder str = new StringBuilder(cryptogram);

        while (changed) {
            changed = false;

            for (int i = 0; i < str.length(); i++) {
                int next = i + 1;

                if (next < str.length() && str.charAt(i) == str.charAt(next)) {
                    str.deleteCharAt(next);
                    str.deleteCharAt(i);
                    changed = true;
                }
            }

        }

        answer = str.toString();

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("browoanoommnaon"));
        System.out.println(test.solution("zyelleyz"));
    }
}
