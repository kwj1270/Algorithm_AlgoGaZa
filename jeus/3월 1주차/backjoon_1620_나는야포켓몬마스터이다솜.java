package com.study26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class backjoon_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] dogam= new String[N+1];
		HashMap<Integer,String> map = new HashMap<>();
		HashMap<String,Integer> map2 = new HashMap<>();
		for (int i = 1; i <=N; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			map.put(i, temp);
			map2.put(temp,i);
		}
		
		for (int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			//숫자면
			if(temp.charAt(0)>='1'&&temp.charAt(0)<='9')
			{
				int S = Integer.parseInt(temp);
				//System.out.println(dogam[S]);
				wr.write(map.get(S)+"\n");
				wr.flush();
				
			}
			else {
				
											//System.out.println(j);
						wr.write(map2.get(temp)+"\n");
						wr.flush();
					
				
			}
			
		}
		
		wr.close();

	}
}	
