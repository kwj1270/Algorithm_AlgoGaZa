import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] box = new int[size];
		
		for (int i = 0; i <size; i++) {
			box[i] = sc.nextInt();
		}
		
		int[] dp = new int[size];
		Arrays.fill(dp, 1);
		
		int answer = 0;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if(box[i] > box[j])
					dp[i] = Math.max(dp[i],dp[j]+1);
			}
			answer = Math.max(answer, dp[i]);
		}
		
		//최대값 출력
		System.out.println(answer);
		
	}
}
