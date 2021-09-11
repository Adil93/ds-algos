package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReORderLogFile {
    public String[] reorderLogFiles(String[] logs) {

        if (logs == null || logs.length == 0) {
            return new String[0];
        }

        List<String> digits = new ArrayList<String>();
        List<String> alphas = new ArrayList<String>();
        for (String log : logs) {
            String[] logArr = log.split(" ");
            if (isDigit(logArr[1]))
                digits.add(log);
            else
                alphas.add(log);
        }

        Collections.sort(alphas, (log1, log2) -> {
            String[] log1Arr = log1.split(" ", 2);
            String[] log2Arr = log2.split(" ", 2);

            if (log1Arr[1].equals(log2Arr[1])) {
                return log1Arr[0].compareTo(log2Arr[0]);
            }

            return log1Arr[1].compareTo(log2Arr[1]);

        });

        alphas.addAll(digits);
        return alphas.toArray(new String[0]);
    }

    private static boolean isDigit(String s) {
        return s.matches("[0-9]+");
    }
}
