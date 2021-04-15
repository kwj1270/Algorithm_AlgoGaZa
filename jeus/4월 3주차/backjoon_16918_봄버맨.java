package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_16918_봄버맨 {

    static int R,C,N;
    static char map[][];
    static char map2[][];
    static int dx[] = {0,-1,1,0,0};
    static int dy[] = {0,0,0,-1,1};
    static int time=0;
    static Queue <boom> booms = new LinkedList<>();
    static class boom{
        int x,y,time;
        boom(int x,int y, int time)
        {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char [R][C];
        map2 = new char [R][C];
        for (int i = 0; i<R;i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
            for (int j = 0; j < C; j++) {
                map2[i][j] = 'O';
                if (map[i][j] == 'O') {
                    booms.add(new boom(i, j, 0));
                }
            }
        }
        fire();
        if(N%2==0||N%5==0){
            print_map(1);
            return;
        }
        else if(N%4==3){
           print_map(3);
           // System.out.println(3);
            return;
        }
        else {
            print_map(2);
        }






    }
    public static void fire(){

        while(!booms.isEmpty()){
            boom current = booms.poll();
            //System.out.println(1);
            for(int i =0; i<=4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
//                System.out.println(nx);
//                System.out.println(ny);
                if(nx<0||ny<0||nx>=R||ny>=C) continue;

                map2[nx][ny]='.';



            }

        }
    }
    public static void print_map(int flag){
        if(flag==1){
            for (int i = 0; i<R;i++){
                for (int j = 0; j<C;j++){
                    System.out.print('O');
                }
                System.out.println();
            }
        }
        if(flag==2){
            for (int i = 0; i<R;i++){
                for (int j = 0; j<C;j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

        }
        if(flag==3){
            for (int i = 0; i<R;i++){
                for (int j = 0; j<C;j++){
                    System.out.print(map2[i][j]);
                }
                System.out.println();
            }

        }

    }

}
//초기 0 , 1 , 5 ,9 , 13 ,
//다O 2,4,6,8,10,12,14,16,18,20
//3, 7 , 11  ,15