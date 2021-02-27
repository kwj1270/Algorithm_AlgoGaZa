package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
	}

}
