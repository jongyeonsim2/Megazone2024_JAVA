package ch8;

/**
 * ------------------- Exception ----------------------
 * 
 * - 에러의 종류 : 컴파일 에러, 런타임 에러, 논리 에러
 * 
 * - error 과 exception
 * 	 error(에러) : 코드로 해결할 수 없는 오류
 *   exception(예외) : 코드로 해결할 수 있는 오류(컴파일 에러 아님)
 *   				일어날 수 있는 오류에 대비해서 java에서 제공되는 문법을 활용해서 해결.
 *   
 * - 예외 처리의 목적
 *   프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지(중요)
 * 
 * - 문법
 *   try, catch, finally
 * 
 * 
 * 
 */



public class ExceptionEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int number = 100;
		int result = 0;
		
		for(int i=0; i<10; i++) {
			
			// 비그치다.
			// 실행유지 or 정상종료 처리되도록 Exception Handling함.
			
			try { //Exception 이 발생될 부분을 기입.
				result = number / (int)(Math.random()*10);
				System.out.println(result);
			} catch(ArithmeticException e) { // 발생한 예외에 대한 리포팅 처리.
				System.out.println("0로 나누기를 수행.");
			}
			
			// 0으로 나누는 경우 => java.lang.ArithmeticException 발생
			// 비정상 종료. => 문제점 리포팅 => 정상 종료가 되도록 해야함.
			//result = number / (int)(Math.random()*10);
			//System.out.println(result);
		}
		
	}

}
