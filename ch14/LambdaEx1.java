package ch14;

/**
 * 자바 활용서 : Real-World Software Development
 * 
 * - 교재의 목적
 *   조금이라도 현업에 가까운 코드로 학습.
 *   큰 그림을 보면 좋음. SW 아키텍처를 생각해보면 좋음.
 *   
 * - 현재 자바가 어렵다고 생각되면,
 *   지금까지 학습한 자바 지식을 기준으로 자바 활용서의 코드를 이해.
 *   
 *   목표 : 자바 교재의 코드를 다른 프로젝트에서 이용 및 활용할 정도.
 *   기간 : react 수업의 1/4 시점까지.
 *         mysql, react, java 병행할 수 있도록 해야함.
 * 
 * - lambda, stream 수업.
 *   수업이 일찍 끝나면, 활용서 소스를 미리 분석할 것.
 *   chapter 2 코드 > chapter 3 코드
 *    
 * - 자바 활용서에는 lambda, stream 많이 사용.
 * 
 * 
 * 
 * - 람다의 공부 방법
 *   1. 람다의 의미 및 특징
 *   2. 함수형 인터페이스
 *      JAVA API 인 Stream 을 사용하는데, 결국에는 메소드임.
 *      메소드의 매개변수 : 람다 + 제네릭
 *             기존의 매개변수 : 기본형, 참조형 
 *      Stream JAVA API의 메소드의 매개변수 : 함수형 인터페이스
 *      
 *      함수형 인터페이스 : JAVA API => 종류, 특징
 *   3. 메서드 참조
 *      System.out.println("Hello. java~")
 *   	System.out::println
 * 
 * 
 * 
 * - 스트림의 공부 방법
 *   1. 스트림의 개념 및 특징, 왜 스트림을 사용해야 하는지.
 *      데이터 소스(Collection, array, File) 사용하기 위한 것임.
 *   2. Stream 생성
 *   3. 스트림의 연산
 *      연산의 차이점, 각 연산별 중요한 연산 Stream Api 메소드
 *      각 api 메소드의 매개변수가 함수형 인터페이스임. 
 *   	- 중간연산
 *        map(), filter()
 *      - 최종연산
 *        collect(), toList()
 *   
 * 
 * - 자바의 큰 변화
 *   지네릭스 - jdk 1.5
 *   람다식 - jdk 1.8
 *         => 함수형 언어가 됨.
 *         
 * - 코드상의 람다의 이해
 *   int method(int i) {
 *   	return (int)(Math.random() * 5) + 1 + i;
 *   }
 *   
 *   (int i) -> (int)(Math.random() * 5) + 1 + i;
 *   
 *   1. 기존 함수의 반환타입, 메소드명을 제거.
 *   2. 매개변수 와 몸통의 실행 코드 사이에 -> 를 넣음.
 * 
 * - 람다의 장점
 *   1. 간결하고 이해가 쉽다.
 *   2. 람다식 자체로 메소드의 역할을 대신함.
 *   3. 메소의 매개변수로 람다식을 사용할 수 있음.
 *   
 *   
 * - 다양한 람다식의 형태
 *   반환값이 있는 메소드의 경우, return 문 대신에 "식"으로 대신할 수 있음.
 *   따라서, 식의 연산결과가 자동적으로 반환된다고 생각하면 됨.
 *   그래서, 식임으로 끝에 ";" 을 붙이지 않음.
 *   
 *   람다식에서 매개변수의 타입인 없다면, 생략된 것이라고 생각하면 됨.
 *   추론이 가능함으로 대부분 생략이 됨.
 *   
 *   
 * 
 *   int max(int a, int b) {
 *   	return a > b ? a : b;
 *   }
 *   
 *   
 *   void printVar(String name, int i) {
 *   	System.out.println(name + "=" + i);
 *   }
 *   
 *   
 *   
 *   int square(int x) {
 *   	return x * x;
 *   }
 *   
 *   
 *   
 *   int roll() {
 *   	return (int)(Math.random() * 6);
 *   }
 *   
 *   
 * 
 */


public class LambdaEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
