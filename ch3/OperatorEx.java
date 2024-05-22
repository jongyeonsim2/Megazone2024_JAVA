package ch3;

/**
 * 연산자의 종류
 * - 산술 : 사칙연산, 나머지 연산(%), 
 * - 비교 : >, <, >=, <=, ==, != 
 * - 논리 : &&(and), ||(or), ! 
 * 			and : 조건 두 가지 모두 참인경우, true
 * 			or : 조건 두 가지중 하나만 참이면, true
 * - 대입 : = , 
 * - 기타 : instance of, (), ?:
 * 
 * 연산자의 우선순위
 * 
 * 산술변환
 * - 연산전에 타입을 일치시키기 위해서 자동 형변환 되는 것.
 * - 작은 자료형에서 큰 자료형으로 변환.
 * - int 보다 작은 타입이면, int로 변환됨.
 * 
 * 단항연산자의 동작
 * - 전위형 : 값이 참조되기 전에 먼저 증감이 발생. ex) ++i
 * - 후위형 : 값이 참조된 후 증감이 발생.		ex) i++
 * 
 * 조건 연산자(3항식)
 * - 조건식 ? 식1 : 식2
 */

public class OperatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 5;
		
		System.out.println(i);
		i++; //후위형
		System.out.println(i);
		
		i = 5;
		++i; //전위형
		System.out.println(i);
		
		
		int a = 5, b = 0;
		b = a++;
		
		System.out.println("a = " + a + ", b = " + b);
		
		
		//산술변환
		// int 보다 작은 경우는 int 로 자동 변환됨.
		byte b2 = 10;
		byte b3 = 20;
		//byte b4 = b2 + b3;//b2 + b3 는 int 임.
							// int를 byte로 하려고 함.
		
		byte b4 = (byte)(b2 + b3);//값 소실 가능성이 있음.
		
		// 변수 초기화 표현 스타일 => 가독성
		int read1 = 1000000;
		int read2 = 1_000_000;
		
		long long1 = 1_000_000 * 1_000_000;
		long long2 = 1_000_000 * 1_000_000L;
		
		// 비교 연산
		System.out.println('0' == 0); 
		System.out.println('0' != 0); 
		System.out.println('A' > 'B');
		System.out.println('A' < 'B');
		System.out.println('B' == 66);
		
		// 문자열인 경우의 논리연산. 문자열은 참조형. 주소값임.
		String str = "abc";//1. str에는 주소값임.
							//2. 논리연산은 문자열 값인 abc가 비교되도록해야함.
		// String 참조형의 경우 == 대신에 equals() 메소드를 사용해서 비교해야 함.
		System.out.println(str.equals("abc"));
		System.out.println(str.equals("def"));
		
		// and, or 논리 연산
		System.out.println(0 < 10 && 10 < 20);
		System.out.println(100 < 10 || 10 < 20);
		
		// !(논리 부정) 연산
		System.out.println(!(0 < 10 && 10 < 20));
		
		System.out.println(!!(0 < 10 && 10 < 20));
		
		// 조건 연산자
		System.out.println((0<10) ? true : false);
		System.out.println((0>10) ? true : false);
		
		System.out.println((0<10) ? (0<10) ? true : false : false);
		
		// 복합 대입연산자
		// i = i + 1;
		// i += 1;
	}

}




