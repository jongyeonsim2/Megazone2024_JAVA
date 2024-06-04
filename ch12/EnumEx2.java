package ch12;

/**
 * 상수의 구성 정보
 *   - 불연속적인 상수값
 *   - 상수값 외의 추가적인 정보
 * 
 */

enum Direction3 {
	// 상수 선언( 상수값, 심볼 )
	EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

	// 1. 생성자 필수
	// 2. 인스턴스 상수 변수
	// 3. 생성자에 인스턴스 상부 변수 초기화
	
	private static final Direction3[] DIR_ARR = Direction3.values();
	
	private final int value;
	private final String symbol;
	
	Direction3(int value, String symbol){
		this.value = value;
		this.symbol = symbol;
	}
	
	// 상수값 게터
	public int getValue() { return value; }
	
	public String getSymbol() { return symbol; }
	
	// 정수(위치정보) 매개변수를 받아서 해당 상수를 반환하는 메소드
	public static Direction3 getDirection(int idx) {
		if (idx < 1 || idx > 4 ) {
			throw new IllegalArgumentException("Invalid value : " + idx);
		}
		
		return DIR_ARR[idx - 1];
	}
	
	public String toString() {
		return name() + " " + getSymbol();
	}
}



public class EnumEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(Direction3 d : Direction3.values())
			System.out.printf("%s=%s%n", d.name(), d.getSymbol());
		
		// 위치정보를 사용해서 상수를 반환하는 메소드 사용
		Direction3 d3 = Direction3.getDirection(1);
		
		// 상수명, 상수값, 심볼 정보를 출력
		System.out.printf("d3 = %s, %d, %s%n", 
				d3.name(), d3.getValue(), d3.getSymbol());
		
		
	}

}
