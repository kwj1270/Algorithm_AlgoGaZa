package com.study32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_2578_빙고 {
	static int N;
	static int[][] map = new int[5][5];
	static int bing[] = {0,1,2,3,4};
	static int bingcnt=0;
	public static void binggo() {
		int tempcnt=0;
		int tempcnt2=0;
		for (int i = 0; i < 5; i++) {
			//가로 빙고
			if(map[i][0]==0&&map[i][1]==0&&map[i][2]==0&&map[i][3]==0&&map[i][4]==0)
				bingcnt++;
			//세로 빙고
			if(map[0][i]==0&&map[1][i]==0&&map[2][i]==0&&map[3][i]==0&&map[4][i]==0)
				bingcnt++;
			//반대 대각선 빙고
			if(map[i][4-i]==0) {
				tempcnt2++;
				if(tempcnt2==5) {
					bingcnt++;
				}
			}
			//대각선 빙고
			if(map[i][i]==0) {
				tempcnt++;
				if(tempcnt==5) {
					bingcnt++;
				}
			}
				
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 5; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		/*
		 * //탐색에 더 좋은 방법이 있을가 고민 해보자 for (int i2 = 0; i2 < 3; i2++) { st = new
		 * StringTokenizer(br.readLine()," "); for (int i3 = 0; i3 < 5; i3++) { int temp
		 * = Integer.parseInt(st.nextToken());
		 * 
		 * for (int i = 0; i < 5; i++) { for (int j = 0; j < 5; j++) {
		 * if(map[i][j]==temp) map[i][j]=0; } } }
		 * 
		 * } binggo(); if(bingcnt>=3) { System.out.println(15); return; }
		 */
		int cnt =0;
		
		for (int i2 = 0; i2 < 5; i2++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int i3 = 0; i3 < 5; i3++) {
					int temp = Integer.parseInt(st.nextToken());	
					
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if(map[i][j]==temp) {
							map[i][j]=0;
							bingcnt=0;
							binggo();
							cnt++;
							if(bingcnt>=3) {
								System.out.println(cnt);
								return;
							}
							
						}
					}
				}
			}

		}
		
		
	}
}
