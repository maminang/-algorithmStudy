

import java.util.Scanner;

public class Euclid {
	public static void main(String[] args) {
		// �Է�
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();

		// ���
		System.out.println(gcd(a, b));
		System.out.println(lcd(a, b));
	}

	// �ִ����� = gcd
	private static int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	// �ּҰ���� = lcd
	private static int lcd(int a, int b) {
		// �ִ������� �ִ������� ���踦 �̿�
		// �� ������ �� = �ִ����� * �ּҰ����
		// �ּҰ���� = ������ �� / �ִ�����
		return a * b / gcd(a, b);
	}
}
