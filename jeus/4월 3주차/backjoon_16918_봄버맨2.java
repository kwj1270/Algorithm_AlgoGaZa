package backjoon_4월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_16918_봄버맨2 {

    static int R,C,N;
    static int map[][];
    static char map2[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int time=0;
    static boolean flag;
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
        map = new int [R][C];
        map2 = new char [R][C];
        for (int i = 0; i<R;i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < C; j++) {
                if(temp.charAt(j)=='O') {
                	map[i][j]=3;
                }
                
            }
        }
       
        for (int i = 1; i <N; i++) {
			clock();
			
			if(i%2==0) {
				boom();
			}
			else {
				
				setboom();
			}
		}
        for (int i = 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
				if(map[i][j]>0)
					System.out.print("O");
				else
					System.out.print(".");
			}
        	System.out.println();
		}
        System.out.println("=========================");
        for (int i = 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
        		System.out.print(map[i][j]);
			}
        	System.out.println();
		}
    }
    public static void setboom() {
    	for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==0)
					map[i][j]=3;
			}
		}
    }
    public static void clock() {
    	for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]>0) {
					map[i][j]--;
				}
				if(map[i][j]==-1) {
					map[i][j]++;
				}
			}
		}
    }
    public static void boom() {
    	Queue<int[]> que = new LinkedList<>();
    	
    	for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==0)
				{	flag =true;
					que.add(new int[] {i,j});
					map[i][j]=-1;
				}
			}
		}
    	for (int[] is : que) {
			boomArea(is[0],is[1]);
		}
    }
    public static void boomArea(int x, int y) {
    	for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=R||ny>=C) continue;
			
			map[nx][ny]=-1;
		}
    	
    }
    
}
//초기 0 , 1 , 5 ,9 , 13 ,
//다O 2,4,6,8,10,12,14,16,18,20
//3, 7 , 11  ,15