import java.io.BufferedReader;
2
import java.io.IOException;
3
import java.io.InputStreamReader;
4
​
5
import java.util.LinkedList;
6
import java.util.Queue;
7
import java.util.StringTokenizer;
8
​
9
class Person {
10
    int x;
11
    int y;
12
​
13
    public Person(int x, int y) {
14
        this.x = x;
15
        this.y = y;
16
    }
17
​
18
}
19
​
20
class Main {
21
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
22
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
23
    private static StringTokenizer stringTokenizer;
24
    private static int[] dx = {0, 0, 1, -1};
25
    private static int[] dy = {1, -1, 0, 0};
26
​
27
    private static int[][] map;
28
    private static int[][] dp;
29
​
30
    private static int n;
31
    private static int m;
32
    private static int answer=0;
33
    private static Queue<Person> q;
34
​
35
    public static void main(String[] args) throws IOException {
36
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
37
        m = Integer.parseInt(stringTokenizer.nextToken());
38
        n = Integer.parseInt(stringTokenizer.nextToken());
39
​
40
        map = new int[m][n];
41
        dp = new int[m][n];
42
​
43
        for (int i = 0; i < m; i++) {
44
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
45
            for (int j = 0; j < n; j++) {
46
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
47
                dp[i][j] = -1;
48
            }
49
        }
50
​
51
        System.out.println(dfs(0, 0));
52
    }
53
​
54
    public static int dfs(int i, int j) {
55
        if(i == m-1 && j == n-1){
56
            return 1;
57
        }
58
        if(dp[i][j] != -1) return dp[i][j];
59
        dp[i][j] = 0;
60
        for(int k=0; k <4; k++){
61
            int nx = i+dx[k];
62
            int ny = j+dy[k];
63
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
64
            if(map[nx][ny] >= map[i][j]) continue;
65
            dp[i][j] += dfs(nx, ny);
66
        }
67
        return dp[i][j];
68
    }
69
}
