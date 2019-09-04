import java.util.Arrays;
import java.util.Scanner;

public class N_Queen { // backjoon 9663

	static int[] board; // idx = 세로층 , value = 가로칸
	static int n;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();

		board = new int[n];
		Arrays.fill(board, -1);

		queen(0);
		System.out.println(cnt);
	}

	public static void queen(int idx) { // idx 층에 퀸을 배치하는 메서드
		
		if (idx == n) { // idx==n 이면 n개의 퀸을 다 배치한거니 cnt증가
			cnt++;
		} else {
			for (int i = 0; i < n; i++) {
				if (check(idx, i)) {
					
					board[idx] = i;
					queen(idx + 1);
					
					board[idx] = -1; // 배치했던 퀸을 다시 회수 (회수를 안 하면 남아있던 퀸이 영향을 줘서 경우의 수를 다 못 찾음)
				}
			}
		}
	}

	public static boolean check(int idx, int val) {
		for (int i = 0; i <= idx; i++) {
			if (board[i] == val) // 수직
				return false;
			else if (idx - i > -1) {
				if (board[idx - i] == val - i) // \방향 대각선
					return false;
				else if (board[idx - i] == val + i) // /방향 대각선
					return false;
			}
		}
		return true;
	}
}
