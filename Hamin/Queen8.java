

import java.util.Arrays;

public class Queen8 {

	// 퀸을 두개 이상 다시 배치해야 될때 문제가 생김
	// queen() 조건문 배치를 바꾸면 될거 같은데
	
	public static void main(String[] args) {
		// 인덱스 = 세로, 값 = 가로
		int[] board = new int[10];
		Arrays.fill(board, -1);

		// (0,0) 부터 퀸 배치시작
		queen(board, 0, 0);
	}

	// 퀸 배치하는 메서드
	private static void queen(int[] board, int idx, int val) {
		// 수직, 대각으로 비어있는지 확인
		if (check(board, idx, val)) {

			// 비어있으면 퀸 배치하고 출력
			board[idx] = val;
			printBoard(board);

			// 밑에 층 배치 시작
			queen(board, idx + 1, 0);

		} else {
			if (val < 9) {
				// 비어 있지 않고 val이 8보다 작으면 val+1해서 재귀호출
				queen(board, idx, val + 1);
			} else {
				// val = 9 면 이번층은 다 확인해봤는데 배치가 불가능 한거니 위에층 퀸부터 다시 배치
				queen(board, idx - 1, board[idx] + 1);
			}
		}
	}

	// 퀸 배치가 가능한지 체크
	private static boolean check(int[] board, int idx, int val) {

		// 수직으로 체크
		for (int i : board) {
			if (i == val) {
				return false;
			}
		}

		// \ 대각선 체크
		int distance = 1;
		while (idx - distance > -1 && val - distance > -1) {
			if (board[idx - distance] == val - distance) {
				return false;
			}
			distance += 1;
		}

		// / 대각선 체크
		distance = 0;
		while (idx - distance > -1 && val + distance < 10) {
			if (board[idx - distance] == val + distance) {
				return false;
			}
			distance += 1;
		}
		return true;
	}

	// 보드 출력
	private static void printBoard(int[] board) {
		System.out.println();
		for (int idx = 0; idx < board.length; idx++) {
			for (int j = 0; j < 10; j++) {
				if (board[idx] == j) {
					System.out.print("■ ");
				} else {
					System.out.print("□ ");
				}
			}
			System.out.println();
		}
	}
}
