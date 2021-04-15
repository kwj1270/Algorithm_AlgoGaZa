import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int R, C, N;
	
	static char[][] map;
	
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x = x;
			this.y =y;
		}
	}
	
	static ArrayList<pos>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		if(N%2==0) {
			for(int i=0; i<R;i++) {
				for(int j=0; j<C; j++) {
					System.out.print('O');
				}System.out.println();
			}
			return;
		}
		
		map = new char[R][C];
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList();
		}
		
		
		for(int i=0; i<R;i++) {
			String temp = br.readLine().trim();
			for(int j=0; j<C; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='O') {
					list[1].add(new pos(i,j));
				}
			}
		}
		
		
		
		for(int i=1; i<=N; i++) {
			process(i);
		}
		
		for(int i=0; i<R;i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		
	}
	public static void process(int sec) {
		if(sec==1) {
			return;
		}
		if(sec==2) {
			for(int i=0; i<R;i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j]=='.') {
						map[i][j] = 'O';
						list[sec].add(new pos(i,j));
					}
				}
			}
		}
		if(sec>=3) {
			
			if(sec%2!=0) {
				for(pos t : list[sec-2]) {
					map[t.x][t.y]= '.';
					for(int i=0; i<4; i++) {
						int nx = t.x +dx[i];
						int ny = t.y +dy[i];
						if(nx>=0&& nx<R && ny >=0 && ny<C) {
							map[nx][ny]= '.';
						}
					}
				}
				
				for(int i=0; i<R;i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j]=='O') {
							list[sec].add(new pos(i,j));
						}
					}
				}
				
			}
			
			if(sec%2==0) {
				for(int i=0; i<R;i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j]=='.') {
							map[i][j] = 'O';
							list[sec].add(new pos(i,j));
						}
					}
				}
			}
			
		}
	}
}
