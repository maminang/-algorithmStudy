

import java.util.Scanner;

public class Fibonacci {

	// 연산결과들을 저장하는 배열
	private static int[] memo;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		// 배열 초기화
		memo = new int[n + 1];

		// 메모이제이션을 이용하면 얼마나 빨리 되는지 확인
		// n >= 40 부터 눈에 띄는 성능차가 나오기 시작함
		// n = 47 일때 time1 = 5879, time2 = 0
		long start = System.currentTimeMillis();
		System.out.println(fibonacci(n));
		long end = System.currentTimeMillis();
		System.out.println("time1 : " + (end - start));

		start = System.currentTimeMillis();
		System.out.println(fiboByMemoization(n));
		end = System.currentTimeMillis();
		System.out.println("time2 : " + (end - start));

	}

	// 간단한 재귀호출
	// 이 코드로 하면 fibo(n-1), fibo(n-2)는 이미 한 연산인데 다시 연산을 하게 됨으로 속도가 매우 느림
	public static int fibonacci(int n) {
		return n < 3 ? n : fibonacci(n - 1) + fibonacci(n - 2);
	}

	// 메모이제이션을 이용한 재귀 호출
	public static int fiboByMemoization(int n) {

		// 배열에 연산값이 없으면 값을 넣어주고 반환
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
