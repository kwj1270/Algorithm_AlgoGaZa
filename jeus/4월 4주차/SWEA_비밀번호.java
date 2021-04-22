package backjoon_4월;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_비밀번호 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			sb.append("#"+i+" ");
			ArrayList<Integer> arr = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			String num = st.nextToken();
			for (int j = 0; j < N; j++) {
				arr.add(num.charAt(j)-'0');
			}
			
			int temp = arr.get(0);
			int j=1;
			while(j<arr.size()) {
				if(arr.get(j)==temp) {
					//System.out.print(j-1);
					//j-1인덱스가 지운다
					arr.remove(j-1);
					//System.out.print(j-1);
					//j-1인덱스가 지워져서 j의 인덱스가 j-1인덱스가 된다.
					arr.remove(j-1);
					temp = arr.get(0);
					j=1;
					continue;
				}
				temp=arr.get(j);
				j++;
			}
			
			for(int a: arr) {
				sb.append(a);
			}
			sb.append("\n");
			//bw.flush();
			//System.out.println("#"+i+" ");
			//System.out.println(sb.toString());
		}
		System.out.println(sb.toString());
		//bw.close();
	}

}
