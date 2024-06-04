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
	
	public String getSymbol() { return symbol; }
	
	public String toString() {
		return name() + " " + getSymbol();
	}
}



public class EnumEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
