class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftStatus = 10;
        int rightStatus = 12;

        for (int num : numbers) {
            switch (num) {
                case 1:
                case 4:
                case 7:
                    answer += "L";
                    leftStatus = num;
                    break;

                case 3:
                case 6:
                case 9:
                    answer += "R";
                    rightStatus = num;
                    break;

                case 2:
                case 5:
                case 8:
                case 0:
                    String search = calcLen(leftStatus, rightStatus, num);
                    if (search == "L") {
                        answer += "L";
                        leftStatus = num;
                    } else if (search == "R") {
                        answer += "R";
                        rightStatus = num;
                    } else if (search == "SAME") {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightStatus = num;
                        } else if (hand.equals("left")) {
                            answer += "L";
                            leftStatus = num;
                        }
                    }
                    break;
            }
        }
        return answer;
    }

    private String calcLen(int left, int right, int num) {
        if (left == 0) {
            left = 11;
        }

        if (right == 0) {
            right = 11;
        }

        if (num == 0) {
            num = 11;
        }

        int minusAbs = Math.abs(left - num);
        int leftLen = minusAbs / 3 + minusAbs % 3;
        minusAbs = Math.abs(right - num);
        int rightLen = minusAbs / 3 + minusAbs % 3;

        String retVal = "";

        if (rightLen < leftLen) {
            retVal = "R";
        } else if (rightLen > leftLen) {
            retVal = "L";
        } else {
            retVal = "SAME";
        }

        return retVal;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] testArr = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        System.out.println(test.solution(testArr, "right"));
    }
}
