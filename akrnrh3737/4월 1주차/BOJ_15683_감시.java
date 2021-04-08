package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
	static int R,C;
	static int[][] map;
	static int[][] copymap;
	static int ans;
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,1,0,-1};
	static int up = 1, right = 2, down = 4, left = 8;
	static int[][] dirs = {
			{},
			{up, right, down, left}, // 1번
			{up|down, right|left}, // 2번
			{up|right, right|down, down|left, left|up}, // 3번
			{left|up|right, up|right|down, left|down|right, up|left|down}, //4번
			{up|right|down|left} // 5번
	};
	
	static List<CCTV> cctvs;
	
	static class CCTV{
		int y,x,num;
		
		public CCTV(int y, int x, int num) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		copymap = new int[R][C];
		cctvs = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		copyMap();
		rotate(0);
		System.out.println(ans);
	}
	
	//cctv 90도 회전시켜서 0이 최소가 되게
	private static void rotate(int cnt) {
		if(cnt == cctvs.size()) {
			//사각지대 영역 검사
			int total = check();
			if(total < ans) {
				ans = total; // 최소값갱신
//				for (int i = 0; i < R; i++) {
//					for (int j = 0; j < C; j++) {
//						System.out.print(copymap[i][j]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//				System.out.println(ans);
			}
			
			return;
		}
		int y = cctvs.get(cnt).y;
		int x = cctvs.get(cnt).x;
		int num = cctvs.get(cnt).num;
		for (int i = 0; i < dirs[num].length; i++) {
			setCCTV(y,x,dirs[num][i],1); // cctv 켜기
			rotate(cnt+1);
			setCCTV(y,x,dirs[num][i],-1); // cctv 끄기
		}

	}
	
	private static void setCCTV(int y, int x, int i, int val) {
		for (int k = 0; k < 4; k++) { //번호 상관없이 모두 4방향 탐색
			if((i & (1<<k)) > 0) {
				int ny = y;
				int nx = x;
				while(true) {
					ny += dy[k];
					nx += dx[k];
					if(ny >= R || ny < 0 || nx >= C || nx < 0) break;
					if(copymap[ny][nx] == 6) break;
					copymap[ny][nx] += val;
				}
			}
		}
		
	}

	private static int check() {
		int area = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(copymap[i][j] == 0) {
					area++;
				}
			}
		}
		return area;
	}
	
	private static void copyMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copymap[i][j] = map[i][j];
			}
		}
	}
}
