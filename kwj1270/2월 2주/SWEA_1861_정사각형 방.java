import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Answer {
    int startRoomNum;
    int count;

    public Answer(int startRoomNum, int count) {
        this.startRoomNum = startRoomNum;
        this.count = count;
    }
}

class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer STRING_TOKENIZER;
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static int n;
    private static int test;
    private static int[][] map;
    private static boolean[][] isPassed;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        test = Integer.parseInt(BUFFERED_READER.readLine().trim());
        for (int t = 1; t <= test; t++) {
            n = Integer.parseInt(BUFFERED_READER.readLine().trim());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                STRING_TOKENIZER = new StringTokenizer(BUFFERED_READER.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(STRING_TOKENIZER.nextToken());
                }
            }

            ArrayList<Answer> answers = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Answer temp = bfs(i, j);
                    if (max <= temp.count) {
                        answers.add(temp);
                        max = temp.count;
                    }
                }
            }
            answers.sort((o1, o2) -> {
                if (o1.count > o2.count) {
                    return -1;
                }
                if (o1.count == o2.count) {
                    if (o1.startRoomNum < o2.startRoomNum) {
                        return -1;
                    }
                }
                return 1;
            });


            System.out.println("#" + t + " " + answers.get(0).startRoomNum + " " + answers.get(0).count);
        }
    }

    public static Answer bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int result = 0;
        while (!q.isEmpty()) {
            result++;
            int now_x = q.peek()[0];
            int now_y = q.peek()[1];
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now_x + dx[i];
                int ny = now_y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[now_x][now_y] + 1 == map[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return new Answer(map[x][y], result);
    }

}
