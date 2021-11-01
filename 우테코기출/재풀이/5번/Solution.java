class Solution {
    public int solution(int number) {
        int answer = 0;

        for (int i = 3; i <= number; i++) {
            String num = String.valueOf(i);

            for (int j = 0; j < num.length(); j++) {
                char ch = num.charAt(j);

                switch (ch) {
                    case '3':
                    case '6':
                    case '9':
                        answer++;
                        break;
                }
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(13));
        System.out.println(test.solution(33));
    }
}
