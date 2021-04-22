	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
import static java.lang.Integer.valueOf;
 
 
public class Solution {
 
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
 
    private static char[][] map;
    private static char[][] origin;
 
    private static int test;
    private static int d;
    private static int w;
    private static int k;
 
    private static int answer;
 
    public static void main(String[] args) throws IOException {
        test = valueOf(BUFFERED_READER.readLine().trim());
 
        for (int t = 1; t <= test; t++) {
            STRING_BUILDER.append("#").append(t).append(" ");
 
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
 
            d = valueOf(stringTokenizer.nextToken());
            w = valueOf(stringTokenizer.nextToken());
            k = valueOf(stringTokenizer.nextToken());
 
            map = new char[d][w];
            origin = new char[d][w];
 
            for (int i = 0; i < d; i++) {
                stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = stringTokenizer.nextToken().charAt(0);
                    origin[i][j] = map[i][j];
                }
            }
 
            answer = Integer.MAX_VALUE;
            if(check()) {
                STRING_BUILDER.append(0).append("\n");
                continue;
            }
            recursive(0, 0);
            STRING_BUILDER.append(answer).append("\n");
        }
        System.out.println(STRING_BUILDER);
    }
 
    private static void recursive(int index, int count) {
        if (answer <= count) return;
        if (index == d) return;
        if (check()) {
            answer = answer > count ? count : answer;
            return;
        }
 
        recursive(index + 1, count);
 
        for(int i=0; i < w; i++)map[index][i] = '1';
        recursive(index + 1, count + 1);
 
        for(int i=0; i < w; i++)map[index][i] = '0';
        recursive(index + 1, count + 1);
 
        for (int j = 0; j < w; j++) {
            map[index][j] = origin[index][j];
        }
    }
 
    private static boolean check() {
        for (int j = 0; j < w; j++) {
            int count = 1;
            boolean flag = false;
            for (int i = 1; i < d; i++) {
                if (map[i - 1][j] != map[i][j]) count = 1;
                if (map[i - 1][j] == map[i][j]) count++;
                if (count >= k) {
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }
 
}
