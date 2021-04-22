package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_등산로_조성 {
	
	static int N,K,ans;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visit;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int max = Integer.MIN_VALUE;
	static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1 ;tc<=T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			dp = new int[N][N];
			visit = new boolean[N][N];
			max = Integer.MIN_VALUE;
			MAX = Integer.MIN_VALUE;
			
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(max < map[i][j]) { // 최대값을 찾았으면 최대값을 갱신
						max = map[i][j];
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==max) {	// 행렬 돌다가 최댓값 찾았으면 거기부터 bfs
						ans=0;
						dp = new int[N][N];
						start(i,j);
						if(MAX<ans)
							MAX = ans;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(MAX).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void start(int i, int j) { // 해당 칸부터 bfs, 그러나 나머지 칸 중에 하나를 선택하고 
											// 그 칸을 K이하로 파보면서 경우의 수를 따져야 함.
		combination(i,j);
	}
	private static void combination(int a, int b) {
		for(int i=0; i<N; i++) { // 자기 빼고 하나 선택하는 경우
			for(int j=0; j<N; j++) {
				if(i==a && j==b) continue;
				dig(i,j,K,a,b); // 땅 파기
			}
		}
		
	}
	private static void dig(int x, int y, int k2, int a, int b) {
//		System.out.println("x는 "+x+" y는 "+y);
		int temp = map[x][y]; // x,y 값은 저장해두고
		for(int k=1; k<=k2; k++) {
			// k를 1부터 k2까지 늘려가면서 땅 파기
			map[x][y] = temp;
			map[x][y]-=k;
			visit = new boolean[N][N];
			dp = new int[N][N];
			bfs(a,b); // 땅을 판 상태로 원 위치에서 bfs 진행
		}
		map[x][y] = temp; // 나갈땐 원래대로 해놓기
	}
	private static void bfs(int x, int y) {
		
		Queue<pos> q = new LinkedList();
		q.add(new pos(x,y));
		while(!q.isEmpty()) {
			pos temp = q.poll();
			visit[temp.x][temp.y]= true; 
			for(int d=0; d<4; d++) {
				int nx = temp.x + dx[d];
				int ny = temp.y + dy[d];
//				if(nx<0|| ny<0 || nx>=N || ny>=N|| visit[nx][ny]) continue;
//				
//				if(map[temp.x][temp.y]<map[nx][ny]) continue;
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny] && map[temp.x][temp.y]>=map[nx][ny]) {
					if(dp[nx][ny] < dp[temp.x][temp.y]+1)
						dp[nx][ny] = dp[temp.x][temp.y]+1;
					ans=dp[nx][ny];
					q.add(new pos(nx, ny));
				}
				
			}
		}
		
	}
	static class pos {
		int x, y ;
		public pos (int x, int y) {
			this.x =x;
			this.y =y;
		}
	}
	
	
}



