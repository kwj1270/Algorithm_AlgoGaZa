	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
import static java.lang.Integer.valueOf;
 
public class Solution {
 
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;
 
    private static int[] DX = {0, 0, -1, 1};
    private static int[] DY = {1, -1, 0, 0};
 
    private static int[][] map;
    private static boolean[][] pass;
 
    private static int test;
    private static int n;
    private static int k;
 
    private static int answer;
 
    public static void main(String[] args) throws IOException {
        test = valueOf(BUFFERED_READER.readLine().trim());
        for (int t = 1; t <= test; t++) {
            stringBuilder.setLength(0);
            stringBuilder.append("#").append(t).append(" ");
 
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            n = valueOf(stringTokenizer.nextToken());
            k = valueOf(stringTokenizer.nextToken());
 
            map = new int[n][n];
            pass = new boolean[n][n];
 
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = valueOf(stringTokenizer.nextToken());
                    if (map[i][j] > max) max = map[i][j];
                }
            }
 
            answer = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == max) {
                        pass[i][j] = true;
                        answer = Math.max(answer, dfs(0, map[i][j], i, j, 1));
                        pass[i][j] = false;
                    }
                }
            }
            stringBuilder.append(answer);
            System.out.println(stringBuilder);
        }
 
    }
 
    private static int dfs(int state, int now, int x, int y, int length) {
        int result = length;
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (pass[nx][ny]) continue;
 
            if (map[nx][ny] < now) {
                pass[nx][ny] = true;
                result = Math.max(result, dfs(state, map[nx][ny], nx, ny, length + 1));
                pass[nx][ny] = false;
            }
            if(now <= map[nx][ny]) {
                if (map[nx][ny] - k < now && state == 0) {
                    pass[nx][ny] = true;
                    result = Math.max(result, dfs(result + 1, now - 1, nx, ny, length + 1));
                    pass[nx][ny] = false;
                }
            }
        }
        return result;
    }
}
