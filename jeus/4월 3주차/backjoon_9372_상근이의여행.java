package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_9372_상근이의여행 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println(1);
		int TC =Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < M; j++) {
				st=new StringTokenizer(br.readLine());
			}
			System.out.println(N-1);
		}
	}

}
