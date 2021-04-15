import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

import static java.lang.Integer.valueOf;

//
// 봄버맨은 크기가 R×C인 직사각형 격자판 위에서 살고 있다. 격자의 각 칸은 비어있거나 폭탄이 들어있다.
//
//        폭탄이 있는 칸은 3초가 지난 후에 폭발하고, 폭탄이 폭발한 이후에는 폭탄이 있던 칸이 파괴되어 빈 칸이 되며, 인접한 네 칸도 함께 파괴된다. 즉, 폭탄이 있던 칸이 (i, j)인 경우에 (i+1, j), (i-1, j), (i, j+1), (i, j-1)도 함께 파괴된다. 만약, 폭탄이 폭발했을 때, 인접한 칸에 폭탄이 있는 경우에는 인접한 폭탄은 폭발 없이 파괴된다. 따라서, 연쇄 반응은 없다.
//
//        봄버맨은 폭탄에 면역력을 가지고 있어서, 격자판의 모든 칸을 자유롭게 이동할 수 있다. 봄버맨은 다음과 같이 행동한다.
//
//        가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
//        다음 1초 동안 봄버맨은 아무것도 하지 않는다.
//        다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다. 폭탄은 모두 동시에 설치했다고 가정한다.
//        1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
//        3과 4를 반복한다.
//        폭탄을 설치해놓은 초기 상태가 주어졌을 때, N초가 흐른 후의 격자판 상태를 구하려고 한다.
class Bomb {
    int x;
    int y;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    private static int dx[] = {0, -1, 0, 1};
    private static int dy[] = {1, 0, -1, 0};

    private static List<Bomb> bombs;
    private static List<Bomb> anotherBombs;

    private static char map[][];

    private static int n;
    private static int m;
    private static int t;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        n = valueOf(stringTokenizer.nextToken());
        m = valueOf(stringTokenizer.nextToken());
        t = valueOf(stringTokenizer.nextToken());

        map = new char[n][m];
        bombs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map[i] = BUFFERED_READER.readLine().trim().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'O') {
                    bombs.add(new Bomb(i, j));
                }
            }
        }

        for (int i = 0; i < t; i++) {
            if(i == 1) {
                allBomb();
                continue;
            }
            if(i == 2) {
                bomb();
                continue;
            }
            if (i >= 3 && i % 2 == 1) {
                allBomb();
                bombs = anotherBombs;
                continue;
            }
            if(i >= 4) {
                bomb();
            }
        }
        print();

    }


    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void bomb() {
        for (Bomb bomb : bombs) {
            map[bomb.x][bomb.y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = bomb.x + dx[i];
                int ny = bomb.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                map[nx][ny] = '.';
            }
        }
    }

    private static void allBomb() {
        anotherBombs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'O') {
                    anotherBombs.add(new Bomb(i, j));
                    continue;
                }
                map[i][j] = 'O';
            }
        }
    }


}
