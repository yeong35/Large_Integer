# Large_Integer
Java의 32bit 정수형보다 더 큰 정수형을 담는 자료형

Large_Integer 사용법

Large_Integer 객체를 선언한다. 이때 new Large_Integer("n"), new Large_Integer()로 선언한다.
n은 모든 정수이다.
Large_Integer를 계산하고싶다면, Large_Integer_calculate 객체를 생성한다.
Large_Integer에 10^m승을 곱하고싶다면 Large_Integer_calculate의 TenPowMumtiply메소드에 인자로 Large_Integer 객체 하나와, 정수 m값을 전달한다. 이때 반환은 String이다.
Large_Integer에 10^m승을 나누고싶다면 Large_Integer_calculate의 TenPowMDivide메소드에 인자로 Large_Integer 객체 하나와, 정수 m값을 전달한다. 이때 반환은 String이다.
Large_Integer에 10^m승을 나눈 나머지를 알고싶다면 Large_Integer_calculate의 TenPowMRemainder메소드에 인자로 Large_Integer 객체 하나와, 정수 m값을 전달한다. 이때 반환은 String이다.
