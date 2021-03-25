package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	static int[][] board;
	static int[][] order;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		order = new int[5][5];
		visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				order[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//solve
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				if(bingo(order[i][j], ++cnt)) {
					System.out.println(cnt);
					return;
				}
			}
		}
		

	}

	private static boolean bingo(int num, int cnt) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(board[i][j] == num) {
					visited[i][j] = true;
				}
			}
		}
		
		int total = 0;
		boolean flag = true;
		
		//가로
		for (int i = 0; i < 5; i++) {
			flag = true;
			for (int j = 0; j < 5; j++) {
				if(!visited[i][j]) {
					flag = false;
				}
			}
			if(flag) total++;
		}
		
		//세로
		for (int i = 0; i < 5; i++) {
			flag = true;
			for (int j = 0; j < 5; j++) {
				if(!visited[j][i]) {
					flag = false;
				}
			}
			if(flag) total++;
		}

		//왼쪽아래 - 오른쪽위 대각선 40 31 22 13 04
		int i=4, j=0;
		flag = true;
		for (int k = 0; k < 5; k++) {
			if(!visited[i--][j++]) {
				flag = false;
				break;
			}
		}
		if(flag) total++;
		
		//오른쪽아래 - 왼쪽위 대각선
		i=4; j=4;
		flag = true;
		for (int k = 0; k < 5; k++) {
			if(!visited[i--][j--]) {
				flag = false;
				break;
			}
		}
		if(flag) total++;
		
		return total >= 3 ? true : false;
		
	}

}
