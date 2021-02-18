import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static final int N = 18;
    private static int [] guyong;
    private static int [] inyoung;
    private static int [] inyoung_s_numbers;
    private static boolean [] usedNumber;
    private static int win;
    private static int lose;

    private static int test;

    public static void main(String[] args) throws IOException {
        test = Integer.parseInt(BUFFERED_READER.readLine().trim());
        for(int t=1; t <= test; t++){
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");

            guyong = new int[9];
            inyoung = new int[9];
            inyoung_s_numbers = new int[9];
            usedNumber = new boolean[N];

            stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
            for (int i=0; i < guyong.length; i++){
                guyong[i] = Integer.parseInt(stringTokenizer.nextToken());
                usedNumber[guyong[i]-1] = true;
            }

            int index = 0;
            for (int i=0; i < N; i++){
                if(usedNumber[i]) continue;
                inyoung[index++] = i+1;
            }
            win = 0;
            lose = 0;
            permutation(0,0);

            STRING_BUILDER.append(win).append(" ");
            STRING_BUILDER.append(lose);
            System.out.println(STRING_BUILDER.toString());
        }

    }
    private static void permutation(int cnt, int flag){
        if(cnt == 9){
            int guyongPoint = 0;
            int inyoungPoint = 0;
            for(int i=0; i < 9; i++){
                if(guyong[i] > inyoung_s_numbers[i]) guyongPoint += guyong[i]+inyoung_s_numbers[i];
                else inyoungPoint += guyong[i]+inyoung_s_numbers[i];
            }
            if(guyongPoint > inyoungPoint) win++;
            if(guyongPoint < inyoungPoint) lose++;
            return;
        }
        for(int i=0; i < 9; i++){
            if((flag & (1 << i)) != 0) continue;
            inyoung_s_numbers[cnt] = inyoung[i];
            permutation(cnt+1, (flag | (1 << i)));
        }

    }

}
