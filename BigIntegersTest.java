package week4;

public class BigIntegersTest {

	public static void main(String[] args) {
		Large_Integer n1 = new Large_Integer("111111111111111111111");
		Large_Integer n2 = new Large_Integer("-444444444444444444444");
	
		Large_Integer_calculate cal = new Large_Integer_calculate();
		
		System.out.println(n1);
		System.out.println(n2);

		System.out.println(cal.TenPowMumtiply(n1, 1));
		System.out.println(cal.TenPowMDivide(n1, 2));
		System.out.println(cal.TenPowMRemainder(n1, 3));
		
	}

}
