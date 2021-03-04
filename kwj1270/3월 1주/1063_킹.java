import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static HashMap<Character, Integer> colMap = new HashMap<>();
    private static HashMap<Integer, Character> reverseColMap = new HashMap<>();

    private static HashMap<Integer, Integer> rowMap = new HashMap<>();
    private static HashMap<Integer, Integer> reverseRowMap= new HashMap<>();

    private static HashMap<String, Integer> dirsAlpha = new HashMap<>();

    private static int[][] map = new int[8][8];
    private static int [] dx = {0,0, 1,-1,-1,-1,1,1};
    private static int [] dy = {1,-1, 0,0,1,-1,1,-1};

    private static int n;
    private static int king_x;
    private static int king_y;

    private static int dol_x;
    private static int dol_y;


    public static void main(String[] args) throws IOException {
        init();
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        String king = stringTokenizer.nextToken();
        String dol = stringTokenizer.nextToken();
        n = Integer.parseInt(stringTokenizer.nextToken());

        king_y = colMap.get((king.charAt(0)));
        king_x = rowMap.get((king.charAt(1)-'0')-1);

        dol_y = colMap.get((dol.charAt(0)));
        dol_x = rowMap.get((dol.charAt(1)-'0')-1);

        map[king_x][king_y] = 1;
        map[dol_x][dol_y] = 2;

        for(int i=0; i < n; i++){
            String command = BUFFERED_READER.readLine().trim();
            int dir = dirsAlpha.get(command);
            int nx = king_x+dx[dir];
            int ny = king_y+dy[dir];

            int ndol_x = dol_x;
            int ndol_y = dol_y;

            if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
            if(map[nx][ny] != 0) {
                ndol_x = dol_x+dx[dir];
                ndol_y = dol_y+dy[dir];
                //print();
                //System.out.println("몇번 와?");
            }
            if(ndol_x < 0 || ndol_x >= 8 || ndol_y < 0 || ndol_y >= 8) continue;

            map[ndol_x][ndol_y] = map[dol_x][dol_y];
            if(!(dol_x == ndol_x && dol_y == ndol_y)) {
                map[dol_x][dol_y] = 0;
            }

            dol_x = ndol_x;
            dol_y = ndol_y;

            map[nx][ny] = map[king_x][king_y];
            map[king_x][king_y] = 0;
            king_x = nx;
            king_y = ny;

        }

        System.out.println(reverseColMap.get(king_y)+""+(reverseRowMap.get(king_x)+1));
        System.out.println(reverseColMap.get(dol_y)+""+(reverseRowMap.get(dol_x)+1));

    }

    private static void init(){
        for(char alphabet='A'; alphabet <= 'H'; alphabet++){
            colMap.put(alphabet, alphabet-'A');
            reverseColMap.put(alphabet-'A', alphabet);
        }

        for(int i=1; i <= 8; i++) {
            rowMap.put(i - 1, 8 - i);
            reverseRowMap.put(8 - i, i - 1);
        }

        dirsAlpha.put("R", 0);
        dirsAlpha.put("L", 1);
        dirsAlpha.put("B", 2);
        dirsAlpha.put("T", 3);
        dirsAlpha.put("RT", 4);
        dirsAlpha.put("LT", 5);
        dirsAlpha.put("RB", 6);
        dirsAlpha.put("LB", 7);

    }

    private static void print() {
        for(int i=0; i < 8; i++) {
            for(int j=0; j < 8; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}
