import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Tuple implements Comparable{
    int z;
    int x;
    int y;
    int value;
    public Tuple(int z, int x, int y, int value){
        this.z = z;
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return this.value-((Tuple)o).value;
    }
}

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private static int[][][] map;
    private static int[][][] dp;

    private static int n;
    private static int m;
    private static int h;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        h = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[h][n][m];
        dp = new int[h][n][m];

        for(int k=0; k < h; k++){
            for(int i=0; i < n; i++){
                stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
                for(int j=0; j < m; j++){
                    map[k][i][j] = Integer.parseInt(stringTokenizer.nextToken());
                    dp[k][i][j] = -1;
                }
            }
        }

        for(int k=0; k < h; k++){
            for(int i=0; i < n; i++){
                for(int j=0; j < m; j++){
                    if(map[k][i][j] == 1) {
                        bfs(k,i,j);
                    }
                }
            }
        }

        //print();

        int max = Integer.MIN_VALUE;
        for(int k=0; k < h; k++){
            for(int i=0; i < n; i++){
                for(int j=0; j < m; j++){
                    if(dp[k][i][j] == -1 && map[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, dp[k][i][j]);
                }
            }
        }
        System.out.println(max);

    }

    public static void bfs(int k, int i, int j){
        dp[k][i][j] = 0;
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(k,i,j, 0));
        while (!q.isEmpty()){
            Tuple now = q.poll();
            int z = now.z;
            if(dp[now.z][now.x][now.y] < now.value) continue;
            for(int dir=0; dir < 4; dir++){
                int nx = now.x+dx[dir];
                int ny = now.y+dy[dir];
                int nv = now.value+1;

                if(nx < 0 || nx >= n) continue;
                if(ny < 0 || ny >= m) continue;
                if(map[z][nx][ny] == -1) continue;
                if(dp[z][nx][ny] == -1 || dp[z][nx][ny] > nv){
                    dp[z][nx][ny] = nv;
                    q.offer(new Tuple(z, nx, ny, nv));
                }
            }
            if(now.z+1 <= h-1 && map[z+1][now.x][now.y] != -1){
                if(dp[z+1][now.x][now.y] == -1 || dp[z+1][now.x][now.y] > now.value+1) {
                    dp[z+1][now.x][now.y] = now.value+1;
                    q.offer(new Tuple(now.z+1, now.x, now.y, now.value+1));
                }
            }
            if(now.z-1 >= 0 && map[z-1][now.x][now.y] != -1){
                if(dp[z-1][now.x][now.y] == -1 || dp[z-1][now.x][now.y] > now.value+1) {
                    dp[z-1][now.x][now.y] = now.value+1;
                    q.offer(new Tuple(now.z-1, now.x, now.y, now.value+1));
                }
            }
        }
    }

    public static void print(){
        for(int k=0; k < h; k++){
            for(int i=0; i < n; i++){
                for(int j=0; j < m; j++){
                    System.out.print(dp[k][i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("\n");
        }
    }

}
