import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
import static java.lang.Integer.parseInt;
 
public class Solution {
 
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;
 
    private static int n;
    private static final int TEST = 10;
    private static int start;
 
    private static ArrayList<Integer>[] list;
    private static int[] d;
 
    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= TEST; t++) {
            stringBuilder.setLength(0);
            stringBuilder.append("#").append(t).append(" ");
 
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            n = parseInt(stringTokenizer.nextToken());
            start = parseInt(stringTokenizer.nextToken());
            list = new ArrayList[n + 1];
 
            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }
            d = new int[n + 1];
 
 
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            for (int i = 0; i < n / 2; i++) {
                int from = parseInt(stringTokenizer.nextToken());
                int to = parseInt(stringTokenizer.nextToken());
                list[from].add(to);
            }
 
            Queue<Integer> queue = new LinkedList<>();
            d[0] = -1;
            d[start] = 1;
            queue.offer(start);
 
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int i = 0; i < list[now].size(); i++) {
                    int next = list[now].get(i);
                    if (d[next] != 0)
                        continue;
                    // System.out.println(next);
                    d[next] = d[now] + 1;
                    queue.offer(next);
                }
            }
 
            int maxIndex = Integer.MIN_VALUE;
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (d[i] >= maxValue) {
                    if (i >= maxIndex) {
                        maxValue = d[i];
                        maxIndex = i;
                    }
                }
                 
            }
 
            stringBuilder.append(maxIndex);
            System.out.println(stringBuilder.toString());
        }
 
    }
 
}
