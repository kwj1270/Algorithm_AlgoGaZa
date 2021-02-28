package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15684_사다리조작 {
	static int[][] ladder; //ladder[i][j] : i 가로점선 -> j 세로선  사다리 연결되있으면 1
	static int Col,Row,H;
	static int ans=4;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		Col = Integer.parseInt(s[0]); // 세로선
		Row = Integer.parseInt(s[1]); // 가로선
		H = Integer.parseInt(s[2]); // 가로선 놓을수 있는 위치 개수
		ladder = new int[H+1][Col+1];
		
		for (int i = 0; i < Row; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ladder[y][x] = 1;
		}
//		for (int i = 1; i <= H; i++) {
//			for (int j = 1; j <= Col; j++) {
//				System.out.print(ladder[i][j]+" ");
//			}
//			System.out.println();
//		}

		setLine(0,1,1);
		ans = ans > 3 ? -1 : ans;
		System.out.println(ans);

	}
	//y:가로 x:세로 
	private static void setLine(int cnt, int y, int x) {

		if(cnt > 3) return;
		//if(ans <= cnt) return; //더 안해봐도됨
		//사다리 타기 체크
		if(check()) {
			if(ans > cnt) {
				ans = cnt;
			}
			return;
		}

		for (int i = y; i <= H; i++) {
			for (int j = 1; j < Col; j++) {
				if(ladder[i][j] == 1 || ladder[i][j-1] == 1 || ladder[i][j] == 1) continue;
				ladder[i][j] = 1;
				setLine(cnt+1, i, j);
				ladder[i][j] = 0;
			}
		}

	}
	//x세로선에서 x세로선에 도착할수있는지
	private static boolean check() {
		for (int i = 1; i <= Col; i++) {
			int now = i;
			for (int j = 1; j <= H; j++) {
				if(ladder[j][now] == 1) {//오른쪽으로 꺾을수있을때
					now++;
				}else if(ladder[j][now-1]==1) {//왼쪽으로 꺾을수있을때
					now--;
				}
			}

			if(i != now) return false;
		}
	
		return true;
	}

}
