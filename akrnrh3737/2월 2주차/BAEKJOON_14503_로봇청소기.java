package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int y;
	int x;
	int dir;
	Pos(int y, int x, int dir){
		this.y = y;
		this.x = x;
		this.dir = dir;
	}
}

public class BAEKJOON_14503_로봇청소기 {
/**
 * 0 1 2 3 
 * 1. 현재위치 청소
 * 2. 현재위치에서 현재 방향 기준으로 왼쪽방향부터 차례대로 탐색!!! 사방탐색 여기서 진행해준다
 * 2-1. 왼쪽방향에 청소할수있는 공간 -> 그 방향으로 회전하고 한칸 전진하고 1번 부터 진행
 * 2-2. 왼쪽방향에 청소공간없음 -> 그 방향으로 회전하고 2번으로 돌아감.
 * 2-3. 네 방향 모두 청소됨 || 네 방향 모두 벽 -> 방향 유지하고 한칸 후진하고 2번으로 돌아감
 * 2-4. 네방향 모두 청소됨 && 네방향모두벽 && 뒤도벽이라 후진못함 -> end
 *  
 */
	//북 동 남 서
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	
	static int[][] map;

	//로봇청소기가 청소하는 칸의 개수
	public static void clean(int y, int x, int dir) {

		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(y,x,dir));
		map[y][x] = 2;
		while(!q.isEmpty()) {
			Pos now = q.poll();
			
			int cleanCnt=0;
			int nowY = now.y;//현재y
			int nowX = now.x;//현재x
			int nowDir = now.dir;//현재방향
			int ny,nx,nd;
			for (int k = 0; k < 4; k++) {
				nowDir = (nowDir + 3) % 4; //dir을 덮어씌워야 다음 탐색에 적용이된다.
				ny = nowY + dy[nowDir];
				nx = nowX + dx[nowDir];
				
				if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length) {
					//왼쪽 청소할수있음
					if(map[ny][nx] == 0) {
						//System.out.println("(" +ny+" , "+nx + ") dir : "+nowDir);
						//방향 회전하고 -> 한칸 전진 -> 바뀐 방향 다시 next에 넣어줌
						q.add(new Pos(ny, nx, nowDir));
						map[ny][nx] = 2;
						break;//처음부터 진행
					}else {
						cleanCnt++;
					}
				}
			}//사방탐색끝
			//네 방향 모두 탐색했으면
			if(cleanCnt == 4) {
				nd = (nowDir + 2) % 4;
				ny = nowY + dy[nd];
				nx = nowX + dx[nd];
				
				//후진한곳이 벽이 아니면 계속 진행
				//방향 유지하고 후진하고 2번으로 돌아감
				if(map[ny][nx] != 1) {
					q.add(new Pos(ny, nx, nowDir));
					map[ny][nx] = 2;
				}
			}
			
		}
		
	}
	
	//입력정복하기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ROW = Integer.parseInt(st.nextToken());
		int COL = Integer.parseInt(st.nextToken());
		
		String[] pos = br.readLine().split(" ");
		int startY = Integer.parseInt(pos[0]);
		int startX = Integer.parseInt(pos[1]);
		int startDir = Integer.parseInt(pos[2]);
		
		map = new int[ROW][COL];
		
		
		for (int i = 0; i < ROW; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < COL; j++) {
				map[i][j] = Integer.parseInt(s.nextToken());
			}
		}
		
		//solve
		int answer=0;
		clean(startY, startX, startDir);
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if(map[i][j] == 2) {
					answer++;
				}
			}
		}
		sb.append(answer);
		System.out.print(sb);
	}

}
