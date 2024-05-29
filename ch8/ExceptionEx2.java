package ch8;

/**
 * - Object
 *    - Throwable
 *       - Exception : checked 예외
 *   	    - RuntimeException : unchecked 예외
 *   
 * - 사용시의 Exception 의 분류
 *   - Exception : checked 예외
 *   			컴파일러가 예외처리를 확인.
 *   
 *   - RuntimeException : unchecked 예외
 *   			컴파일러가 예외처리를 확인하지 않음.
 * 				예) 0으로 나누는 코드. ( 컴파일러가 코드를 체크하지 않음. )
 *    
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class ExceptionEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			
			throw new RuntimeException();
			
			
			// 개발자가 필요에 의해서 예외를 발생시키는 경우. => 사용자 정의 예외
			// 1. Exception 클래스의 인스턴스 생성.
			// 2. 인스턴스를 던지면 됨.
			
//			Exception ue = new Exception("고의로 예외 발생시킴.");
//			throw ue;
			
			//throw new Exception("고의로 예외 발생시킴.");
			
//			System.out.println(3);
//			System.out.println(0/0); // ArithmeticException 발생.
//			System.out.println(4);
		} catch (ArithmeticException ae) {
			
			if (ae instanceof Exception) 
				System.out.println("true");
			
			System.out.println("예외 메세지 : " + ae.getMessage());
			
			System.out.println("ArithmeticException!!");
		} catch (Exception e) {
			// ArithmeticException 는 Exception 로 만들어진 파생임.
			// 따라서, 다형성으로 catch 가 된 것임.
			System.out.println("Exception!!");
			System.out.println("예외 메세지 : " + e.getMessage());
		}
		
		//Exception 처리가 되었으므로, 정상종료가 됨.
		System.out.println(5); // 출력이 되면, 정상 종료가 되었음.
		
		System.out.println("프로그램이 정상 종료되었음.");
	}

}
