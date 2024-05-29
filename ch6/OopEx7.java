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

// ---- 멤버 메소드, 클래스 메소드에서 멤버클래스 및 지역 클래스 접근 ----
class Outer2 {
	class InstanceInner {}
	static class StaticInner {}
	
	// 인스턴스 멤버 변수가 인스턴스 클래스에 접근
	// 인스턴스 멤버간에 접근
	InstanceInner iv = new InstanceInner();
	
	// 스태틱 멤버 변수가 스태틱 클래스에 접근
	static StaticInner cv = new StaticInner();
	
	// Outer2 의 인스턴스 메소드
	void instanceMethod() {
		// 특성 정리 : 인스턴스의 특성은 인스턴스와 스태틱 모두 접근 가능
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		//LocalInner lv;
	}
	
	// Outer2 의 스태틱 메소드
	static void staticMethod() {
		// 특성 정리 : 스태틱은 스태틱에만 접근 가능. 스태틱은 인스턴스에 접근못함.
		//InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		//LocalInner lv;
	}
	
	//LocalInner lv;
	
	void myMethod() {
		// 지역 클래스
		class LocalInner {}
		LocalInner lv = new LocalInner();
	}
	
	
}

// ---- 멤버 메소드, 클래스 메소드에서 멤버클래스 및 지역 클래스 접근 ----







// ---- Outer 클래스의 인스턴스 및 스태틱 클래스의 멤버변수 사용 ----

class Outer3 {
	class InstanceInner {
		int iv = 100;
	}
	static class StaticInner {
		int iv=200;
		static int CV=300;
	}
	void myMethod() {
		class LocalInner {
			int iv=400;
		}
	}
}

//---- Outer 클래스의 인스턴스 및 스태틱 클래스의 멤버변수 사용 ----









//---- Outer, Inner class 에서 this 사용 ----
class Outer4 {
	int value = 10;
	
	class Inner {
		int value = 20;
		
		void method1() {
			int value = 30;
			
			// method1() 에서 value 변수 사용 => 3가지 케이스를 고려.
			System.out.println("value = " + value);
			System.out.println("this.value = " + this.value);
			System.out.println("Outer4.this.value = " + Outer4.this.value);
		}
	}
}


//---- Outer, Inner class 에서 this 사용 ----










public class OopEx7 {
	
	// 인스턴스 와 스태틱의 사용 차이점.
	
	// --------------- inner class의 인스턴스 생성 방법 ---------------
	
	class InstanceInner {
		int iv = 100;
		static int cv = 100;
		final static int CONST = 100;
	}
	
	static class StaticInner {
		int iv = 200;
		static int CV = 200;
	}
	
	void myMethod() {
		class LocalInner {
			int iv = 300;
			static int cv = 300;
			final static int CONST = 300;
		}
	}
	
	// --------------- inner class의 인스턴스 생성 방법 ---------------
	
	
	

	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// --------------- inner class의 인스턴스 생성 방법 ---------------
		// InstanceInner.CONST 는 inner class 의 멤버라도
		// static 변수임으로 바로 접근이 가능
		System.out.println(InstanceInner.CONST);
		
		// InstanceInner 는 인스턴스 클래스.
		// Outer class 의 객체부터 생성해야만 접근이 가능.
		// InstanceInner 다시 객체를 생성해야만,
		// InstanceInner 의 멤버인 iv를 접근할 수 있음.
		
		OopEx7 outer = new OopEx7();
		OopEx7.InstanceInner inner = outer.new InstanceInner();
		
		
		//InstanceInner ii = new InstanceInner();
		
		System.out.println(inner.iv);

		// --------------- inner class의 인스턴스 생성 방법 ---------------
				
		
		
		
		
		// ---- Outer 클래스의 인스턴스 및 스태틱 클래스의 멤버변수 사용 ----
		// 이너클래스 사용을 위해서는 Outer 클래스의 인스턴스를 먼저 생성.
		Outer3 oc = new Outer3();
		Outer3.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv = " + ii.iv);
		
		System.out.println("Outer3.StaticInner.CV = " + Outer3.StaticInner.CV);
		
		// static inner class 의 인스턴스 변수 사용.
		Outer3.StaticInner si = new Outer3.StaticInner();
		System.out.println("si.iv = " + si.iv);
		
		// ---- Outer 클래스의 인스턴스 및 스태틱 클래스의 멤버변수 사용 ----
		
		
		
		
		
		
		
		//---- Outer, Inner class 에서 this 사용 ----
		Outer4 o4 = new Outer4();
		Outer4.Inner i4 = o4.new Inner();
		i4.method1();
		//---- Outer, Inner class 에서 this 사용 ----
		
		
	}

}
