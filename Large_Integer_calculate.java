package week4;

public class Large_Integer_calculate extends Large_Integer{

	public Large_Integer add(Large_Integer n1, Large_Integer n2) {
		Large_Integer result = new Large_Integer();
	}

	public Large_Integer substract(Large_Integer n1, Large_Integer n2) {


	}

	public Large_Integer multiply(Large_Integer n1, Large_Integer n2) {


	}

	public Large_Integer TenPowMumtiply(Large_Integer n, int m) {

		if(m==0)
			return n;
		else if(m<0)
			return TenPowMDivide(n, m);
		else {
			int start=1;
			Large_Integer result = new Large_Integer(n.toString());

			for(int i = 1; i<result.size; i++) {
				if(result.num[i]!=0) {
					start=i;
					break;
				}
			}
			int nLength = result.size-start;
			if(nLength+m>=size) {
				result.arrSizeUp(nLength+m);
				for(int i = 1; i<result.size; i++) {
					if(result.num[i]!=0) {
						start=i;
						break;
					}
				}
			}

			for(int i = start; i<result.size; i++) {
				result.num[i-m]=result.num[i];
				result.num[i]=0;
			}
			
			return result;
		}
	}

	public Large_Integer TenPowMDivide(Large_Integer n, int m) {

		if(m<=0)
			return n;
		
		Large_Integer result = new Large_Integer(n.toString());
	
		int start=1;
		
		for(int i = 1; i<result.size; i++) {
			if(result.num[i]!=0) {
				start=i;
				break;
			}
		}

		int nLength = result.size-start;

		for(int i = 0; i<nLength; i++) {
			result.num[result.size-1-i]=result.num[result.size-1-i-m];
			result.num[result.size-1-m-i]=0;
		}

		return result;
	}

	public Large_Integer TenPowMRemainder(Large_Integer n, int m) {
		if(m<=0)
			return n;
		
		Large_Integer result = new Large_Integer(n.toString());
		
		int start=1;
		
		for(int i = 1; i<result.size; i++) {
			if(result.num[i]!=0) {
				start=i;
				break;
			}
		}

		for(int i = result.size-1-m; i>=start; i--) {
			result.num[i]=0;
		}

		return result;
	}
}
