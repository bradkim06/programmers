class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int index = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            switch (ch) {
                case 'D':
                    score[index] *= score[index];
                    break;
                case 'T':
                    score[index] *= score[index] * score[index];
                    break;
                case '*':
                    score[index] *= 2;
                    if (index > 0) {
                        score[index - 1] *= 2;
                    }
                    break;
                case '#':
                    score[index] *= -1;
                    break;

                case 'S':
                    break;

                default:
                    index++;

                    if (ch == '1' && dartResult.charAt(i + 1) == '0') {
                        score[index] = 10;
                        i++;
                    } else {
                        score[index] = ch - '0';
                    }
                    break;
            }
        }

        int answer = 0;

        for (int i : score) {
            answer += i;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("1D2S#10S"));
    }
}
