import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Store {
	int x;
	int y;
	int dir; 
	
	public Store(int x, int y,int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "Store [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}
	
	
	
}

// 주사위 여러개 있음
// 붙어있는 면의 숫자가 같아야함
// 단, 1번 주사위는 내 마음대로 놓아도 된다.
// 순열이네 

// 한면의 숫자의 합이 최대가 되도록  
// 주사위는 90/180/270 돌릴수 있음 -> 그냥 4방향있다 생각
// 숫자 2개를 빼는거네
// 6C2


// 조합 2번 사용
// 나머지 숫자들에 대한
class Dice {
	private static final int diceMapping[] = {0,6,4,5,2,3,1};
	ArrayList<Integer> numbers;
	public Dice(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}	
	public int getReverseVlaue(int number) { 
		int tempIndex=0;
		for(int i=0; i < numbers.size(); i++) {
			if(number == numbers.get(i)) {
				tempIndex = diceMapping[i];
			}
		}
		return numbers.get(tempIndex);
	}
}

public class Main {
	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;
	private static int n;
	private static final int diceMapping[] = {0,6,4,5,2,3,1};

	
	private static ArrayList<Dice> dices;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(BUFFERED_READER.readLine().trim());
		dices = new ArrayList<Dice>();
		for(int i=0; i < n; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine().trim(), " ");
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(0);
			for(int j=0; j < 6; j++) {
				list.add(Integer.parseInt(stringTokenizer.nextToken()));
			}
			dices.add(new Dice(list));
		}
		
		int answer = Integer.MIN_VALUE;
		for(int i=1; i <= 6; i++) {
			int start = i;
			int sum = 0;
			for(int j=0; j < n; j++) {
				int notValue = dices.get(j).getReverseVlaue(start);
				int maxValue = Integer.MIN_VALUE;
				for(int k=1; k <= 6; k++) {
					if(k == notValue || k == start) continue;
					maxValue = Math.max(maxValue, k);
				}
				sum += maxValue;
				start = notValue;
			}
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}
	
}
