package ch14;

/**
 * 
 * 함수형 인터페이스 의 JAVA API
 * 
 * 목적 : Stream 의 API 문서를 보고 사용하기 위해서.
 * 		Stream 의 메소드를 사용해하는데, 이때 각 메소드의 매개변수를 이해하고
 *      사용하기 위함.	
 *      
 * - 패키지 : java.util.function package 
 * 
 * - 매개변수 가 없거나, 하나인 함수형 인터페이스 ( 종류 및 의미 )
 * 	 1. Supplier<T>
 * 		매개변수는 없고 반환값만 있음.
 * 
 * 	 2. Consumer<T>
 * 		매개변수만 있고, 반환값이 없음.
 * 
 * 	 3. Function<T, R>
 * 		일반적인 함수. 하나의 매개변수를 받아 처리 후, 결과를 반환. 
 * 
 * 	 4. Predicate<T>
 * 		조건식을 표현할 때 사용. 매개변수는 하나, 반환타입이 boolean. 
 * 
 * - 매개변수가 두 개인 함수형 인터페이스 ( 종류 및 의미 )
 * 
 * 	 1. BiConsumer<T, U>
 * 		두 개의 매개변수가 있고, 반환값이 없음.
 * 
 * 	 2. BiFunction<T, U, R>
 * 		일반적인 함수. 두 개의 매개변수를 받아 처리 후, 결과를 반환. 
 * 
 * 	 3. BiPredicate<T, U>
 * 		조건식을 표현할 때 사용. 매개변수는 두 개, 반환타입이 boolean. 
 * 
 * 
 * - Operator
 * 		
 * 	 1. UnaryOperator(Unary : 단 항)
 * 		UnaryOperator<T>
 * 		매개변수가 하나이고, 매개변수와 결과의 타입이 동일한 경우.
 * 		Function<T> 와의 차이점은 매개변수와 결과의 타입이 동일.
 * 
 * 
 * 	 2. BinaryOperator(Binary : 이 항)
 * 		매개변수가 두 개이고, 매개변수와 결과의 타입이 동일한 경우.
 * 		BiFunction<T> 와의 차이점은 매개변수와 결과의 타입이 동일.
 * 
 * 
 * 
 * - 함수형 API가 매개변수로 사용되는 JAVA API 메소드
 * 
 * 	 Map : key, value 로 구성된 자료형. 따라서, 데이터 추가시 매개변수가 2 개임.
 * 
 * 	 void forEach( BiConsumer<T, U> action )
 * 
 *   Map의 모든 요소에 작업 action 을 수행. 
 * 
 * 
 * 
 * 
 * 	 Collection
 * 
 * 	 boolean removeIf( Predicate<T> fillter )
 *   조건에 맞는 요소를 삭제
 * 
 * 
 * 
 */

public class LambdaEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
