package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수_찾기 {
	
	static int[] list;
	static int[] target;
	static int[] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		list = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		
		int M = Integer.parseInt(br.readLine());
		target = new int[M];
		ans = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			binarySearch(0,N-1,target[i],i);
			System.out.println(ans[i]);
		}
		
		
	}
	public static void binarySearch(int left, int right, int num,int order) {
		int mid;
		while(left<=right) {
			if(list[right]==num) {
				ans[order]=1;
				return;
			}
			
			mid = (left+right)/2;
			
			if(list[mid]==num) {
				ans[order]=1;
				return;
			}
			
			if(list[mid]<num) {
				left = mid+1;
			}

			if(list[mid]>num) {
				right=mid-1;
			}
		}
		ans[order]=0;
		return;
		
	}

}
