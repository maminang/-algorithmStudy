

import java.util.Scanner;

public class Fibonacci {

	// ���������� �����ϴ� �迭
	private static int[] memo;

	public static void main(String[] args) {
		// �Է�
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		// �迭 �ʱ�ȭ
		memo = new int[n + 1];

		// �޸������̼��� �̿��ϸ� �󸶳� ���� �Ǵ��� Ȯ��
		// n >= 40 ���� ���� ��� �������� ������ ������
		// n = 47 �϶� time1 = 5879, time2 = 0
		long start = System.currentTimeMillis();
		System.out.println(fibonacci(n));
		long end = System.currentTimeMillis();
		System.out.println("time1 : " + (end - start));

		start = System.currentTimeMillis();
		System.out.println(fiboByMemoization(n));
		end = System.currentTimeMillis();
		System.out.println("time2 : " + (end - start));

	}

	// ������ ���ȣ��
	// �� �ڵ�� �ϸ� fibo(n-1), fibo(n-2)�� �̹� �� �����ε� �ٽ� ������ �ϰ� ������ �ӵ��� �ſ� ����
	public static int fibonacci(int n) {
		return n < 3 ? n : fibonacci(n - 1) + fibonacci(n - 2);
	}

	// �޸������̼��� �̿��� ��� ȣ��
	public static int fiboByMemoization(int n) {

		// �迭�� ���갪�� ������ ���� �־��ְ� ��ȯ
		if (memo[n] == 0) {
			if (n < 3) {
				memo[n] = n;
			} else {
				memo[n] = fiboByMemoization(n - 1) + fiboByMemoization(n - 2);
			}
		}

		return memo[n];
	}

}
