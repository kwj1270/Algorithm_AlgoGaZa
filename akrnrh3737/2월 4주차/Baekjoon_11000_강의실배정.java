package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
/**
 * 최소의 강의실을 사용해 모든 수업을 가능하게 배정
 * 우선순위 큐 -> 종료 시각 빠른순
 * */
class Class {
	int start;
	int end;
	Class(int start, int end){
		this.start = start;
		this.end = end;
	}
}
public class Baekjoon_11000_강의실배정 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Class> lectures = new ArrayList<Class>();
		for (int i = 0; i < N; i++) {
			String[] info = br.readLine().split(" ");
			lectures.add(new Class(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
			
		}
		Collections.sort(lectures, (o1,o2)-> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(lectures.get(0).end);
		
		for (int i = 1; i < N; i++) {
			if(pq.peek() <= lectures.get(i).start) {
				pq.poll();
			}
			pq.add(lectures.get(i).end);
		}
		System.out.println(pq.size());
	}

}
