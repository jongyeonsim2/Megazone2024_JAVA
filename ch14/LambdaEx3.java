package ch14;

/**
 * 메서드 참조
 * 
 * 람다식을 더욱 간결하게 표현할 수 있는 방법
 * 
 * - 람다식 형태
 * Function<String, String> f = (String s)->Integer.parseInt(s);
 * 
 * 
 * Integer wrapper(String s) {
 * 		return Integer.parseInt(s);
 * }
 * 
 * - 메소드 참조 형태
 * Function<String, String> f = Integer::parseInt;
 * 
 * - 메소드 참조 스타일로 코드를 작성해도 문제가 없이 동작하는 배경(컴파일러 입장).
 * 	 1. parseInt 코드를 보게, Integer 의 parseInt() 메소드라고 생각
 *   2. Function 인터페이스의 지정된 지네릭 타입으로 부터 매개변수와 반환타입 정보를
 *      유추할 수 있음.
 *   3. (String s)->Integer.parseInt(s) 형태라는 것을 알게됨.
 *   
 *   
 * 
 * - 람다식 형태
 * BiFunction<String, String, Boolean> f 
 * 								= (s1, s2) -> s1.equals(s2);
 * - 메소드 참조 형태
 * BiFunction<String, String, Boolean> f = s1::equal;
 * 
 * 
 * 
 * 
 * 메소드 참조 형태의 코드 작성(람다식 작성)은
 * 		"참조변수::메서드이름", "클래스이름::메서드이름" 로 줄여서 사용할 수 있음. 
 * 
 * 
 * MyClass obj = new MyClass();
 * Function<String, Boolean> f = (s) -> obj.equals(s);
 * Function<String, Boolean> f = obj::equals;
 * 
 * 
 */

public class LambdaEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
