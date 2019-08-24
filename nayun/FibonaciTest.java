package Algorithm;

public class FibonaciTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println(fN(10));
	}
	
	public static int fN(int a) {
		if(a == 1) {
			return 1;
		}else if(a ==0) {
			return 0;
		}
		
		return fN(a-1) + fN(a-2);
	}	
}
