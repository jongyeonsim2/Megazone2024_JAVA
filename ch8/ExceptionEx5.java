package ch8;

/**
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

public class ExceptionEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			startInstall();
		} catch (SpaceException e) {
			System.out.println("에러 메세지 : " + e.getMessage());
			e.printStackTrace();
		} catch (MemoryException e) {
			System.out.println("에러 메세지 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			deleteTempFiles();
		}
		
	}

	// 프로그램 설치와 관련된 메소드 작성
	static void startInstall() throws SpaceException {
		if(!enoughSpace())
			throw new SpaceException("설치 실패 : 설치공간 부족");
		
		if(!enoughMemory())
			throw new MemoryException("설치 실패 : 메모리 여유 부족");
	}
	
	static void copyFiles() {}
	
	static void deleteTempFiles() {
		System.out.println("설치 파일 삭제 완료");
	}
	
	static boolean enoughSpace() {
		// 디스크 여유 공간 체크 로직 작성.
		// false : 공간이 부족. => 예외 발생 시켜야 하는 상황.
		// true : 디스크의 설치 공간이 충분 => 예외 발생 하지 않음.
		return true;
	}
	
	static boolean enoughMemory() {
		// 메모리 여유 공간 체크 로직 작성.
		return false;
	}
}


// 예외 클래스 정의

// 예외 클래스 카테고리
/**
 * - 사용자 예외 - 100 개
 * - 시스템 예외 - 100 개
 * - 서비스 예외 - 100 개
 * - 운영 예외 - 100 개
 * 
 * - 400개 예외에 대해서 try{} catch(){} 초반에는 엄격하게 하는게 맞을 수 있지만,
 *   정말 안정화 되고, 운영이 잘되고 있는 상황에서, 신규개발시, 수정시
 *   try{} catch(){} 를 하지 않아도 되도록 개발 및 유지보수 정책을 수립할 수 있음.
 *   
 *   RuntimeException class 를 사용하게 되면, try{} catch(){} 를 하지 않아도
 *   되게 해줌.
 *   
 * - checked, unchecked 옵션
 *   checked : 컴파일러가 검사 -> Exception 의 관계를 맺어주면 됨. -> 상속
 *   		예외 처리를 강제 하겠다는 의미. -> 직접 예외 처리 or 위임 처리
 *   unchecked : 컴파일러가 검사 안함 -> RuntimeException 의 관계를 맺어주면 됨. -> 상속
 *   
 *   
 * 
 * 
 * 
 */

class SpaceException extends Exception {
	public SpaceException(String msg) {
		super(msg);
	}
}

class MemoryException extends RuntimeException {
	public MemoryException(String msg) {
		super(msg);
	}
}









