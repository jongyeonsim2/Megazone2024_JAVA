package ch14;

/**
 * 스트림(Stream)
 * 
 * Collection 이 데이터 집합을 편리하게 사용할 수 있도록 표준화되어
 * Collection FW 로 제공되고 있지만, 개선(코드의 재사용 => 공용 메소드 부재)해야 할 부분이 있음.
 * 
 * List로 정렬하는 경우와 배열로 정렬하는 경우. (공용 메소드의 부재)
 * 
 * Collections.sort()
 * Arrays.sort()
 * 
 * List, Array, File 든 모두 동일한 인터페이스를 제공. => 표준화가 잘 되어 있음.
 * 
 * 
 * - Stream 의 장점
 *   코드의 재사용성이 높아짐.
 *   다양 데이터 소스를 대상으로 동일한 방식으로 다룰 수 있다.
 *   
 * - Stream 의 특징
 * 	 1. 스트림은 데이터 소스를 변경하지 않음.
 * 
 *   2. 스트림은 1 회용임.
 *      스트림 생성해서, 한 번 사용하면, 닫혀서 사용할 수 없음.
 *      다시 스트림 사용하고 싶다면, 스트림을 다시 생성해서 사용하면 됨.
 *      
 *   3. 스트림의 작업은 내부 반복으로 처리함.
 *		void foreEach( Consumer<? super T> action )   
 *      
 *      foreEach() 의 내부 구현부에는 반복문이 있음. ( 내부 반복 )
 *   
 *      <? super T> : 와일드 카드 하한 제한 => T 자신, 그 기반들
 *      Consumer<T> : 하나의 매개변수를 받아서 처리만 함. 반환값이 없음.
 *      			  (T) -> System.out.println(T)
 *      			  (T) -> System.out::println
 * 
 * 
 * - Stream 연산
 * 	 1. 중간 연산
 *      스트림을 처리(연산) 후 스트림을 반환.( 중요 : 스트림 반환 )
 * 
 *      filter()
 *      map()
 * 
 *   2. 최종 연산
 *      스트림의 요소를 소모하면서 처리(연산)을 수행.
 *      단 한 번만 연산이 가능.( 중요 : 단 한 번만 )
 *      
 *      collect()
 *      toList()
 *   
 *   스트림의 복합 연산의 예
 *   stream.distinct().sorted().forEach(System.out::println)
 *   
 *   중간연산 => distinct().sorted() 의 메소드 체인형태가 됨.
 *   최종연산 => forEach(System.out::println)
 *   
 *   
 *   
 * - Stream 만들기
 * 
 * 	 1. 컬렉션
 * 		Collection 에 stream() 를 사용.
 *      List, Set 을 구현한 컬렉션 클래스들은 모두 stream() 를 이용하면
 *      Stream 을 만들 수 있음.
 *      
 *      // 데이터 소스 생성
 *      List<Integer> list = Arrays.asList(1,2,3,4,5);
 *      
 *      // Stream 생성 
 *      Stream<Integer> intStream = list.stream();
 * 
 *      // 중간 연산 또는 최종 연산
 *      intStream.forEach(System.out::println)
 *      
 *      forEach 는 최종연산임으로 한 번만 사용 가능.
 *      다시 사용하려면, 다시 Stream 생성해서 사용하면 됨.
 * 
 * 	 2. 배열
 *      배열을 기반으로 Stream 생성은 Stream 또는 Arrays 를 사용.
 *      
 *      - 데이터 소스가 참조형 배열(요소가 String 과 같음.)
 *        Stream<T> Stream.of(T... values) // 가변 인자
 *        Stream<T> Stream.of(T[])
 *        Stream<T> Arrays.stream(T[])
 *      
 *      - 데이터 소스가 기본형 배열
 *        IntStream IntStream.of(int... values)
 *        IntStream IntStream.of(int[])
 *        IntStream Arrays.stream(int[])
 * 
 * 	 3. 파일
 *      - Stream 대상에 대한 종류
 *        디렉토리 기준 : 디렉토리에 저장되어 있는 파일 목록
 *           Stream<Path> Files.list(Path dir)
 *        파일 기준 : 파일 하나에 저장되어 있는 행 데이터의 목록
 *           Stream<String> Files.lines(Path path)
 *        파일의 한 행 기준 :
 *           Stream<String> Files.lines()
 *        
 * 	 4. 빈 Stream 생성
 *      Stream emptyStream = Stream.empty();
 *      빈 Stream 은 null 이 아님.
 * 
 */

public class StreamEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
