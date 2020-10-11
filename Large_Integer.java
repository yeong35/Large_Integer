package week4;

public class Large_Integer{

	protected int size;
	protected int[] num;
	protected int sign;
	
	public Large_Integer() {
		this("0");
	}

	public Large_Integer(String n) {
		this.size = 10;
		this.num = new int[size];

		this.sign = n.charAt(0)=='-' ? 1:0;
		
		if(size<=n.length())
			arrSizeUp(n.length());

		this.num = copyString(n);
	}

	/**
	 * 배열의 크기를 늘려주는 메소드
	 * @param nLength 현재 size와 비교할 nLength
	 */
	protected void arrSizeUp(int nLength) {

		while(this.size <= nLength)
			this.size *= 2;
		num=copyArray();
	}

	/**
	 * 기본값인 0을 num[]에 넣음
	 * @return num[]
	 */
	protected int[] copyArray() {
		int[] result = new int[size];
		return copyArray(num, 0);
	}

	/**
	 * arr[]에 들어온 값을 num[]에 복사함.
	 * @param arr 복사할 배열
	 * @param sign 부호.
	 * @return num[]
	 */
	protected int[] copyArray(int[] arr, int sign) {
		int[] result = new int[size];

		result[0] = sign;

		int start = result.length-arr.length;

		for(int i = result.length-1, j=1; i>=result.length-arr.length+1; i--, j++)
			result[i]=arr[arr.length-j];

		return result;
	}
	
	/**
	 * 들어온 값을 num[]에 넣음.
	 * @param n 들어온 값
	 * @return num[]
	 */
	protected int[] copyString(String n) {

		this.sign = n.charAt(0)=='-' ? 1 : 0;
		int start = sign==1 ? 1 : 0;
		int[] result = new int[size];

		result[0]=sign;
		int resultPoint = size - n.length();

		for(int i = start; i<n.length(); i++) {
			result[resultPoint+i]=Integer.parseInt(Character.toString(n.charAt(i)));
		}

		return result;
	}

	/**
	 * 배열에 든 수를 출력하는 메소드.
	 * @return 배열에 들어있는 수
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int start=1;


		for(int i = 1; i<=size; i++) {
			if(i==size) {
				start=size-1;
			}
			else if(num[i]!=0) {
				start=i;
				break;
			}
		}
		
		if(start==size)
			return "0";

		for(int i = start; i<size; i++)
			sb.append(num[i]);

		if(num[0]==0)
			return sb.toString();
		else
			return "-"+sb.toString();


	}

	public int whitIsSign() {
		return this.sign;
	}
	/**
	 * u*(10^m)을 하는 메소드입니다.
	 * @param n m의 값
	 * @return num에 있는 값에 10의 m승을 한 후 값을 리턴
	 */
	public String nPower(int n) {
		if(n==0)
			return toString();
		else if(n<0)
			return minusNPower(Math.abs(n));
		else {

			int start=1;
			for(int i = 1; i<size; i++) {
				if(num[i]!=0) {
					start=i;
					break;
				}
			}
			int nLength = size-start;
			if(nLength+n>=size) {
				arrSizeUp(nLength+n);
				for(int i = 1; i<size; i++) {
					if(num[i]!=0) {
						start=i;
						break;
					}
				}
			}

			for(int i = start; i<size; i++) {
				num[i-n]=num[i];
				num[i]=0;
			}


			return toString();
		}
	}

	/**
	 * u/(10^m)를 하는 메소드입니다.
	 * Integer값이기 때문에, 소주점은 절삭합니다.
	 * @param n m
	 * @return u/(10^m)
	 */
	public String minusNPower(int n) {
		if(n<=0)
			return toString();
		
		int start=1;
		for(int i = 1; i<size; i++) {
			if(num[i]!=0) {
				start=i;
				break;
			}
		}

		int nLength = size-start;

		for(int i = 0; i<=nLength; i++) {
			num[size-1-i]=num[size-1-i-n];
			num[size-1-n-i]=0;
		}


		return toString();
	}
	
	public String remainder(int n) {
		if(n<=0)
			return toString();
		
		int start=1;
		for(int i = 1; i<size; i++) {
			if(num[i]!=0) {
				start=i;
				break;
			}
		}
		
		for(int i = size-1-n; i>=start; i--) {
			num[i]=0;
		}

		return toString();
	}
}