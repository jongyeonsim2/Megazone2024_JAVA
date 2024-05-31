package ch11;

import java.util.ArrayList;
import static java.util.Collections.*;
import java.util.List;

/**
 * Collections class 활용.
 * 
 * Collection(자료 묶음) 을 쉽게 사용하기 위해 다양함 기능의 메소드가 정의되어 있는 클래스.
 * 
 * - 현재의 Collection 의 인스턴스들은 용도가 데이터 저장용.
 * - 현재는 실행 환경이 싱글쓰레드 임.
 *   프로세스 하나가 데이터 저장소를 전용으로 혼자서 사용하고 있음.
 *   
 *   프로세스 두 개이상 또는 멀티쓰레드가 같은 데이터 저장소를 함께 사용하게 되면 어떻게 될까?
 *   동기화를 맞춘 Collection 을 사용하면 됨. 자바에서 제공되는 동기화 collection 을 사용.
 *   
 *   
 *   
 *   
 * 
 * 
 */


public class CollectionsFWEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 동기화 Collection 메소드임.
		// 메소드 명 앞에 synchronized 로 prefix 가 시작되는 메소드를 사용.
		// 멀티 쓰레드 환경, 다중 프로세스 환경인 경우가 언제인지 만 알면됨.
		// 멀티 쓰레드 환경 : 채팅 서버( 멀티쓰레드 대상 : Socket )
		//							( Collection 관리 대상 : 주고 받는 메세지 )
		//     TCP/IP, Socket( IP, PORT ), 
		//Collections.synchronizedList(null);
		
		
		List list = new ArrayList();
		System.out.println(list);
		
		// Collections 메소스 사용
		addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		
		rotate(list, 2);// 오른쪽으로 2칸을 이동시킴.
		System.out.println(list);
		
		
		swap(list, 0, 2);// 해당 위치의 값 교환
		System.out.println(list);
		
		
		shuffle(list);// 섞기
		System.out.println(list);
		
		
		sort(list);// 정렬
		System.out.println(list);
		
		
		reverse(list);// 역정렬
		System.out.println(list);
		
		
		sort(list, reverseOrder()); // reverse(list)와 동일
		System.out.println(list);
		
		
		int idx = binarySearch(list, 3);// 해당 데이터의 위치값
		System.out.println("index = " + idx);
		
		
		List newList = nCopies(list.size(), 2);// 새로운 배열을 생성 후, 모두 2로 초기화
		System.out.println(newList);
		
		
		System.out.println("max = " + max(list));
		System.out.println("min = " + min(list));
		
		
		fill(list, 9);// 요소를 모두 9로 변경.
		System.out.println(list);
		
		
		replaceAll(list, 2, 1);
		System.out.println(list);
		
	}

}




