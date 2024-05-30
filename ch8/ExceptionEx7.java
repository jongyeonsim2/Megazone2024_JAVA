package ch8;

/**
 * 예외 되던지기 : 예외 처리 후 throw => 직접 처리 or 위임 처리 
 * 
 * 
 * 기존 : 예외 던지기 => throw => 직접 처리 or 위임 처리
 * 
 * 
 * 예외 되던지기 분류
 *   - 연관된 시스템이 자바가 아닌 경우
 *     별도의 A, B 분리된 시스템이 있다고 가정.
 *     A : JAVA 로 개발됨.
 *     B : C# 로 개발됨.
 *     
 *     A <-> B, 업무 처리시 서로 연결이 되어야 함.
 *     통신규약(네트워크 통신) => main() 에서 전문 반환.
 *     
 *     같은 서버에 A,B 가 존재하는 경우. => main() 반환형을 정수 또는 문자
 *     => batch system.( spring batch )
 * 
 * 
 * 
 * 연결된 예외(chained exception)
 * 예외 A 가 예외 B 를 발생시켰다면, A 를 B 의 예외 원인라고 함.
 * 
 * 
 * SpaceException, MemoryException, InstallException
 * 
 * 
 * SpaceException, MemoryException 는 InstallException 의 예외 원인이라고 
 * 할 수 있음. 포함관계, 다형성
 * 
 * 
 * try {
 * 	  startInstall();
 * } catch (SpaceException se) {
 *    InstallException ie = new InstallException();
 *    ie.initCause(se);
 *    
 *    // initCause() : Throwable 의 메소드, Throwable 에는 cause 변수.
 *    //								cause 의 type은  Throwable 임.
 *    // 현재 예외 인스턴스의 원인 예외를 등록할 수 있는 변수임.
 *    // cause 의 type이 Throwable 임으로, 모든 예외는 
 *    // 발생한 예외의 원인 예외를 등록이 가능.
 *    
 * } catch (MemoryException me) {
 * 
 * }
 * 
 * 
 * 발생한 예외를 그냥 처리하면 되는데, 왠지 복작해진 것 같은......
 * - 하나의 큰 분류의 예외로 묶어서 관리하고 싶은 경우.
 *   큰 분류의 예외로 catch 해서 처리하려고 하는데,
 *   실제로 발생한 예외를 알 수 가 없게 됨. 
 * - 상속 관계로 exception 을 정의하면 casting 가 필요해짐.
 *   파생된 exception 이 많아지게 되면, casting 의 부담이 높아지게 됨.
 * - checked 예외를 unchecked 로 변경하려고 하는 경우.
 *   new RuntimeException((new MemoryException())) => unchecked
 * 
 */


public class ExceptionEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main() 예외 처리");
		}
	}

	// 예외 되던지기 메소드
	static void method1() throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1() 예외 처리");
			throw e;
		}
	}
	
	
}


