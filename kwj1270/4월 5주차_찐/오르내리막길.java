import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 토끼의 높낮이 가능보 클래스
class Rabbit {
	int up;
	int down;
	
	public Rabbit(int up, int down) {
		this.up = up;
		this.down = down;
	}
	
}

public class Algo1_광주_4반_김우재 {
	private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;
	
	private static int test;
	private static int[] roads;
	private static int answer;

	private static ArrayList<Rabbit> rabbits;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 테스트 케이스 수 입력
		test = Integer.valueOf(READER.readLine().trim());
		
		for(int t=1; t <= test; t++) {
			BUILDER.setLength(0);
			BUILDER.append("#").append(t).append(" ");
			
			// 오르내리막길 정보를 위한 배열
			roads = new int[10];
			// 토끼를 저장하기 위한 리스트 
			rabbits = new ArrayList<>();
			
			// 오르내리막길 값 할당
			stringTokenizer = new StringTokenizer(READER.readLine(), " ");
			for(int i=0; i < 10; i++) {
				roads[i] = Integer.valueOf(stringTokenizer.nextToken());
			}
			
			// 토끼 5마리의 정보를 입력후 리스트에 넣는다.
			for(int i=0; i < 5; i++) {
				stringTokenizer = new StringTokenizer(READER.readLine(), " ");
				int up = Integer.valueOf(stringTokenizer.nextToken());
				int down = Integer.valueOf(stringTokenizer.nextToken());
				Rabbit rabbit = new Rabbit(up, down);
				rabbits.add(rabbit);
			}
			
			// 시작 결과값은 0
			answer = 0;
			// 각각의 토끼들에 대해서 정보 얻기
			for (Rabbit rabbit : rabbits) {
				answer += dfs(rabbit, 0);
			}
			// 빌더에 추가하고 출력
			BUILDER.append(answer);
			System.out.println(BUILDER);
		}
		
	}

	// 도착하는 경우의 수를 알기위한 dfs
	private static int dfs(Rabbit rabbit, int index) {
		if(index == 9) {
			return 1; // 한번이라도 도착하면 1리턴
		}
		// 오르막길 가능하면 경우의 수 증가 
		if(roads[index] <= roads[index+1] && roads[index]+rabbit.up >= roads[index+1]) {
			return dfs(rabbit, index+1); // 마지막에 도착하지 못했다면 0리턴될것, 도착했다면 1리턴 
		}
		// 내리막길 가능하면 경우의 수 증가
		if(roads[index] >= roads[index+1] && roads[index]-rabbit.down <= roads[index+1]) {
			return dfs(rabbit, index+1);// 마지막에 도착하지 못했다면 0리턴될것, 도착했다면 1리턴 	
		}
		// 못갔다면 0 리턴
		return 0;
	}
}





