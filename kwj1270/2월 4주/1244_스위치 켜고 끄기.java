import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static int n;
    private static int m;
    
    private static ArrayList<Boolean> lamps;
    private static List<Integer> answers;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	n = Integer.parseInt(BUFFERED_READER.readLine().trim());
    	lamps = new ArrayList<Boolean>();
    	stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
    	
    	lamps.add(false);
    	for(int i=0; i < n; i++) {
    		lamps.add(Integer.parseInt(stringTokenizer.nextToken()) == 1 ? true : false);
    	}
    	// lamps.stream().forEach(System.out::println);
    	
    	m = Integer.parseInt(BUFFERED_READER.readLine().trim());
    	for(int i=0; i < m; i++) {
    		stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
    		int gender = Integer.parseInt(stringTokenizer.nextToken());
    		int value = Integer.parseInt(stringTokenizer.nextToken());
    		if(gender == 1) boy(value);
    		if(gender == 2) {
    			lamps.set(value, !lamps.get(value));
    			girl(value-1, value+1);
    		} 
    	}
    	lamps.remove(0);
    	answers = lamps.stream().map(bo -> {
    		if(bo.booleanValue()) return new Integer(1);
    		return new Integer(0);
    	}).collect(Collectors.toList());
    	for(int i=1; i <= answers.size(); i++) {
    		STRING_BUILDER.append(answers.get(i-1)).append(" ");
    		if((i % 20) == 0) STRING_BUILDER.append("\n");
    	}
    	System.out.println(STRING_BUILDER.toString());
    }

	private static void boy(int value) {
		int index = value;
		int cnt = 1;
		while (index < lamps.size()) {
			lamps.set(index, !(lamps.get(index)));
			cnt++;
			index = value * cnt;
		}	
	}
	
	private static void girl(int left, int right) {
		if(left <= 0 || right >= lamps.size()) {
			return;
		}
		if(lamps.get(left) != lamps.get(right)) return;
		lamps.set(left, !lamps.get(left));
		lamps.set(right, !lamps.get(right));
		girl(left-1, right+1);
	}
}
