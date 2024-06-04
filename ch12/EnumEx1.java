package ch12;

/**
 * 열거형(enums)
 * 
 *   - 관련된 상수를 한 곳에 모아서 사용하기 위함.
 * 
 * 
 * 열거형의 정의
 * 
 *   - enum Direction { EAST, SOUTH, WEST, NORTH }
 *   - class Unit {
 *   		int x, y;		// 위치 정보
 *   		Direction dir;	// 방향 정보
 *   		
 *   		void init() {
 *   			dir = Direction.EAST;  // 열거형 이름.상수명
 *   		}
 *     }
 *     
 * 열거형의 기반 - java.lang.Enum
 * 	  name() : 상수의 이름을 문자열로 반환.
 * 	  ordinal() : 열거형 상수가 정의된 순서를 정수로 반환.(0부 시작)
 *    valueOf() : 매개변수와 일치하는 열거형 상수를 반환.
 *     
 *    
 * 열거형의 활용 및 확장
 *    - 상수간의 비교에 "==" 연산자 사용 가능.
 *    	equals 메소드 보다는 연산이 빠름.
 *      열거형의 비교는 다른 열거형과의 비교는 할 수 없음.(자신의 상수간만 비교 가능.)
 *    - 비교 연산자 사용 못함.( <, > )
 *    - compareTo() 사용 가능.
 *      비교 대상이 같으면, 0. 왼쪽이 크면, 양수, 오른쪽이 크면, 음수를 반환.
 *    - case 문에서 사용시 반드시 상수 이름을 사용.
 *    
 *    - 열거형의 확장 => 기능적인 요소를 추가
 *    	인스턴스 변수, 생성자, 메소드, 추상 메소드 => 마치 클래스와 비슷한 형태.
 *      
 *      상수에 불연속적인 값으로 설정하는 경우 필요한 추가 사항.
 *      - 인스턴스 변수, 생성자(private)를 반드시 추가해야 함.
 *      - getter 가 필요.
 *      - 인스턴스 변수, 생성자 를 작성하지 않으면, 컴파일 에러가 발생함.
 *      
 *      enum Direction {
 *      	// 상수명, 상수값 으로 구성이 됨.
 *      	EAST(1), SOUTH(5), WEST(-1), NORTH(10);
 *      
 *      	// 상수면, 상수값, 심볼
 *      	EAST(1, ">"), SOUTH(5, ">"), WEST(-1, ">"), NORTH(10, ">");
 *      
 *      	// 상수에 기능을 추가
 *      	// 교통 수단 관련 상수, 상수값을 기본 요금으로 설정.
 *      	// 교통 수간 관련 상수에 제한을 추가 : 요금 처리 관련
 *      	BUS(10000) {
 *      		요금 계산 처리를 위한 메소드
 *      	}
 *      	TRAIN(20000) {
 *      		요금 계산 처리를 위한 메소드
 *      	}
 *      	SHIP(15000); // 계산 기능의 추가를 강제할 수 있음. => 추상메소드
 *      	
 *      	private final int value;
 *      	Direction(int value) { //private 를 생략해도, private 생성자임.
 *      		this.value = value;
 *      	}
 *      
 *      	public int getValue() { return value; }
 *      
 *      	// 심볼 정보 관리와 관련된 멤버
 *      	
 *      	// 교통 수단의 요금 계산을 위한 추상 메소드 추가
 *      }
 *     
 * 
 * 
 * 
 * class Card {
 * 	static final int CLOVER = 0;
 *  static final int HEART = 1;
 * 
 * 	static final int TWO = 0;
 *  static final int THREE = 1;
 * 
 *  final int kind;
 *  final int num;
 * }
 * 
 * 
 * class Card {
 * 	enum Kind {CLOVER, HEART, ... }
 *  enum Value { TWO, THREE, ... }
 *  
 *  final int kind;
 *  final int num;
 * }
 * 
 * 
 */

enum Direction { EAST, SOUTH, WEST, NORTH }
enum Direction2 { EAST, SOUTH, WEST, NORTH }

// 내부적으로 관리되는 순서 정보 => 정수형, 0부터 시작.


public class EnumEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		Direction2 d4 = Direction2.EAST;
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		//Direction.EAST == Direction2.EAST
		// 열거형 간에 ㅂ
		System.out.println("d1 == d2" + (d1==d2));
		
		//
		/*
		System.out.println("d1 == d4" + (d1==d4));
		
		System.out.println("Direction.EAST == Direction2.EAST = " + 
				(Direction.EAST == Direction2.EAST));
		*/
		
		
		// Enum 의 상수 정보를 배열로 반환.
		Direction[] dirArr = Direction.values();
		
		for(Direction d : dirArr)
			System.out.printf("%s=%d%n", d.name(), d.ordinal());
		
		
		switch(d1) {
		case EAST:
			System.out.println("EAST임.");
			break;
		case SOUTH:
			System.out.println("SOUTH임.");
			break;
		default:
			System.out.println("없는 정보임.");
		}
		
	}

}
