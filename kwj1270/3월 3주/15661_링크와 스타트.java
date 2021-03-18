import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


class Person {
	int id;

	public Person(int id) {
		this.id = id;
	}
	
}
public class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	private static int n;
	private static int [][] map;
	private static ArrayList<Person> teamOne;
	private static ArrayList<Person> teamTwo;
	
	public static void main(String[] args) throws IOException {

		n = parseInt(BUFFERED_READER.readLine());
		map = new int[n][n];
		teamOne = new ArrayList<Person>();
		teamTwo = new ArrayList<Person>();
		
		for(int i=0; i < n; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for(int j=0; j < n; j++) {
				map[i][j] = parseInt(stringTokenizer.nextToken());
			}
		}

		System.out.println(go(0));

	}
	
	private static int go(int index) {
		if(index == n) {
			int answer = Integer.MAX_VALUE;
			if(teamOne.size() < 1) return answer;
			if(teamTwo.size() < 1) return answer;
			
			int teamOneVlaue=0;
			int teamTwoVlaue=0;

			for(int i=0; i < teamOne.size(); i++) {
				for(int j=0; j < teamOne.size(); j++) {
					if(i == j) continue;
					teamOneVlaue += map[teamOne.get(i).id][teamOne.get(j).id];
				}	
			}
			
			for(int i=0; i < teamTwo.size(); i++) {
				for(int j=0; j < teamTwo.size(); j++) {
					if(i == j) continue;
					teamTwoVlaue += map[teamTwo.get(i).id][teamTwo.get(j).id];
				}	
			}
			
			answer = Math.abs(teamOneVlaue - teamTwoVlaue);
			return answer;
		}
		
		int result = Integer.MAX_VALUE;
		Person now = new Person(index);
		
		teamOne.add(now);
		result= Math.min(result, go(index+1));
		teamOne.remove(now);

		teamTwo.add(now);
		result= Math.min(result, go(index+1));
		teamTwo.remove(now);
		

		return result;
	}
	
}
