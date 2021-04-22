package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1234_비밀번호2 {

	static int N;
	static char[] arr;
	static ArrayList<Character> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			String temp = st.nextToken();
			
			arr = new char[N];
			list = new ArrayList<Character>();
			
			for(int i=0; i<N; i++) {
				list.add(temp.charAt(i));
			}
			searchtwin();
			sb1.append("#").append(tc).append(" ").append(print(list)).append("\n");
		}
		
		System.out.println(sb1);
	}

	private static String print(ArrayList<Character> list2) {
		StringBuilder temp = new StringBuilder();
		for(int i=0; i<list2.size(); i++) {
			temp.append(list2.get(i));
		}
		return temp.toString();
	}

	private static void searchtwin() {
		for(int i=0; i<list.size()-1; i++) {
			if(list.get(i)==list.get(i+1)) {
				list.remove(i);
				list.remove(i);
				i=-1;
			}
		}
	}


}
