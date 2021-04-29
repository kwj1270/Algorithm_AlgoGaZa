import java.util.*;
import java.lang.*;

class Solution {
	
    public String solution(String new_id) {
	    
        StringBuilder answer = new StringBuilder();
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i=0; i<new_id.length(); i++){
            list.add(new_id.toCharArray()[i]);  
        }
	    
        String tttt = "ABC";
		while(!tttt.equals(list.toString())) {
	        tttt = list.toString();
			if (!list.isEmpty()) {
				BigtoSmall(list);
				removeLetter(list);
				no2Dot(list);
	            noSEDot(list);
			}
	        if(list.isEmpty()){
	            list.add('a');
	        }
	        if(list.size()>=16){
	            left15Letters(list);
	        }
	        if(list.size()<=2){
	            repeatCopy(list);
	        }
		}
            
        
        for(int i=0; i<list.size(); i++){
            answer.append(list.get(i));
        }
        return answer.toString();
    }
    
    private static void BigtoSmall(ArrayList<Character> list) {
		for (int i = 0; i < list.size(); i++) {
			if ('A' <= list.get(i) && list.get(i) <= 'Z') {
				list.set(i, (char) (list.get(i) + 32));
			}
		}
	}

	private static void removeLetter(ArrayList<Character> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if ('a' <= list.get(i) && list.get(i) <= 'z')
				continue;
			if ('0' <= list.get(i) && list.get(i) <= '9')
				continue;
			if (list.get(i) == '-' || list.get(i) == '_' || list.get(i) == '.')
				continue;
			list.remove(i);
			i -= 1;
			size--;
		}
	}

	private static void no2Dot(ArrayList<Character> list) {
		int size = list.size();
		for (int i = 1; i < size; i++) {
			if (list.get(i) == '.' && list.get(i - 1) == '.') {
				list.set(i - 1, '%');
				
			}
		}
		removeLetter(list);
	}

	private static void noSEDot(ArrayList<Character> list){
		if(list.isEmpty()) return;
        if(list.get(0)=='.'){
            list.remove(0);
        }
        int size = list.size();
        if(size>0&&list.get(size-1)=='.'){
            list.remove(size-1);
        }
    }

	private static void left15Letters(ArrayList<Character> list) {
        int size =list.size();
        for(int i=15; i<size; i++) {
            list.remove(i);
			i-=1;
			size--;
        }
    }

	private static void repeatCopy(ArrayList<Character> list) {
        int size = list.size();
        char temp = list.get(size-1);
        while(list.size()<=2){
                list.add(temp);
        }
    }
}
