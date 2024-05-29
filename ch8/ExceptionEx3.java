package ch8;

/**
 * ------------- 메소드에서 Exception 발생시켜서 던지기 -----------
 * ------------- 예외 처리 위임 -------------------
 * 
 * 
 * ------------- Exception 처리 문제( 해결해보세요!!!!! ) -----------
 * - 요구사항
 *   파일을 처리하는 예외가 발생할 수 있음을 가정하고 프로그램 구현.
 *   - 기능 : 복사공간 여유 확인, 메모리 여유 확인, 파일복사, 설치, 임시파일 삭제  
 *   - 예외 처리 : 복사 공간 여유 없을 때, 메모리가 부족 할 때
 *   - 프로그램 동작 순서
 *     - 설치 시작 -> 복사공간 여유 확인 -> 메모리 여유 확인 -> 파일복사-> 설치 완료
 *     - 설치 완료 -> 임시파일 삭제 
 *   - 좋은 코드로 작성하기 위한 기준
 *     응집도 높다 => 관련있는 것끼리 묶음 => 메소드 형태 
 *     								=> 설치 메소드, 
 *     									파일복사, 
 *     									파일삭제, 
 *     									메모리 체크, 
 *     									디스크 용량 체크
 *     재사용성이 높은 것 => 예외클래스 작성
 * 
 */


public class ExceptionEx3 {

	static void method1() throws Exception {
		
		method2();// 예외 처리 위임.
		
//		try {
//			method2();
//		} catch (Exception e) {
//			
//		}
	}
	
	static void method2() throws Exception {
		throw new Exception("method2() : 예외 발생."); // 예외 처리 위임
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			method1(); // 위임 받은 예외를 처리함.
		} catch(Exception e) {
			
		}
		//method1(); // 비정상 종료되게 됨. => JVM 에서 예외처리함.
		
		System.out.println("정상 종료됨!!");
	}

}
