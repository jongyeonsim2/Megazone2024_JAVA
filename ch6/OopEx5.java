package ch6;

/**
 * interface
 *   : 추상메소드, 다중 상속처럼 사용 가능, 다형성 => 논리적이지 않은 것도 묶을 수 있음.
 *   
 *   추상메소드 => 메소드 구현을 강제 시킬 수 있음. 신입사원 실수하지 못하도록 함.
 *   다중 상속 => 2 개 이상의 interface 를 사용. 따라서, 구현해야 하는 추상메소드도 2개.
 *   다형성 => Car, Airplane, Ship 의 공통점 : 이동체
 *   		  공격 기능 없지만, 공격 interface 를 만든다면,
 *            어떤 Airplane 공격 interface 를 구현하지 않고, => 여객기
 *            어떤 Airplane 공격 interface 를 구현하면,  => 전투기
 *            
 *            어떤 Ship 공격 interface 를 구현하지 않고, => 여객선
 *            어떤 Ship 공격 interface 를 구현하면,  => 함선
 *            
 *            인터페이스를 기준으로 관계없는 것들도 세분화해서 다형성을 적용할 수 있음.
 *            
 *            전투와 관련된 다형성
 *            전투와 관련되지 않은 다형성
 *            이동과 관련된 다형성
 *   
 * 
 *   인터페이스 예제 => 스타크래프트 캐릭터를 만듬. Marine, SCV, Tank, Dropship
 *   
 * 
 * 
 * 
 * 
 */


public class OopEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
