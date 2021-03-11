package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1713_후보_추천하기 {
	
	static int[] recommend;
	static int[][] frame;
	static int loop;
	static int[] ans;
	
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		loop=0;
		int temp = -1;
		
		N = Integer.parseInt(br.readLine());
		frame = new int[N][2];
		ans = new int [N];
		
		M = Integer.parseInt(br.readLine());
		recommend = new int [M];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			recommend[i] = Integer.parseInt(st.nextToken());
			for(int j=0; j<N; j++) {
				if(frame[j][0]==0) {
					frame[j][0]=recommend[i];
					break;
				}
				if(frame[j][0]==recommend[i]) {
					frame[j][1]++;
					break;
				}
				if(j==N-1) {
					temp = getPos();
					for(int k=temp; k<N-1; k++) {
						frame[k][0] = frame[k+1][0];
						frame[k][1] = frame[k+1][1];
					}
					frame[N-1][0] = recommend[i];
					frame[N-1][1] = 0;
				}
			}
			/*
			 * for(int p=0; p<N; p++) { System.out.print(frame[p][0] + " "); }
			 * System.out.println();
			 */
		}
		for(int i=0; i<N; i++) {
			ans[i]=frame[i][0];
		}
		Arrays.sort(ans);
		for(int i=0; i<N; i++) {
			System.out.print(ans[i] + " ");
		}
		
	}
	
	public static int getPos() {
		int min = Integer.MAX_VALUE;
		int pos=-1;
		for(int i=0; i<N; i++) {
			if(min>frame[i][1]) {
				min=frame[i][1];
				pos=i;
			}
		}
		
		return pos;
	}

}
