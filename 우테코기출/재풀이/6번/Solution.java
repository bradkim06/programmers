import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public String[] solution(int totalTicket, String[] logs) {
        String[][] splitLogs = new String[logs.length][3];

        for (int i = 0; i < logs.length; i++) {
            splitLogs[i] = logs[i].split(" ");
        }

        ArrayList<String> list = new ArrayList<>();

        int cntTicket = 0;

        for (int i = 0; i < splitLogs.length; i++) {
            if (isTimeOver(splitLogs[i][2])) {
                break;
            }

            if (splitLogs[i][1].equals("request")) {
                list.add(splitLogs[i][0]);
                cntTicket++;

                int next = i + 1;

                while (next < splitLogs.length && !isOneMinute(splitLogs[i][2], splitLogs[next][2])) {
                    if (splitLogs[next][0].equals(splitLogs[i][0])) {
                        if (splitLogs[next][1].equals("leave")) {
                            list.remove(splitLogs[next][0]);
                            cntTicket--;
                        }
                    }

                    next++;
                }

                if (cntTicket >= totalTicket) {
                    break;
                }

                i = next - 1;
            }
        }

        Collections.sort(list);
        String[] answer = new String[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private boolean isTimeOver(String currTime) {
        String dateStart = "09:00:00";
        String dateStop = "10:00:00";

        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        Date dStart = null;
        Date dCurrent = null;
        Date dEnd = null;
        try {
            dStart = format.parse(dateStart);
            dCurrent = format.parse(currTime);
            dEnd = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Get msec from each, and subtract.
        long diffStart = dCurrent.getTime() - dStart.getTime();
        long diffEnd = dEnd.getTime() - dCurrent.getTime();

        if (diffStart < 0) {
            return true;
        } else if (diffEnd < 0) {
            return true;
        }

        return false;
    }

    private boolean isOneMinute(String before, String after) {
        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(before);
            d2 = format.parse(after);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000;

        if (diffSeconds > 60) {
            return true;
        }

        return false;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] logs = { "woni request 09:12:29", "brown request 09:23:11", "brown leave 09:23:44",
                "jason request 09:33:51", "jun request 09:33:56", "cu request 09:34:02" };

        System.out.println(Arrays.toString(test.solution(2000, logs)));
    }
}
