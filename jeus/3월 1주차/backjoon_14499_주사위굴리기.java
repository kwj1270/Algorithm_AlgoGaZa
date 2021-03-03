package com.study26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_14499_주사위굴리기 {
	static int N,M,x,y,index;
	static int[] dice = new int[7];
	static int[][] map;
	
	//동 서 북 남
	static int[] dx= {0,0,0,-1,1};
	static int[] dy= {0,1,-1,0,0};
	//static int[][] indexmove = {{0,0,0,0,0,0},{1,3,4,2,5,6},{2,3,4,6,1,5},{3,6,1,2,5,4},{4,1,6,2,5,3},{5,3,4,1,6,2},{6,3,4,5,2,1}};
	public static void move(int dir) {
		int nx = x+dx[dir];
		int ny = y+dy[dir];

		
		if(nx<0||ny<0||nx>=N||ny>=M) return;
		//이동이 가능 하면 주사위 변경
		changedice(dir);
//		System.out.println("index :" + index);
//		System.out.println("dir: "+dir);
//		System.out.println("nindex : "+nindex);
//		System.out.println("저장될 값 : "+map[nx][ny]);
		if (map[nx][ny] == 0)
            map[nx][ny] = dice[6]; 
        {
            dice[6] = map[nx][ny];
            map[nx][ny] = 0;
        }
		System.out.println(dice[1]);
		
		x = nx;
		y = ny;
		
	}
	public static void changedice(int dir) {
		int temp = dice[1];
		switch(dir) {
		case 1:
			//dice ={0,dice[4],dice[2],dice[1],dice[6],dice[5],dice[3]};
			dice[1] =dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = temp;
			break;
		case 2:
			//dice = {0, dice[3], dice[2], dice[6], dice[1], dice[5], dice[4]};
			dice[1]=dice[3];
			dice[3]=dice[6];
			dice[6]=dice[4];
			dice[4]=temp;
			break;
		case 3:
			//dice = {0, dice[5], dice[1], dice[3], dice[4], dice[6], dice[2]};
			dice[1]=dice[5];
			dice[5]=dice[6];
			dice[6]=dice[2];
			dice[2]=temp;
			break;
		case 4:
			//dice = {0, dice[2], dice[6], dice[3], dice[4], dice[1], dice[5]};
			dice[1]=dice[2];
			dice[2]=dice[6];
			dice[6]=dice[5];
			dice[5]=temp;
			break;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		dice = new int[7];
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int move = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		index=6;
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < move ; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			move(tmp);
		}

	}

}
