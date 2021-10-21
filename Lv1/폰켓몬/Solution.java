import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int pocketMon : nums) {
            set.add(pocketMon);
        }

        answer = set.size();
        int max = nums.length / 2;

        if (set.size() > max) {
            answer = max;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] nums = { 3, 1, 2, 3 };
        System.out.println(test.solution(nums));
    }
}
