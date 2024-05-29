package ch6;

/**
 * -------------------- JAVA 선행 프로젝트에 대해서 --------------------
 * 
 *  - 스터디 조 구성
 *    JAVA 프로젝트 추천( 자바 종료 ~ React 시작 후 1/4 시점 )
 *    - 레이어가 있는 수준( MVC - DB ) => S/W 아키텍처
 *      순수 자바로 MVC 아키텍처 기반의 자바 프로그램
 *      ( 없는 것 : html, javascript, jsp, servlet, db )
 *      html, javascript(화면에 보여주기) : view
 *                                      model
 *      jsp, servlet(메뉴에 따른 처리) : controller
 *      DB : java 의 자료구조
 * 
 *    - 주제 선정
 *      도서관리( 도서정보 관리, 회원정보 관리, 재고관리, 대출 처리, 구매 관리 ..... )
 *      
 *      도서정보 관리 ( 등록, 수정, 삭제, 조회(제목, 저자, 출판사, 분류코드 조회....) )
 *      
 *    - 목표
 *      각 한명이 관리 기능 구현.
 *      
 *    - 좋은 점.
 *      실제의 개발 경험.
 *      
 *      선행 프로젝트 결과물을 새로운 웹 기술로 마이그레이션(리액터, 스프링부트, jpa 기반으로).
 *      
 *      최종 프로젝트에서 엄청 도움이 됨.
 *      
 *    - 더더 좋은 점.
 *      이력서에 어필할 꺼리가 생김.(GitHub 결과물)
 *      
 * 
 */


/**
 * 
 * -------------------- Interface  --------------------
 * 
 * default method 와 static method
 * 
 * Interface 는 상수, 추상메소드로 구성됨. 작성한 Interface를 이미 사용중임.
 * 필요에 의해서 새로운 추상메소드를 추가해야하는 상황이라서, 추상메소드를 추가함.
 * 
 * 기존에 Interface를 implements 한 모든 클래스에서 추가된 새로운 추상메소드를
 * 구현해야 함.
 * 
 * 따라서, 새로운 메소드를 Interface에 추가를 하더라도, 다른 곳에 영향이 없으면 좋겠다고 
 * 생각함. => default method
 * 
 * 
 * 
 * Interface 의 작성 원칙은 추상메소드만 가능함. 
 * 다른 곳에서 사용되고 있는 stataic method 는 인스턴스 없이도 잘 사용중임.
 * 그래서, Interface 에도 static method 를 추가해서 사용하면 좋겠다라고 생각함.
 * => static method 도 사용가능해짐.
 * 
 * 
 * 
 * 클래스간의 상속, 인터페이스를 활용한 다중 상속 처럼 사용 중인 경우
 * 클래스의 메소드명, interface의 default 메소드 명이 중복되는 경우가 발생.
 * - 여러 interface에서 메소드명이 충돌
 *   
 * 
 * - default 메소드와 조상 클래스에서 메소드명이 충돌
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class OopEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



class Parent5 {
	public void method2() { // MyInterface 와 충돌
		
	}
}

class Child5 extends Parent5 {

}

interface MyInterface {
	// default method
	default void method1() { // MyInterface2 와 충돌
		System.out.println("method1():MyInterface");
	}
	
	default void method2() { // Parent5 와 충돌
		System.out.println("method2():MyInterface");
	}
	
	// static method
	static void staticMethod() {
		System.out.println("staticMethod():MyInterface");
	}
}

interface MyInterface2 {
	// default method
	default void method1() { // MyInterface 와 충돌
		System.out.println("method1():MyInterface2");
	}
	
	// static method
	static void staticMethod() {
		System.out.println("staticMethod():MyInterface2");
	}
}















