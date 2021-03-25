package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	
	static class pos {
		int x,y;
		pos (int x, int y ) {
			this.x = x;
			this.y = y;
		}
	}
	static Map<Integer,pos> board = new HashMap<>();
	static boolean [][] marked;
	static int bingo, cnt;
	static boolean d1,d2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> list = new ArrayList<>();
		cnt=0;
		bingo=0;
		d1 = false;
		d2 = false;
		
		marked = new boolean [5][5];
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer (br.readLine()," ");
			for(int j=0; j<5; j++) {
				board.put(Integer.parseInt(st.nextToken()), new pos(i,j));
			}
		}
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer (br.readLine()," ");
			for(int j=0; j<5; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i : list) {
			cnt++;
			pos temp = board.get(i);
			marked[temp.x][temp.y]= true; 
			if(cnt>=5) {
				bingo=0;
				check();
				if(bingo>=3) {
//					for(int ai=0; ai<5; ai++) {
//						for(int aj=0; aj<5; aj++) {
//							System.out.print(marked[ai][aj]+" ");
//						}System.out.println();
//					}
					System.out.println(cnt);
					return;
				}
			}
			
		}
		
	}
	private static void check() {
		int garo=0;
		int sero=0;
		d1=false;
		d2 = false;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				
				if(marked[i][j])garo++;
				if(marked[j][i])sero++;
			}

			if(garo==5) {
				bingo++;
			}
			if(sero==5) {
				bingo++;
			}
			
			
			garo=0;
			sero =0;
		}
		if(marked[0][0]&&marked[1][1]&&marked[2][2]&&marked[3][3]&&marked[4][4]&&!d1) {
			d1=true; 
			bingo++;
		}
		if(marked[0][4]&&marked[1][3]&&marked[2][2]&&marked[3][1]&&marked[4][0]&&!d2) {
			d2 = true;
			bingo++;
		}
	}
	
}
