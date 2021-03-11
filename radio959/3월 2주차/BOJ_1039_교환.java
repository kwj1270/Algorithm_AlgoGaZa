package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1039_교환 {

	static char[] temp; // 원래의 수를 char 배열로
	static char[] temp1; // 원래의 수를 큰 순서대로 나열한 char 배열
	static int[] temp2; // 원래의 수를 큰 순서대로 나열한 int 배열
	static int[] original; // 원래의 수 int 배열
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		temp = st.nextToken().toCharArray();
		temp1 = Arrays.copyOf(temp, temp.length);
		cnt = Integer.parseInt(st.nextToken());

		Arrays.sort(temp1);
		temp2 = new int[temp1.length];
		original = new int[temp1.length];

		for (int i = 0; i < temp1.length; i++) {
			original[i] = temp[i] - '0';
			temp2[temp1.length - 1 - i] = temp1[i] - '0';
		}

		/*
		 * for(int i=0; i<original.length; i++) { System.out.print(temp[i]);
		 * }System.out.println(); for(int i=0; i<original.length; i++) {
		 * System.out.print(temp1[i]); }System.out.println(); for(int i=0;
		 * i<original.length; i++) { System.out.print(temp2[i]); }System.out.println();
		 * for(int i=0; i<original.length; i++) { System.out.print(original[i]);
		 * }System.out.println();
		 */

		if (original.length == 1) {
			System.out.println(original[0]);
			return;
		}

		if (original.length == 2) {
			for (int i = 0; i < cnt; i++) {
				swap2(original[0], original[1]);
				if (original[0] == 0)
					swap2(original[0], original[1]);
			}
			System.out.print(original[0]);
			System.out.print(original[1]);
			return;
		}

		int a = 0, b=0;
		for (int i = 0; i < cnt; i++) {
			if (Arrays.equals(temp2, original)) {
				if((cnt-i)%2==1) {
					swap2(original.length - 2, original.length - 1);
					break;
				}
				break;
			}
			swap(a, temp2[b]);
			a++;
			b++;
		}
		for (int i = 0; i < original.length; i++) {
			System.out.print(original[i]);
		}

	}

	public static void swap(int a, int b) {
		int temp = -1;
		for (int i = 0; i < original.length; i++) {
			if (original[i] == b) {
				temp = i;
				break;
			}
		}
		int t = original[a];
		original[a] = original[temp];
		original[temp] = t;
	}

	public static void swap2(int a, int b) {
		int temp;
		temp = original[a];
		original[a] = original[b];
		original[b] = temp;
	}
}
