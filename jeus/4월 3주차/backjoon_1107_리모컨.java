package backjoon_4월;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class backjoon_1107_리모컨 {
	static List<Integer> list = new ArrayList<>();
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int chanel = scan.nextInt(), m = scan.nextInt();
		
		while(m-- > 0) list.add(scan.nextInt());
		
		int min = Math.abs(chanel - 100);
		
		for(int i = 0; i <= 1000000; i++) {			
			
			int cnt = check(i);
      
			if(cnt > 0) min = Math.min(min, Math.abs(chanel - i) + cnt);
		}
		System.out.print(min);
	}
	
	private static int check(int num) {
		int cnt = 0;
		
		if(num == 0) return list.contains(num)? 0 : 1;
		
		while(num > 0) {
			if(list.contains(num % 10)) return 0;
			
			cnt++;
			num /= 10;
		}
		return cnt;
	}
}