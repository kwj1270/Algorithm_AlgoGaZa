import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


class Customer {
	int x;
	int y;
	
	public Customer(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
public class Solution {
	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;
	
	private static int t;
	private static int n;
	
	private static ArrayList<Customer> customers;
	
	private static int[] visit;
	
	private static int start_x;
	private static int start_y;
	private static int end_x;
	private static int end_y;
	
	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(BUFFERED_READER.readLine().trim());
		
		for(int test=1; test <= t; test++) {
			STRING_BUILDER.setLength(0);
			STRING_BUILDER.append("#").append(test).append(" ");
			n = Integer.parseInt(BUFFERED_READER.readLine().trim());
			customers = new ArrayList<Customer>();
			
			visit =  new int[n];
			for(int i=0; i < n; i++){
				visit[i] = i;
			}
			Arrays.sort(visit);
			
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine().trim(), " ");
			start_x = Integer.parseInt(stringTokenizer.nextToken());
			start_y = Integer.parseInt(stringTokenizer.nextToken());
			
			end_x = Integer.parseInt(stringTokenizer.nextToken());
			end_y = Integer.parseInt(stringTokenizer.nextToken());
			
			
			for(int i=0; i < n; i++) {
				int temp_x = Integer.parseInt(stringTokenizer.nextToken());
				int temp_y = Integer.parseInt(stringTokenizer.nextToken());
				customers.add(new Customer(temp_x, temp_y));
			}
						
			int answer = Integer.MAX_VALUE;
			do {
				int result = 0;
				int now_x = start_x;
				int now_y = start_y;
				for(int i=0; i < n; i++) {
					int cus_x = customers.get(visit[i]).x;
					int cus_y = customers.get(visit[i]).y;
					
					result += Math.abs(now_x - cus_x);
					result += Math.abs(now_y - cus_y);
					
					now_x = cus_x;
					now_y = cus_y;
				}
				
				result += Math.abs(now_x - end_x);
				result += Math.abs(now_y - end_y);
				
				answer = Math.min(answer, result);
				
			} while(nextPermutaion());
			
			STRING_BUILDER.append(answer);
			System.out.println(STRING_BUILDER.toString());
		}
	}
	
	private static boolean nextPermutaion() {
		int i = n-1;
		int j = n-1;
		int k = n-1;
		
		while(i > 0 && visit[i-1] >= visit[i]) --i;
		if(i == 0) return false;
		
		while(visit[i-1] >= visit[j]) --j;
		swap(i-1, j);
		
		while (i < k) {
			swap(i,k);
			i++;
			k--;
		}
		return true;
	}
	
	private static void swap(int a, int b) {
		int temp = visit[a];
		visit[a] = visit[b];
		visit[b] = temp;
	}
	
	
	
}
