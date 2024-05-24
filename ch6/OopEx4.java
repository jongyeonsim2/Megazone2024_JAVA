package ch6;

/**
 * - 매개변수의 다형성
 *   쇼핑몰 시스템 구축, 상품정보, 회원
 * 
 *   상품 정보 : 기반 클래스, 카메라, 컴퓨터
 *   회원 정보 : 결제, 구매 메소드
 *             구매(상품), 구매(카메라), 구매(컴퓨터)
 *             
 *             구매(상품) => 메소드의 매개변수의 다형성
 *             
 *    현재는 JAVA 만 사용된 비즈니스 로직이 됨. => spring boot 에 소스의 일부.
 *    
 *    AWS에 SaaS(웹 애플리케이션)
 *    웹 애플리케이션(react, spring boot, mysql, jpa)
 *    
 *    
 */

public class OopEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 상품, 구매자 인스턴스 생성
		// 구매자가 상품을 구매
		// 구매 가능, 구매 불가능
		
	}

}

// 상품정보에 대한 기반 클래스
class Product3 {
	int price;
	int bonusPoint;
	
	Product3(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

// 상품 : 카메라
class Camera extends Product3 {
	Camera() {
		super(1000);
	}
	
	public String toString() {
		return "Camera";
	}
}

// 상품 : 컴퓨터
class Computer extends Product3 {
	Computer() {
		super(1000);
	}
	
	public String toString() {
		return "Computer";
	}
}

// 구매자(회원)
class Buyer {
	int money = 3000;
	int bonuxPoint = 0;
	
	// 구매 비즈니스 로직
	// 구현해보세요~~~~
	
	// 1. 매개변수 다형성 적용
	// 2. 구매 가능한지를 확인. 금액을 확인.
	//    - 구매 불가, 구매 가능
	// 3. 구매한 경우 잔액 변경.
	// 4. 보너스 포인트 지급
	// 5. 구매(결제) 성공 메시지 출력
	void buy() {
		
	}
}

