class Solution {
    public int solution(int[] pobi, int[] crong) {
        int answer = 0;

        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        int pobiMax = findMax(pobi);
        int crongMax = findMax(crong);

        if (pobiMax == crongMax) {
            answer = 0;
        } else if (pobiMax > crongMax) {
            answer = 1;
        } else if (crongMax > pobiMax) {
            answer = 2;
        }

        return answer;
    }

    private boolean isException(int[] person) {
        if (person[0] != person[1] - 1) {
            return true;
        }

        if (person[0] == 1) {
            return true;
        }

        if (person[1] == 400) {
            return true;
        }

        return false;
    }

    private int findMax(int[] person) {
        return Math.max(findBig(person[0]), findBig(person[1]));
    }

    private int findBig(int number) {
        int sum = 0;
        int mul = 1;

        while (number != 0) {
            int num = number % 10;

            sum += num;
            mul *= num;

            number /= 10;
        }

        return Math.max(sum, mul);
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] pobi = { 97, 98 };
        int[] crong = { 197, 198 };

        System.out.println(test.solution(pobi, crong));

        int[] pobi2 = { 131, 132 };
        int[] crong2 = { 211, 212 };

        System.out.println(test.solution(pobi2, crong2));

        int[] pobi3 = { 99, 102 };
        int[] crong3 = { 211, 212 };

        System.out.println(test.solution(pobi3, crong3));
    }
}
