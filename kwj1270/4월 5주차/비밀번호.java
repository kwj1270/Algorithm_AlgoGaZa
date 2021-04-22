	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
 
public class Solution {
 
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;
     
    private static int TEST = 10;
     
    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= TEST; t++) {
            stringBuilder.setLength(0);
            stringBuilder.append("#").append(t).append(" ");
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            stringTokenizer.nextToken();
            char[] data = stringTokenizer.nextToken().toCharArray();
            Stack<Character> stack = new Stack<>();
            for(int i=0; i < data.length; i++) {
                if(stack.empty()) { stack.push(data[i]);continue; }
                if(stack.peek() == data[i]) { stack.pop(); continue;}
                stack.push(data[i]);
            }
            String answer = stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(""));
            stringBuilder.append(answer);
            System.out.println(stringBuilder);
        }
 
    }
 
 
}
