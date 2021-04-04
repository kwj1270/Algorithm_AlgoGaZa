import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

class Class implements Comparable<Class> {
	int start;
	int end;

	public Class(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Class o) {
		int result = this.start - o.start;
		if (result == 0)
			result = this.end - o.end;
		return result;
	}

	@Override
	public String toString() {
		return "Class [start=" + start + ", end=" + end + "]";
	}
	

}
public class Solution {
	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;
	private static PriorityQueue<Integer> q;
	private static int n;
	private static Class[] array;

	private static int test;

	public static void main(String[] args) throws IOException {
		test = Integer.parseInt(BUFFERED_READER.readLine().trim());
		for (int t = 1; t <= test; t++) {
			STRING_BUILDER.setLength(0);
			STRING_BUILDER.append("#").append(t).append(" ");
			
			n = Integer.parseInt(BUFFERED_READER.readLine().trim());
			array = new Class[n];
			q = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
				int x = Integer.parseInt(stringTokenizer.nextToken());
				int y = Integer.parseInt(stringTokenizer.nextToken());
				
						
				if(y < x) {
					int temp = x;
					x = y;
					y = temp;
				}
				
				x = (x+1)/2;
				y = (y+1)/2;
						

				array[i] = new Class(x, y);
			}

			Arrays.sort(array);
			q.offer(array[0].end);
			for (int i = 1; i < n; i++) {
				if(array[i].start > q.peek()) {
					q.poll();
				}
				q.offer(array[i].end);
			}
			STRING_BUILDER.append(q.size());
			System.out.println(STRING_BUILDER.toString());
		}
	}

}
