import java.util.*;

class Others {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });

        int[] answer = new int[arr.length];
        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2))
                    answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

    public static void main(String... args) {
        Others test = new Others();

        System.out.println(Arrays.toString(test.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
