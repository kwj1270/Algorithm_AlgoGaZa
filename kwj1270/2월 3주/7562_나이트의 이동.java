import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Person {
    int x;
    int y;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static int[] dx = {1, 1, 2, 2, -2, -2, -1, -1};
    private static int[] dy = {2, -2, 1, -1, 1, -1, 2, -2};

    private static int[][] dp;
    private static int test;

    private static int n;
    private static int start_x;
    private static int start_y;

    private static int end_x;
    private static int end_y;

    private static Queue<Person> q;

    public static void main(String[] args) throws IOException {
        test = Integer.parseInt(BUFFERED_READER.readLine().trim());
        for (int t = 0; t < test; t++) {
            n = Integer.parseInt(BUFFERED_READER.readLine().trim());
            dp = new int[n][n];
            for(int i=0; i < n; i++){
                for(int j=0; j < n; j++){
                    dp[i][j] = -1;
                }
            }
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            start_x = Integer.parseInt(stringTokenizer.nextToken());
            start_y = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            end_x = Integer.parseInt(stringTokenizer.nextToken());
            end_y = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(bfs(start_x, start_y, 0));
        }

    }

    public static int bfs(int i, int j, int sum) {
        dp[i][j] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});

        while (!q.isEmpty()) {
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = now_x + dx[k];
                int ny = now_y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (dp[nx][ny] == -1 || dp[nx][ny] > dp[now_x][now_y]+1) {
                    dp[nx][ny] = dp[now_x][now_y]+1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return dp[end_x][end_y];
    }
}
