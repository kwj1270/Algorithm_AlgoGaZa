import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	// 입출력
	private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static int n;
	private static int x;
	private static List<Integer> arr= new ArrayList<>(); 

	
	public static void main(String[] args) throws NumberFormatException, IOException {

			n = Integer.valueOf(READER.readLine());
			stringTokenizer = new StringTokenizer(READER.readLine(), " ");
			for(int i=0; i < n; i++) {
				arr.add(Integer.valueOf(stringTokenizer.nextToken()));
			}
			x = Integer.valueOf(READER.readLine());
			
			Collections.sort(arr);
			int left = 0;
			int right = arr.size()-1;
			int answer = 0;
			while (left < right) {
				int currentResult = Math.addExact(arr.get(left), arr.get(right));
				if(currentResult == x) {
					left++;
					right--;
					answer++;
					continue;
				}
				if(currentResult > x) {
					right--;
					continue;
				}
				if(currentResult < x) {
					left++;
					continue;
				}

			}
			System.out.println(answer);
			
	}


}
