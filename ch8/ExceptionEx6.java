package ch8;

/**
 * - 자동 자원 반환 
 *   문법 : try ... with ... resources ...
 *   
 *   목적 : finally 의 복잡도가 높아지는 경우를 해결.
 *   		자원해제 시 사용 가능성이 높음. ( ex. 입출력 처리 관련 )
 *   			=> close() 메소드를 알아서 호출.( 인스턴스의 null 유무 )
 * 
 * 	 사용 : AutoCloseable interface 를 구현.
 * 			인터페이스를 구현해야만, 자동 자원 반환 문법을 적용시킬 수 있음.
 * 
 */


public class ExceptionEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (CloseableResource cr = new CloseableResource()) {
			
		} catch(CloseException e) {
			e.printStackTrace();
		}
		
	}

}


// 해제할 어떤 자원이 있다고 가정하고 class 를 작성.
class CloseableResource implements AutoCloseable {

	
	/*
	 * 사용자 정의 Exception 적용 전.
	@Override
	public void close() throws Exception {
		System.out.println("close()가 호출됨.");
	}
	*/
	
	// 사용자 정의 Exception 적용 후.
	@Override
	public void close() throws CloseException {
		System.out.println("close()가 호출됨.");
		throw new CloseException("CloseException 발생!!");
	}
	
}


class CloseException extends Exception {
	public CloseException(String msg) {
		super(msg);
	}
}





