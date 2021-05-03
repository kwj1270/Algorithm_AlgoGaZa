import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 좌표 정보를 위한 클래스
class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Algo2_광주_4반_김우재 {
	// 입출력
	private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	// 4방 탐색
	private static final int[] DX = { 0, 0, -1, 1 };
	private static final int[] DY = { 1, -1, 0, 0 };

	private static int test;
	private static int[][] map;
	private static int[][] dp;

	private static int n;
	private static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수 입력
		test = Integer.valueOf(READER.readLine().trim());

		for (int t = 1; t <= test; t++) {
			BUILDER.setLength(0);
			BUILDER.append("#").append(t).append(" ");

			stringTokenizer = new StringTokenizer(READER.readLine(), " ");
			// 세로 입력
			n = Integer.valueOf(stringTokenizer.nextToken());
			// 가로 입력
			m = Integer.valueOf(stringTokenizer.nextToken());
			
			// 맵정보 배열 생성
			map = new int[n][m];
			// 경우의 수 저장을 위한 배열 dp 생성
			dp = new int[n][m];

			// 맵 정보 할당
			for (int i = 0; i < n; i++) {
				stringTokenizer = new StringTokenizer(READER.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.valueOf(stringTokenizer.nextToken());
				}
			}
			
			// dfs 탐색 시작 -> 경우의 수마다 dp[x][y]++할것이다.
			dfs(0,0);
			
			// 마지막 위치의 경우의 수 빌더에 입력 후 출력
			BUILDER.append(dp[n-1][m-1]);
			System.out.println(BUILDER);
		}
	}

	private static void dfs(int now_x, int now_y) {
		// 4방탐색 시작
		for(int i=0; i < 4; i++) {
			int nx = now_x+DX[i];
			int ny = now_y+DY[i];
			// 범위 벗어나면 아웃
			if(nx < 0 || nx >=n || ny < 0 || ny >= m) continue;
			// 현재보다 같거나 크면 아웃
			if(map[nx][ny] >= map[now_x][now_y]) continue;
			// 현재 위치 경우의 수 증가
			dp[nx][ny]++;
			// 재귀 돌린다.
			dfs(nx, ny);
		}
	}

}




