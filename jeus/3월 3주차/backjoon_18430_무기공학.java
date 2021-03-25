package com.study32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_18430_무기공학 {
	static int N,M,max;
	static int map[][];
	static boolean isSelected[][];
	public static boolean check(int x, int y, int dir)
	{	
//		int nx = x+1;
//		int ny = y+1;
//	    if (nx >= N || ny >= M) {
//	        return false;
//	    }
//	    switch(dir) {
//	    case 0: if (isSelected[x][y] || isSelected[x][y+1] || isSelected[x+1][y]) 
//    				return false;
//	    
//	    case 1: if (isSelected[x][y] || isSelected[x][y+1] || isSelected[x+1][y+1])
//	    			return false;
//	    case 2: if (isSelected[x][y] || isSelected[x+1][y] || isSelected[x+1][y+1]) 
//            		return false;
//	    case 3:if (isSelected[x][y+1] || isSelected[x+1][y+1] || isSelected[x+1][y])
//            		return false;
//	    
//	    
//	
//	    }
//	 
//	    return true;
		
		    if (x == N- 1 || y == M - 1) {
		        return false;
		    }
		 
		    if (dir == 0) {
		        if (isSelected[x][y] || isSelected[x][y+1] || isSelected[x+1][y+1]) {
		            return false;
		        }
		    }
		    else if (dir == 1) {
		        if (isSelected[x][y+1] || isSelected[x+1][y+1] || isSelected[x+ 1][y]) {
		            return false;
		        }
		    }
		    else if (dir == 2) {
		        if (isSelected[x][y] || isSelected[x+ 1][y]|| isSelected[x+1][y+1]) {
		            return false;
		        }
		    }
		    else if (dir == 3) {
		        if (isSelected[x][y] || isSelected[x][y+1] || isSelected[x+ 1][y]) {
		            return false;
		        }
		    }
		 
		    return true;
		
	}
	public static void search(int x, int y,int Sum) {
		int cnt=0;
		if(N==1||M==1)
		{
			max=0;
			return;
		}
		if(y==M) {
			x++;
			y=0;
		}
		
		if(x==N) {
			max = Math.max(max, Sum);
			return;
		}
		
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 2; j++) {
//				if(isSelected[x+i][y+j]) {
//					cnt++;
//				}
//				if(cnt>=2) {
//					return;
//				}
//			}
//		}
		for (int i = 0; i < 4; i++) {
			
			if(!check(x,y,i)) continue;
			
			state(x,y,i,true);
			
			int temp = sum(x,y,i);
			
			search(x,y+1,Sum+temp);
			
			state(x,y,i,false);
			
		}
		
		
		search(x,y+1,Sum);
		
	}
	public static int sum(int x,int y,int dir) {
//			int nx = x+1;
//			int ny = y+1;
		   switch(dir) {
		    case 3: 	return map[x][y]*2   + map[x][y+1]+ map[x+1][y];
		    case 1: 	return  map[x][y+1]*2  + map[x][y]+ map[x+1][y+1];
		    case 2: 	return map[x+1][y]*2  + map[x][y]+ map[x+1][y+1];		
		    case 0:		return map[x+1][y+1]*2  + map[x][y+1]+ map[x+1][y];
		    }
		  
		   return 0;
	}
	public static void state(int x,int y,int dir,boolean a) {
		int nx = x+1;
		int ny = y+1;
	   switch(dir) {
	    case 3: isSelected[x][y]=isSelected[x][y+1]=isSelected[x+1][y] =a;
	    	break;
	    case 1: isSelected[x][y+1]=isSelected[x][y]=isSelected[x+1][y+1]=a;
	    	break;
	    case 2: isSelected[x+1][y]=isSelected[x][y]=isSelected[x+1][y+1]=a;	
	    	break;
	    case 0: isSelected[x+1][y+1]=isSelected[x][y+1]=isSelected[x+1][y]=a;
	    	break;
	    
	
	    }
	   return;
	
}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		isSelected= new boolean[N][M];
		max =-30;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		search(0,0,0);
		System.out.println(max);
		}
	

}
