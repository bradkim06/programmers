import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    static final int NAME = 0;
    static final int TYPE = 1;
    static final int TIME = 2;

    public String[] solution(int totalTicket, String[] logs) {
        String[] answer;
        String[][] splitLogs = new String[logs.length][3];

        for (int i = 0; i < logs.length; i++) {
            splitLogs[i] = logs[i].split(" ");
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            if (splitLogs[i][TYPE].equals("request")) {
                list.add(splitLogs[i][NAME]);
                int index = i - 1;

                for (int j = index; j >= 0; j--) {
                    if (splitLogs[j][TYPE].equals("request")) {
                        if (calcDiffTime(splitLogs[i][TIME], splitLogs[j][TIME])) {
                            list.remove(splitLogs[i][NAME]);
                            break;
                        }
                    }
                }
            } else if (splitLogs[i][TYPE].equals("leave")) {
                list.remove(splitLogs[i][NAME]);
            }

            if (list.size() == totalTicket) {
                break;
            }
        }

        Collections.sort(list);

        answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private boolean calcDiffTime(String dateStart, String dateStop) {
        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = Math.abs(diff / 1000);

        if (diffSeconds >= 60) {
            return false;
        }

        return true;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] logs = { "woni request 09:12:29", "brown request 09:23:11", "brown leave 09:23:44",
                "jason request 09:33:51", "jun request 09:33:56", "cu request 09:34:02" };
        System.out.println(Arrays.toString(test.solution(2000, logs)));
    }
}
