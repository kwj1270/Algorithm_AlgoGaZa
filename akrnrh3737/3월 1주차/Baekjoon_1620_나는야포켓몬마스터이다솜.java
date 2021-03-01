package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] init = br.readLine().split(" ");
		int N = Integer.parseInt(init[0]); //전체 포켓몬개수
		int M = Integer.parseInt(init[1]); // 문제개수
		
		HashMap<String,Integer> StringMap = new HashMap<>(); // 문자열이 키인 해쉬맵
		HashMap<Integer,String> DigitMap = new HashMap<>(); // 숫자가 키인 해쉬맵
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			StringMap.put(s, i);			
		}
		for (String k : StringMap.keySet()) {
			int value = StringMap.get(k);
			DigitMap.put(value, k);
		}
		
		
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			//숫자인지 판별
			if(isNumber(temp)) {
				sb.append(DigitMap.get(Integer.parseInt(temp))).append("\n");
				
			}else {
				sb.append(StringMap.get(temp)).append("\n");
			}
		}
		System.out.print(sb);


	}
	private static boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			if(!Character.isDigit(s.charAt(i))) return false;
		}
		return true;
	}
	//hashmap에서 value로 key찾기
//	private static String getKey(Map<String,Integer> map, Integer value) {
//		for (String key : map.keySet()) {
//			if(map.get(key).equals(value)) {
//				return key;
//			}
//		}
//		return null;
//		
//	}
	
	

}
