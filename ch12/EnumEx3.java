package ch12;

/**
 * 상수의 구성 정보
 *   - 불연속적인 상수값
 *   - 기능적인 메소드
 *     1. 추상메소드 선언.
 *     2. 선언된 추상메소드를 각 상수별로 구현.
 *     3. 메소드 내에서 인스턴스 변수 사용 못함.
 *     		참조할 수 있도록 별도의 상수를 만들어서, 참조하도록 함.(우회 참조)
 * 
 */

enum Transportation {
	BUS(100) {
		// 요금 계산 기능
		int fare(int distance) {
			return distance * BASIC_FARE;
			//return distance * getBasicFare();//BASIC_FARE = 100;
		}
	},
	TRAIN(150) {
		// 요금 계산 기능
		int fare(int distance) {
			return distance * BASIC_FARE;//BASIC_FARE = 150;
		}
	};
	
	private final int basicFare;
	final int BASIC_FARE;
	
	Transportation(int basicFare) {
		this.basicFare = basicFare;
		BASIC_FARE = basicFare;
	}
	
	public int getBasicFare() { return basicFare; }
	
	abstract int fare(int distance);
}

public class EnumEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("bus 요금 : " + Transportation.BUS.fare(100));
		System.out.println("train 요금 : " + Transportation.TRAIN.fare(200));
		
	}

}
