package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_보호필름 {
	static int map[][];
	static int N,M,K;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map= new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			findmin(0,0);
			
			
			System.out.println("#"+t+" "+min);
		}
	}
	private static void findmin(int x,int cnt) {
		
		if(cnt >= min ) return;
		
		
		
		if(check()) {	
			min = Math.min(min, cnt);
			
			return;
		}
		
		if(x== N) return;
		
		int [] before = map[x].clone();
		
		//약품 삽입 x
		findmin(x+1,cnt);
		
		//A 약품
		
		Arrays.fill(map[x],0);
		findmin(x+1,cnt+1);
		
		//B약품
		Arrays.fill(map[x],1);
		findmin(x+1,cnt+1);
		
		map[x]=before;
	}
	private static boolean check() {
		
		//각 열을 k만큼 깊이 들어가서 확인
		for (int i = 0; i <M; i++) {
			int cnt = 0;
			
			boolean flag = true;
			
			int before=map[0][i];
			
			for (int j = 0; j < N; j++) {
				if(before==map[j][i]) {
					cnt++;
					if(cnt==K) {
						flag =false;
						break;
						
					}
				}
				else {
					before = map[j][i];
					cnt=1;
				}
					
			}
			
			if(flag) return false;
		}
		
		return true;
	}
	
}
