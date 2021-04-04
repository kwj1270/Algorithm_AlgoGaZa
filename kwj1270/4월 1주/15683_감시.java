import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class CCTV {

	int x;
	int y;
	int dir;

	public CCTV(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "CCTV [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}

}

public class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static final int UP = 1, RIGHT = 2, DOWN = 4, LEFT = 8;
	static int[][] dirs = { 
			{}, 
			{ UP, RIGHT, DOWN, LEFT }, // 1번
			{ UP | DOWN, RIGHT | LEFT }, // 2번
			{ UP | RIGHT, RIGHT | DOWN, DOWN | LEFT, LEFT | UP }, // 3번
			{ LEFT | UP | RIGHT, UP | RIGHT | DOWN, LEFT | DOWN | RIGHT, UP | LEFT | DOWN }, // 4번
			{ UP | RIGHT | DOWN | LEFT } // 5번
	};

	private static int[][] map;
	private static List<CCTV> cctvs;
	private static int answer = Integer.MAX_VALUE;

	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {

		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[n][m];
		cctvs = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				if(map[i][j] != 0 && map[i][j] !=6) {
					cctvs.add(new CCTV(i, j, map[i][j]));	
				}
			}
		}

		go(0, map);
		System.out.println(answer);
	}

	private static void go(int index, int[][] nowMap) {
		if (index == cctvs.size()) {
			answer = Math.min(answer, getResult(nowMap));
			return;
		}
		int[][] copyMap = createCopyMap(nowMap);
		CCTV cctv = cctvs.get(index);

		for (int i = 0; i < dirs[cctv.dir].length; i++) {
			copyMap = setCCTV(cctv.x, cctv.y, dirs[cctv.dir][i], copyMap); // cctv 켜기
	        go(index+1, copyMap);
	        copyMap = createCopyMap(nowMap);
		}

	}


	private static int getResult(int[][] resultMap) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (resultMap[i][j] == 0)
					result++;
			}
		}
		return result;
	}
	
	private static int[][] createCopyMap(int[][] origin) {
		int[][] copyMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copyMap[i][j] = origin[i][j];
			}
		}
		return copyMap;
	}
	
    private static int[][] setCCTV(int x, int y, int i, int[][] copyMap) {
        for (int k = 0; k < 4; k++) { //번호 상관없이 모두 4방향 탐색
            if((i & (1<<k)) > 0) {
                int nx = x;
                int ny = y;
                while(true) {
                    nx += dx[k];
                    ny += dy[k];
                    if(ny >= m || ny < 0 || nx >= n || nx < 0) break;
                    if(copyMap[nx][ny] == 6) break;
                    if(copyMap[nx][ny] > 0 && copyMap[nx][ny] < 6) continue;
                    copyMap[nx][ny] = 9;
                }
            }
        }
        return copyMap;
    }
    

}
