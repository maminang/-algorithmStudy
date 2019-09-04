import java.util.Arrays;
import java.util.Scanner;

public class N_Queen { // backjoon 9663

	static int[] board; // idx = ������ , value = ����ĭ
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

	public static void queen(int idx) { // idx ���� ���� ��ġ�ϴ� �޼���
		
		if (idx == n) { // idx==n �̸� n���� ���� �� ��ġ�ѰŴ� cnt����
			cnt++;
		} else {
			for (int i = 0; i < n; i++) {
				if (check(idx, i)) {
					
					board[idx] = i;
					queen(idx + 1);
					
					board[idx] = -1; // ��ġ�ߴ� ���� �ٽ� ȸ�� (ȸ���� �� �ϸ� �����ִ� ���� ������ �༭ ����� ���� �� �� ã��)
				}
			}
		}
	}

	public static boolean check(int idx, int val) {
		for (int i = 0; i <= idx; i++) {
			if (board[i] == val) // ����
				return false;
			else if (idx - i > -1) {
				if (board[idx - i] == val - i) // \���� �밢��
					return false;
				else if (board[idx - i] == val + i) // /���� �밢��
					return false;
			}
		}
		return true;
	}
}
