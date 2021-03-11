package com.java.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 일반 정렬(추천횟수, time) -> 추천횟수 같으면 time 큰 순으로 정렬
 * 우선순위큐 -> 추천횟수 오름차순 -> if 추천횟수가 같으면 시간 오름차순
 * 
 * */
class Candidate {
	int num; //번호
	int like; //추천횟수
	int order;
	public Candidate(int num, int like, int order){
		this.num = num;
		this.like = like;
		this.order = order;
	}
}

public class Baekjoon_1713_후보추천하기 {
	static int N;
	static int K;
	static PriorityQueue<Candidate> pq;
	static List<Integer> students;
	static ArrayList<Candidate> result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 사진틀개수
		K = Integer.parseInt(br.readLine()); // 전체 학생 총 추천횟수
		
		students = new ArrayList<Integer>();
		result = new ArrayList<Candidate>(); // 출력 리스트

		pq = new PriorityQueue<Candidate>(new Comparator<Candidate>() {
			@Override
			public int compare(Candidate o1, Candidate o2) {
				if(o1.like == o2.like) {
					return o1.order - o2.order;
				}
				else {
					return o1.like - o2.like;
				}
			}
			
		});
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			students.add(Integer.parseInt(st.nextToken()));
		}
//		for (int i = 0; i < K; i++) {
//			//사진틀 꽉찼을때
//			if(result.size() >= 3) {
//				//추천횟수 모두 똑같으면 가장 오래된것 삭제
//			}
//			pq.add(new Candidate(students.get(i), 1, order))
//		}
		
		
	}

	

}
