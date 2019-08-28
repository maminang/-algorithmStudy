

import java.util.Scanner;

public class Euclid {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();

		// 출력
		System.out.println(gcd(a, b));
		System.out.println(lcd(a, b));
	}

	// 최대공약수 = gcd
	private static int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	// 최소공배수 = lcd
	private static int lcd(int a, int b) {
		// 최대공약수와 최대공배수의 관계를 이용
		// 두 정수의 곱 = 최대공약수 * 최소공배수
		// 최소공배수 = 정수의 곱 / 최대공약수
		return a * b / gcd(a, b);
	}
}
