package ch6;

/**
 * ---------------------- 내부 클래스 ----------------------
 * 
 * - 지금까지 중요한 부분
 *   - OOP 4대 특성의 개념, 활용, 코드레벨로 이해
 *     개인적으로 스터디 그룹으로 공부 중에 4대 특성과 관련된 새로운 적용사례가 있으면 
 *     정리를 잘 해 두어야 함.
 *   - 추상화, 다형성 잘 정리가 필요.
 *   - 인터페이스 => 다형성 => 약결합 => 생산성 향상.
 *     상속도 다형성이 됨. 상속은 강결합. 수정이 없을 경우, 상속을 적용.
 *   - 인터페이스를 활용한 약결합 예제 => 리팩토링, 디자인 패턴
 *   - 리팩토링( 초보, 아키텍처, DDD, TDD 등 )
 *   
 * 
 * 
 * - 내부(inner) 클래스
 * 
 *   클래스 안에 클래스를 선언하는 이유는 그만큼 클래스간의 밀접도(긴밀도)가 높다.
 *   
 *   장점 : - 멤버변수처럼 쉽게 접근이 가능. 
 *         - 코드의 복잡성이 줄어듬.(캡슐화)
 * 
 *   종류 : 인스턴스, static 변수, 지역변수, 익명(무명)클래스
 * 		- 인스턴스 클래스
 * 			인스턴스 멤버처럼 다루어짐. 멤버변수 선언위치에 선언.
 * 		- 스택틱 클래스
 * 			스태틱 멤버처럼 다루어짐. 스태틱 멤버 변수 선언위치에 선언.
 * 		- 지역 클래스
 * 			외부 클래스의 메소드, 초기화 블럭 안에 위치.
 * 		- 익명 클래스
 * 			클래스 이름이 없는 상태임.( 클래스 코드만 있는 상태. )
 * 			코드 한 번 실행하면 끝나게 됨으로, 1회용.
 * 			=> 클래스 선언과 객체 생성이 동시에 됨.
 * 
 * 
 * 
 * 
 *   클래스 : 멤버 변수 + 멤버 함수
 * 
 *   class ClassA {		// outer class
 *   
 *   	class ClassC {	// inner class => 캡슐화. 
 *   
 *   	}
 *   
 *   	ClassA() {
 *   
 *   	}
 *   
 *   }
 *   
 *   
 * 	 class ClassB {
 * 
 *   }
 * 
 * 
 *   class Outer {
 *   	
 *   	class InstanceInnerClass {} // 인스턴스 클래스
 *   	static class StaticInnerClass {} // 스태틱 클래스
 *   	
 *   	void myMethod() {
 *   		class LocalInnerClass {}	// 지역 클래스
 *   	}
 *   
 *   }
 * 
 * 
 * 
 * 
 * 
 */



public class OopEx7 {
	
	class InstanceInner {
		int iv = 100;
		final static int CONST = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int CV = 200;
	}
	
	void myMethod() {
		class LocalInner {
			int iv = 300;
			final static int CONST = 300;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
