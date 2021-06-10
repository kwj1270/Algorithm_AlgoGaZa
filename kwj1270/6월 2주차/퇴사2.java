import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int dp[] = new int[1_500_002];
    private static int daies[] = new int[1_500_002];
    private static int moneis[] = new int[1_500_002];

    // 반복 1회로 끝내야한다.
    private static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(READER.readLine().trim());

        for(int i=1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(READER.readLine(), " ");
            daies[i] = Integer.parseInt(stringTokenizer.nextToken());
            moneis[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int answer = 0;
        for (int i=1; i <= n+1; i++) {
            answer = Math.max(answer, dp[i]);
            if(i+daies[i] > n+1) continue;
            dp[i+daies[i]] = Math.max(dp[i+daies[i]], answer + moneis[i]);
        }
        System.out.println(answer);
    }
}
