package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14719_빗물 {
	
	static int[] world;
	static int H,W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		int ans=0;
		
		world = new int[W];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<W; i++) {
			world[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<W-1; i++) {
			ans+=search(i);
		}
		System.out.println(ans);
		
	}
	
	public static int search(int index) {
		int max_l=Integer.MIN_VALUE;
		int max_r=Integer.MIN_VALUE;
		
		for(int i=0; i<index; i++) {
			if(max_l<world[i] && world[i]>world[index]) {
				max_l=world[i];
			}
		}
		for(int i=W-1; i>index; i--) {
			if(max_r<world[i] && world[i]>world[index]) {
				max_r=world[i];
			}
		}
		
		if(max_l<0||max_r<0) return 0;
		
		return Math.min(max_r,max_l) - world[index];
		
	}
}
