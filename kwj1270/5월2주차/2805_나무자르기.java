import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 입출력
	private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static int n;
	private static long m;
	private static LinkedList<Long> namus = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		stringTokenizer = new StringTokenizer(READER.readLine(), " ");
		n = Integer.valueOf(stringTokenizer.nextToken());
		m = Integer.valueOf(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(READER.readLine(), " ");
		for (int i = 0; i < n; i++) {
			namus.add(Long.valueOf(stringTokenizer.nextToken()));
		}
		// 나무의 높이를 기준점으로 잡자
		Collections.sort(namus);
		
		long answer = 0;
		long left = 0;
		long right = namus.getLast();
		while (left <= right) {
			long mid = (left+right)/2;
			long result = binarySearch(mid);
			if(result < m) {
				right = mid-1;
				continue;
			}
			answer = mid;
			left = mid+1;
		}
		System.out.println(answer);
	}

	private static long binarySearch(long mid) {
		return namus.stream()
			.filter(size -> size > mid)
			.mapToLong(size -> size - mid)
			.sum();
	}

}
