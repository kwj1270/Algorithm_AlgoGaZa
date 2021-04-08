package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1577_도로의개수 {

	static int N,M,K;
	static long D[][]=new long [101][101];
	static boolean map[][]=new boolean[101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			map[x1][y1]=true;
			map[x2][y2]=true;
		}
		//초기값
		D[0][0]=1;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if(D[i][j]>0) continue;
				//길이 막힌 경우 
				if(i!=0&&map[i][j]&&map[i-1][j]) {
					if(j==0) {
						D[i][j]=0;
						continue;
					}
					D[i][j]=D[i][j-1];
					continue;}
				if(j!=0&&map[i][j]&&map[i][j-1]) {
					if(i==0) {
						D[i][j]=0;
						continue;
					}
					D[i][j]=D[i-1][j];
					continue;
					}
				
				if(i==0) {
				D[i][j]=D[i][j-1];
				continue;
				}
				
				if(j==0) {
				D[i][j]=D[i-1][j];
				continue;
				}
				
				D[i][j]=D[i-1][j] + D[i][j-1];
			}
		}
//		for (int i = N; i >=0; i--) {
//			System.out.println(Arrays.toString(D[i]));
//		}
		if(map[N][M]) {
			if(map[N][M-1]) {
				if(map[N-1][M]) {
					System.out.println(0);
					return;
				}
				System.out.println(D[N-1][M]);
			
			}
			if(map[N-1][M]) {
				if(map[N][M-1]) {
					System.out.println(0);
					return;
				}
			System.out.println(D[N][M-1]);
			}
		}
		else {
		System.out.println(D[N][M]);
		}
	}
}
