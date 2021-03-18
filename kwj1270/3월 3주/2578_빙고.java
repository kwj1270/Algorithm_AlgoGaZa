import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

// 간선 서로 연결 안됨
// 최대한 많은 코어 연결했을시, `전선 길이 합`
// 단 여러 방법이 있을 경우 전선 길이 최소가 되는 값 구하기
// 부분집합 문제, 가장 자리는 이미 전원이 연결도니 것으로 간주

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static int[][] map; 
	private static boolean[][] copy; 
	
	private static Point[] indexMapping;
	
	public static void main(String[] args) throws IOException {
		map = new int[5][5];
		copy = new boolean[5][5];

		indexMapping = new Point[26];
		
		for(int i=0; i < 5; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for(int j=0; j < 5; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				indexMapping[map[i][j]] = new Point(i, j);
			}	
		}
		
		
		int index = 1;
		for(int i=0; i < 5; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for(int j=0; j < 5; j++) {
				int count = Integer.parseInt(stringTokenizer.nextToken());
				Point p = indexMapping[count];
				copy[p.x][p.y] = true;
				if(bingo()) {
					System.out.println(index);
					return;
				}
				index++;
			}	
		}
	}
	
	private static boolean bingo() {
		boolean flag = false;
		
		int count = 0;
		for(int j=0; j < 5; j++) {
			int temp = 0;
			for(int i=0; i < 5; i++) {
				if(copy[i][j]) temp++;
			}	
			if(temp == 5) count++;
		}
		
		for(int i=0; i < 5; i++) {
			int temp = 0;
			for(int j=0; j < 5; j++) {
				if(copy[i][j]) temp++;
			}	
			if(temp == 5) count++;
		}
		
		int temp = 0;
		for(int i=0, j=0; i < 5; i++, j++) {
			if(copy[i][j]) temp++;
		}
		if(temp == 5) count++;
		
		temp = 0;
		for(int i=0, j=4; i < 5; i++, j--) {
			if(copy[i][j]) temp++;
		}
		if(temp == 5) count++;
		if(count >= 3) {
			//print();
			flag=true;
		}
		return flag;
	}
	
	/*
	private static void print() {
		System.out.println();
		for(int i=0; i < 5; i++) {
			for(int j=0; j < 5; j++) {
				System.out.print(copy[i][j]);
			} 	
			System.out.println("");
		}
	}
	 */
}
