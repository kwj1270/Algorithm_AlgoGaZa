import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

// 경현님의 코드를 보면서 다시 풀었습니다.
class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static int n;
    private static int answer = 0;
    private static int[][] map = new int[100][100];

    public static void main(String[] args) throws IOException {
        STRING_BUILDER.setLength(0);
        n = Integer.parseInt(BUFFERED_READER.readLine().trim());
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    map[j][k]++;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] >= 1) answer++;
            }
        }

        System.out.println(answer);
    }


}
