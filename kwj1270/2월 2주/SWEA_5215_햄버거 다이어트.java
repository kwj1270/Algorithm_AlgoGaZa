import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 정해진 칼로리는 넘지 않으면서
// 가장 선호하는 햄버거
class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private static StringTokenizer stringTokenizer;
    private static int T;
    private static int countLimit;
    private static int calorie;
    private static  ArrayList<int[]> arrayList;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(BUFFERED_READER.readLine().trim());

        for(int t=1; t <= T; t++){
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            countLimit = Integer.parseInt(stringTokenizer.nextToken());
            calorie = Integer.parseInt(stringTokenizer.nextToken());

            arrayList = new ArrayList<>();
            for(int j=0; j < countLimit; j++){
                stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
                int mot = Integer.parseInt(stringTokenizer.nextToken());
                int cal = Integer.parseInt(stringTokenizer.nextToken());
                arrayList.add(new int[]{mot, cal});
            }

            STRING_BUILDER.append(go(0, 0, 0));

            System.out.println(STRING_BUILDER.toString());
        }

    }

    public static int go( int index, int nujeokMot, int nujeokCal){
        if(nujeokCal >= calorie){
            return 0;
        }
        if(index >= countLimit) {
            return nujeokMot;
        }
        int answer = 0;
        answer = Math.max(answer, go(index+1, nujeokMot+arrayList.get(index)[0], nujeokCal+arrayList.get(index)[1]));
        answer = Math.max(answer, go(index+1, nujeokMot, nujeokCal));
        return answer;
    }

}
