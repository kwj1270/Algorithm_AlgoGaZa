import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static int T = 10;
    private static int n;

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= T; t++) {
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            n = Integer.parseInt(BUFFERED_READER.readLine().trim());

            int result = 1;
            for (int i = 0; i < n; i++) {
                String[] strArr = BUFFERED_READER.readLine().split(" ");
                int size = strArr.length;
                if (size == 4) {
                    if (strArr[1].equals("/") || strArr[1].equals("+") || strArr[1].equals("-") || strArr[1].equals("*")) {
                        continue;
                    }
                    result = 0;
                    continue;
                }
                if (size == 2) {
                    if (strArr[1].equals("/") || strArr[1].equals("+") || strArr[1].equals("-") || strArr[1].equals("*")) {
                        result = 0;
                        continue;
                    }
                    continue;
                }
            }
            STRING_BUILDER.append(result);
            System.out.println(STRING_BUILDER.toString());

        }
    }

}
