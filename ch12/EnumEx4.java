package ch12;

/**
 * 상수를 직접 만드는 것.(enum 을 사용하지 않음.)
 * 
 * - enum 의 구조.

     1. 기반 클래스
 *   	enum Direction { EAST, SOUTH, WEST, NORTH }
 *   	- 내부적으로 순서 정보를 관리가 가능해야 함. ordinal()
 *      - 상수명도 관리가 되어야 함.
 *   
 *   2. 파생 클래스
 *      enum Direction { BUS(100) {
 *      		int fare(int distance) { return distance * BASIC_FARE; }
 *      	}
 *       }
 *       
 *       Direction 은 자기 자신의 클래스 타입임.
 *       자기 자신의 클래스 타입이 Direction 클래스에서 상수 멤버의 형태가 되게 됨.
 *       
 *       
 *   3. main()
 *      1, 2 번에서 구현된 기능(메소드) 을 사용.
 * 
 * - class 를 직접 구현
 *   상수( 상수명, 상수값, 기능적인 요소 )
 *   
 *   생성자,
 *   
 *   상수명 반환 함수. => name()
 *   
 * 
 */


public class EnumEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
