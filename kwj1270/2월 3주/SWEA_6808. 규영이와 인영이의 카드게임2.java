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
    private static boolean [] usedNumber;

    private static int test;

    public static void main(String[] args) throws IOException {
        test = Integer.parseInt(BUFFERED_READER.readLine().trim());
        for(int t=1; t <= test; t++){
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");

            guyong = new int[9];
            inyoung = new int[9];
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

            int win = 0;
            int lose = 0;
            do {
                int guyongPoint = 0;
                int inyoungPoint = 0;
                for(int i=0; i < 9; i++){
                    if(guyong[i] > inyoung[i]) guyongPoint += guyong[i]+inyoung[i];
                    else inyoungPoint += guyong[i]+inyoung[i];
                }
                if(guyongPoint > inyoungPoint) win++;
                if(guyongPoint < inyoungPoint) lose++;
            } while (nextPermutation());

            STRING_BUILDER.append(win).append(" ");
            STRING_BUILDER.append(lose);
            System.out.println(STRING_BUILDER.toString());
        }

    }

    private static boolean nextPermutation() {
        int i = inyoung.length - 1;
        int j = inyoung.length - 1;
        int k = inyoung.length - 1;

        while(i > 0 && inyoung[i-1] >= inyoung[i]) --i;
        if(i <= 0) return false;

        while(inyoung[i-1] >= inyoung[j]) --j;

        swap(i-1, j);

        while ( i < k){
            swap(i++,k--);
        }

        return true;
    }

    public static void swap(int i, int j){
        int temp = inyoung[i];
        inyoung[i] = inyoung[j];
        inyoung[j] = temp;
    }
}
