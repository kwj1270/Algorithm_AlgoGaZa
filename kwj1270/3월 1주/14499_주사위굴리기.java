import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int[] dx = {0,0,0,-1,1};
    private static int[] dy = {0,1,-1,0,0};

    private static int[] dice = new int[6]; // 상 하 좌 우 위 아래

    private static int n;
    private static int m;
    private static int x;
    private static int y;
    private static int k;

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine().trim(), " ");
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        x = Integer.parseInt(stringTokenizer.nextToken());
        y = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[n][m];
        for(int i=0; i < n; i++){
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine().trim(), " ");
            for(int j=0; j < m; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dice[1] = map[x][y];
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine().trim(), " ");
        for(int i=0; i < k; i++) {
            int command = Integer.parseInt(stringTokenizer.nextToken());
            int nx = x+dx[command];
            int ny = y+dy[command];
            
            if(nx <0 || nx >= n || ny < 0 || ny >= m) continue;
            x = nx;
            y = ny;
            roll(command);
            //print();
            System.out.println(dice[0]);
            if(map[nx][ny] == 0){
                map[nx][ny] = dice[1];
            }else {
                dice[1] = map[nx][ny];
                map[nx][ny] = 0;
            }
        }


    }

    private static void print() {
        for(int i=0; i< n; i++){
            for(int j=0; j < m; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0; i < 6; i++){
            System.out.print(dice[i] +" ");
        }
        System.out.println();
        System.out.println();

    }

    private static void roll(int command) {
        int temp[] = dice.clone();

        if(command == 1){ // 동이잖아
            dice[0] = temp[2];
            dice[2] = temp[1];
            dice[1] = temp[3];
            dice[3] = temp[0];
            return;
        }
        if(command == 2){
            dice[0] = temp[3];
            dice[3] = temp[1];
            dice[1] = temp[2];
            dice[2] = temp[0];
            return;
        }
        if(command == 3){       // 북
            dice[0] = temp[5];
            dice[5] = temp[1];
            dice[1] = temp[4];
            dice[4] = temp[0];
            return;
        }
        if(command == 4){       //남
            dice[0] = temp[4];
            dice[4] = temp[1];
            dice[1] = temp[5];
            dice[5] = temp[0];
            return;
        }

    }


}


