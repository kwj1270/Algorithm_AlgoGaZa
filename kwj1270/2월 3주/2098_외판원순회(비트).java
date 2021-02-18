import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static int n;
    private static int[][] map;
    private static int[][] dp;
    private static int answerBit;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(BUFFERED_READER.readLine().trim());
        map = new int[n][n];
        dp = new int[n][(1 << n)-1]; // 비트;
        answerBit = (1 << n)-1;
        for (int [] d : dp){
            Arrays.fill(d, -1);
        }

        for(int i=0; i < n; i++){
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            for(int j=0; j < n; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        System.out.println(go(0,1));
    }

    private static int go(int now, int flag) {
        if(flag == answerBit) {
            if(map[now][0] == 0) return 1_000_000_000;
            return map[now][0];
        }

        if(dp[now][flag] != -1) return dp[now][flag];
        dp[now][flag] = 1_000_000_000;
        for(int i=0; i  < n; i++){
            if(map[now][i] == 0) continue;
            if((flag & 1 << i) != 0) continue;
            dp[now][flag] = Math.min(dp[now][flag], map[now][i]+go(i, (flag | 1 << i)));
        }
        return dp[now][flag];
    }
}
