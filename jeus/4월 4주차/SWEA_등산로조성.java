package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_등산로조성 {
	static int map[][];
	static int N,K,top=Integer.MIN_VALUE;
	static int max = Integer.MIN_VALUE;
	static boolean isSelected[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int count=1;
	static int length;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			max = Integer.MIN_VALUE;
			top = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int [N+1][N+1];
			for (int i = 0; i <N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j <N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					top = Math.max(top, map[i][j]);
				}
			}
			
			for (int i = 0; i <=N; i++) {
				for (int j = 0; j <= N; j++) {
					if(map[i][j]==top)
					{	
						count=1;
						length=0;
						isSelected=new boolean[N][N];
						isSelected[i][j]=true;
						dfs(i,j,top,1);
						
					}
				}
			}
			System.out.println("#"+t+" "+max);
		
		}

	}
	private static void dfs(int x, int y,int height,int cnt) {
		
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||ny<0||nx>=N||ny>=N) continue;
			
			int nh = Math.abs(height-map[nx][ny])+1; // 현재 봉우리 - 이동할려고 하는 봉우리 
			
			if(isSelected[nx][ny]) continue;
			
			if(map[nx][ny]>=map[x][y]) {
			
				if(count==1&&nh<=K){
				
				count--;
				
				isSelected[nx][ny] = true;
				
				int temp = map[nx][ny];
				
				map[nx][ny] = height-1;
				
				dfs(nx,ny,map[nx][ny],cnt+1);
				
				map[nx][ny]=temp;
				
				isSelected[nx][ny] = false;
				
				count++;
				
				}
				continue;
			}
			
				isSelected[nx][ny] = true;
				
				dfs(nx,ny,map[nx][ny],cnt+1);
				
				isSelected[nx][ny] = false;
				
			
			
			
		}
		max = Math.max(max, cnt);
		return;
	}

}
