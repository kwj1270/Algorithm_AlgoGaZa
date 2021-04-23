package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리_Re {
	static int N,T,K;
	static Bacteria[][] map;
	static List<Bacteria> baterias;
	static Queue<Bacteria> q;
	static int[] dy = {0,-1,1,0,0}; // 상 하 좌 우
	static int[] dx = {0,0,0,-1,1};
	
	static class Bacteria{
		int y,x,dir,cnt; //개별무게
		public Bacteria(int y, int x, int dir, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}
		
		public void move() {
			//약품이면 미생물 절반 죽고 이동 방향 반대로
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			
			if(ny == 0 || ny == N-1 || nx == 0 || nx == N-1) {
				this.cnt = this.cnt/2;
				switch (this.dir) {
					case 1:
						this.dir = 2;
						break;
					case 2:
						this.dir = 1;
						break;
					case 3:
						this.dir = 4;
						break;
					case 4:
						this.dir = 3;
						break;
				}
			}
			this.y = ny;
			this.x = nx;
		}

		@Override
		public String toString() {
			return "Bacteria [y=" + y + ", x=" + x + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new Bacteria[N][N];
			
			q = new LinkedList<Bacteria>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				Bacteria b = new Bacteria(y,x,dir,cnt);

				q.add(b);

			}
			sb.append("#").append(t).append(" ").append(solve()).append("\n");
			
		}
		System.out.println(sb);

	}
	
	private static int solve() {
		
		int[][] weightBacteria = new int[N][N];
		
		//큐에는 이동 후의 미생물 객체 정보만 담아논다
		//무게정보는 int[][] 로 따로 관리
		while (!q.isEmpty()) {
			if(T==0) break;

			int size = q.size();
			while(size-- > 0) {
				Bacteria b = q.poll();
				int y = b.y;
				int x = b.x;
				
				b.move(); // 이동
				
				int ny = b.y; // 새로운 y 좌표 
				int nx = b.x; // 새로운 x 좌표 
				
				if(b.cnt > 0) {
					if(map[ny][nx] == null) {
						weightBacteria[ny][nx] = b.cnt;
						map[ny][nx] = b;
						
					}else {
						if(map[ny][nx].cnt < b.cnt) {
							map[ny][nx] = b;
						}
						weightBacteria[ny][nx] += b.cnt; // 여기서 미생물 크기 누적해준다
					}
				}
			}// 이동 완료
			//print(weightBacteria);
			
			//다음 큐에 (방향,무게 누적)업데이트 한 최종 정보 담기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != null) {
						map[i][j].cnt = weightBacteria[i][j]; // 한번 이동이 끝나고 미생물 누적 값 -> 개별 무게로 업데이트
						q.add(map[i][j]); // 군집 무게 업데이트한 정보 담아서 큐에 넣어준다
						
						map[i][j] = null; // 원래 정보 지워주기
						weightBacteria[i][j] = 0; // 무게 정보 지워주기
					}
				}
			}	
			T--;
		}
		
		int sum = 0;
		while(!q.isEmpty()) {
			sum += q.poll().cnt;
		}

		return sum;
	}
	private static void print(int[][] weightBacteria) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
