import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.valueOf;

class Microbe implements Comparable<Microbe> {

    private static final int DX[] = {0,-1,1,0,0};
    private static final int DY[] = {0,0,0,-1,1};

    int x;
    int y;
    int count;
    int d;

    public Microbe(int x, int y, int count, int d) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.d = d;
    }

    public void move(int n) {

        int nx = x + DX[d];
        int ny = y + DY[d];

        if (nx == 0) {
            count /= 2;
            d = 0;
        } else if (nx == n-1) {
            count /= 2;
            d = 1;
        } else if (ny == n-1) {
            count /= 2;
            d = 2;
        } else if (ny == 0) {
            count /= 2;
            d = 3;
        }

        x = nx;
        y = ny;
    }

    @Override
    public int compareTo(Microbe o) {
        return o.count - this.count;
    }
}

public class Solution {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static List<Microbe>[][] map;
    private static List<Microbe> microbes;

    private static int test;

    private static int n;
    private static int m;
    private static int k;


    public static void main(String[] args) throws IOException {
        test = valueOf(BUFFERED_READER.readLine().trim());
        for (int t = 1; t <= test; t++) {
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");

            n = valueOf(stringTokenizer.nextToken());
            m = valueOf(stringTokenizer.nextToken());
            k = valueOf(stringTokenizer.nextToken());

            map = new ArrayList[n][n];
            for(int i=0; i < n; i++) {
                for(int j=0; j < n; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }
            microbes = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
                int x = valueOf(stringTokenizer.nextToken());
                int y = valueOf(stringTokenizer.nextToken());
                int count = valueOf(stringTokenizer.nextToken());
                int d = valueOf(stringTokenizer.nextToken());
                Microbe microbe = new Microbe(x, y, count, d);
                microbes.add(microbe);
                map[x][y].add(microbe);
            }
            for(int i=0; i < m; i++) {
                run();
            }
            int answer = getAnswer();
            STRING_BUILDER.append(answer);
            System.out.println(STRING_BUILDER);
        }
    }

    private static int getAnswer() {
        int sum = 0;
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(map[i][j].size() == 0) continue;
                sum += map[i][j].get(0).count;
            }
        }
        return sum;
    }

    private static void run() {
        move();
        remove();
    }

    private static void remove() {
        for(int i=0; i < n; i++) {
            for(int j=0; j< n; j++) {
                if(map[i][j].size() == 0) continue;
                Collections.sort(map[i][j]);
                Microbe remain = map[i][j].get(0);
                map[i][j].remove(remain);
                for(int k=0; k < map[i][j].size(); k++) {
                    Microbe trash = map[i][j].get(k);
                    remain.count += trash.count;
                    microbes.remove(trash);
                }
                map[i][j] = new ArrayList<>();
                map[i][j].add(remain);
            }
        }
    }

    private static void move() {
        for(Microbe mic : microbes) {
            map[mic.x][mic.y].remove(mic);
            mic.move(n);
            map[mic.x][mic.y].add(mic);
        }
    }


}
