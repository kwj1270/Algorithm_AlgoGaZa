import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
     
    private static int[] parents;
     
    private static int test;
    private static int n;
    private static int m;
     
     
    public static void main(String[] args) throws Exception {
        test = Integer.parseInt(BUFFERED_READER.readLine());
         
        for(int t=1; t <= test; t++) {
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
             
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
             
            parents = new int[n+1];
            makeParents();
             
            for(int i=0; i < m; i++) {
                stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
                int command = Integer.parseInt(stringTokenizer.nextToken());
                int standard = Integer.parseInt(stringTokenizer.nextToken());
                int target = Integer.parseInt(stringTokenizer.nextToken());     
                 
                switch (command) {
                case 0:
                    union(standard, target);
                    break;
                case 1:
                    if(findSet(standard) == findSet(target)) STRING_BUILDER.append(1);
                    else STRING_BUILDER.append(0);
                    break;
                default:
                    break;
                }
            }
             
            System.out.println(STRING_BUILDER.toString());
        }
         
    }
     
    private static void makeParents() {
        for(int i=1; i <= n; i++) {
            parents[i] = i;
        }
    }
     
    private static int findSet(int target) {
        if(parents[target] == target) return target;
        return parents[target] = findSet(parents[target]);
    }
     
    private static boolean union(int standard, int target) {
        int standardRoot = findSet(standard);
        int targetRoot = findSet(target);
         
        if(standardRoot == targetRoot) {return false;}
        parents[targetRoot] = standardRoot;
        return true;
    }
     
     
}
