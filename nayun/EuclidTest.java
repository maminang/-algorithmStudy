package Algorithm;

public class EuclidTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 24;
		int b = 16;			
		
		System.out.println(gcd (a, b));			
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		
		int c = a % b;
		a = b;
		b = c;		
		
		return gcd(a,b);
		
	}

}
