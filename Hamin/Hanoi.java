

import java.util.Scanner;

// 백준 1914번
// 시간초과 왜 나는걸가...
public class Hanoi {

	// n < 20 이하일때 출력하게 첫 n값을 저장함
	static int firstN;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		// 재귀 호출
		firstN = n;
		hanoi(n, 1, 2, 3);

		// 이동횟수
		// 하노이의 탑 이동횟수 점화식 = 2^n-1
		System.out.println((int) Math.pow(2, n) - 1);
	}

	public static void move(int from, int to) {
		if (firstN < 20) {
			System.out.println(from + " " + to);
		}
	}

	// n = 옮겨야 되는 원반수
	// from = 원반을 옮길 기둥
	// by = 원반들이 거쳐갈 기둥
	// to = 원반이 옮겨질 기둥
	public static void hanoi(int n, int from, int by, int to) {

		// 스택이 쌓이다가 옮겨야 될 기둥이 하나면 재귀 탈출하고 스택 처리
		if (n == 1) {
			move(from, to);
		} else {

			// from기둥에서 to기둥으로 옮기기 전에 n-1개의 원반을 by기둥에 옮김
			hanoi(n - 1, from, to, by);
			
			// 다 옮겼으면 from기둥 맨 밑에 깔려있던 n번째 원반을 to로 옮기고
			move(from, to);
			
			// by에 쌓여있는 n-1개의 원반을 to로 옮기면 끝
			hanoi(n - 1, by, from, to);
		}
	}
}
