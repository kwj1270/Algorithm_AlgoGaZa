package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import com.ssafy.greedy.MeetingRoomTest.MeetingRoom;

public class No_11000_강의실배정 {

	static class MeetingRoom implements Comparable<MeetingRoom> {
		int start, end;

		public MeetingRoom(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(MeetingRoom o) {
			int diff = this.end - o.end;
			return diff != 0 ? diff : this.start - o.start;
		}
		@Override
		public String toString() {
			return "MeetingRoom [start=" + start + ", end=" + end + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		MeetingRoom[] m = new MeetingRoom[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			m[i] = new MeetingRoom(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		List<MeetingRoom> list = getSchedule(m);
		System.out.println(list.size());
	}
	public static List<MeetingRoom> getSchedule(MeetingRoom[] m) {
		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>();

		// 한번 정렬해서 받음.
		Arrays.sort(m);
		list.add(m[0]); // 첫 회의는 무조건 배정
		for (int i = 1, size = m.length; i < size; i++) {
			// 리스트에 담긴 마지막 요소의 종료시간이 m의 시작시간보다 작거나 같다. (=겹치지 않는다면)
			if(list.get(list.size()-1).end<=m[i].start) { 
				list.add(m[i]); // 리스트에 m[i]번째 회의를 넣는다.
			}
		}
		return list;
	}

}
