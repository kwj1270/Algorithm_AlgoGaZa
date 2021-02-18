package com.study20;

import java.util.Scanner;

public class backjoon_14719_ºø¹° {
	static int H , W, cnt;
	static int[] map;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		H = sc.nextInt();
		W = sc.nextInt();
		sum = 0;
		map= new int[W];
		for (int i = 0; i < W; i++) {
			map[i] = sc.nextInt();
		}
		
		
		for (int i = 1; i < W; i++) {
			int left=-1;
			int right=-1;
			for (int j = i; j >= 0; j--) {
				if(left<map[j])
				left = map[j];
//				System.out.println("left "+i+" "+left);
				
			}
			for (int j = i; j < W; j++) {
				if(right<map[j])
				right = map[j];
				
			}
//			System.out.println("lefr "+left);
//			System.out.println("right "+right);
//			System.out.println("map[i] "+map[i]);
//			System.out.println(Math.min(left, right)-map[i]);
			sum += (Math.min(left, right) -map[i]);
			
		}
		
		System.out.println(sum);
	}
	

}
