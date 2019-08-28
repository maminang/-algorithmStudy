

import java.util.Scanner;

// ���� 1914��
// �ð��ʰ� �� ���°ɰ�...
public class Hanoi {

	// n < 20 �����϶� ����ϰ� ù n���� ������
	static int firstN;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		// ��� ȣ��
		firstN = n;
		hanoi(n, 1, 2, 3);

		// �̵�Ƚ��
		// �ϳ����� ž �̵�Ƚ�� ��ȭ�� = 2^n-1
		System.out.println((int) Math.pow(2, n) - 1);
	}

	public static void move(int from, int to) {
		if (firstN < 20) {
			System.out.println(from + " " + to);
		}
	}

	// n = �Űܾ� �Ǵ� ���ݼ�
	// from = ������ �ű� ���
	// by = ���ݵ��� ���İ� ���
	// to = ������ �Ű��� ���
	public static void hanoi(int n, int from, int by, int to) {

		// ������ ���̴ٰ� �Űܾ� �� ����� �ϳ��� ��� Ż���ϰ� ���� ó��
		if (n == 1) {
			move(from, to);
		} else {

			// from��տ��� to������� �ű�� ���� n-1���� ������ by��տ� �ű�
			hanoi(n - 1, from, to, by);
			
			// �� �Ű����� from��� �� �ؿ� ����ִ� n��° ������ to�� �ű��
			move(from, to);
			
			// by�� �׿��ִ� n-1���� ������ to�� �ű�� ��
			hanoi(n - 1, by, from, to);
		}
	}
}
