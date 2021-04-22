package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_보호필름 {


	static int D, W, K,ans;
	static int[][] Film;
	static int[][] copyFilm;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine()," ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			Film= new int[D][W];
			copyFilm= new int[D][W];
			ans=0;
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<W; j++) {
					Film[i][j] = Integer.parseInt(st.nextToken());
					copyFilm[i][j] = Film[i][j];
				}
			}
			
			if(isPass2D()) {
//				System.out.println("hello world5677");
				ans = 0;
				sb.append("#").append(tc).append(" ").append(ans).append("\n");
				continue;
			}
			outLoop:
			for(int i=1; i<=D; i++) {
//				System.out.println("hello world123");
				combination(0, 0, i, new int[i]);
					System.out.println("현재 a는 "+ a);
					
					
				}
				
			}
			
			
		}
		System.out.println(sb);
		
	}
	private static void combination(int cnt, int start, int limit, int numbers[]) {
		if(cnt==limit) {
//			System.out.println("hello world");
			for(int a : numbers) {
				injectionA(a);
				if(isPass2D()) {
					
				}
				injectionB(a);
				if(isPass2D()) {
					
				}
				for(int z=0; z<D; z++) {
					Film[z] = Arrays.copyOf(copyFilm[z],copyFilm[z].length);
				}
			}
			return;
		}
		
		for(int i = start; i<D; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1, limit, numbers);
		}
		
		return null;
	}
		
	private static void injectionB(int row) {
		for(int j=0; j<W; j++) {
			Film[row][j] = 1;
		}
	}
	private static void injectionA(int row) {
		for(int j=0; j<W; j++) {
			Film[row][j] = 0;
		}
	}
	private static boolean isPass2D() {
		int cnt=0;
		for(int i=0; i<W; i++) {
			if(isPass(i)) {
				cnt++;
			}
//			System.out.println("cnt는 " +cnt);
			if(cnt==W) return true;
		}
		
		return false;
	}
	private static boolean isPass(int col) {
		for(int i=0; i<=D-K; i++) {
			int temp = Film[i][col];
			int cnt=1;
			for(int a=1; a<K; a++) {
				if(temp != Film[i+a][col]) break;
				if(temp == Film[i+a][col]) cnt++;
				if(cnt==K) return true;
			}
		}
		
		return false;
	}

}
