package ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 컬렉션 프레임워크(Collections Framework)
 * 
 * 데이터 집합을 저장하는 클래스들을 표준화한 설계.
 * 
 * 컬렉션 : 데이터 집합, 그룹
 * 프레임워크 : 표준화된 프로그래밍 방식
 * 
 * 핵심 인터페이스 : 
 * 		Collection : List, Set 의 기반.
 * 					컬렉션 클래스에 저장된 데이터를 읽고, 추가, 삭제 하는 등
 * 				컬렉션(데이터 집합)을 다루는데 가장 기본적인 메소드를 정의하고 있음.
 * 
 * 		List : 순서가 있는 데이터 집합. 중복 허용. 
 * 				ArrayList, LinkedList, Stack, Vector 등
 * 
 * 				LinkedList
 * 					class Node {
 * 						Node next; // 다음의 Node 를 가르키는 정보.
 * 									// 단방향 LinkedList 임을 알 수 있음.
 * 						Object obj;
 * 					}
 * 
 * 				ArrayList 와 LinkedList 차이점
 * 					- 접근시간(읽기) : ArrayList 가 빠름.
 * 					- 삭제 : LinkedList 가 빠름.
 * 
 * 
 * 				Stack
 * 					- LIFO(Last In First Out) 
 * 					- 단방향 구조(위에서 밑으로만)
 * 
 * 				Queue
 * 					- FIFO(First In First Out)
 * 					- 단방향 구조(위에서 밑으로만)
 * 
 * 				Deque(Double Ended Queue)
 * 					- 양방향 구조(위 아래로 가능)
 * 					
 * 
 * 				Iterator
 * 					컬레션 프레임워크에서 컬렉션에 저장된 데이터를 읽어오는 방법을 표준화.
 * 
 * 					종류 : Iterator, Enumeration, ListIterator
 * 					차이점 : Enumeration 은 Iterator 의 구버전.
 * 							ListIterator 는 Iterator 를 상속받아서 기능을 추가적으로 구현.
 * 
 * 							따라서, Enumeration 은 regacy 코드의 유지를 위해서 사용.
 * 							신규 개발에서는 ListIterator or Iterator 를 사용.
 * 
 * 					메소드 : hasNext(), next(), remove()
 * 							=> for 문을 사용하지 않고도 탐색이 가능.
 * 							=> 표준화된 개발이 가능. 재사용성, 코드의 일관성, 코드 품질
 * 
 * 
 * 				Comparator, Comparable : 컬렉션의 정렬과 관련된 기능.
 * 					현재 기본 정렬 오름차순으로 되어 있음.
 * 
 * 
 * 		Set : 순서를 유지하지 않음. 중복 허용하지 않음.
 * 				HashSet, TreeSet 등 
 * 
 * 				HashSet : 저장 순서를 유지하려고 하면, LinkedHashSet 을 사용.
 * 
 * 
 * 				TreeSet : 이진 검색 트리.
 * 						정렬, 검색, 범위 검색에 높은 성능 보임.
 * 						중복된 데이터의 저장을 허용하지 않음.
 * 						각 노드에 최대 2개의 노드를 연결할 수 있음.
 * 						Root 라고 하는 하나의 노드로부터 시작해서 확장.
 * 						노드 간의 관계.(부모-자식)
 * 
 * 						class TreeNode {
 * 							TreeNode left;
 * 							Object element;
 * 							TreeNode right;
 * 						}
 * 
 * 						단점 : 노드의 추가 삭제에 시간이 걸림.
 * 
 * 		Map : 키(key)와 값(value)의 쌍으로 이루어진 데이터 집합.
 * 			순서 유지하지 않음. 키 중복 허용하지 않음. 값은 중복 허용.
 * 				HashMap, TreeMap, HashTable, Properties 등	
 * 
 * 				- HashMap
 * 					데이터 저장 형태가 선형구조로 저장.
 * 					탐색방법은 순차 탐색으로 진행. 검색 성능이 낮음.
 * 					
 * 				- TreeMap
 * 					데이터 저장 형태가 이진 구조(왼쪽, 오른쪽)로 저장.
 * 					이진 탐색으로 진행. 검색 성능이 좋음.
 * 
 * 				- Properties
 * 					key, value 가 String 임.
 * 					Iterator 가 Enumeration 임.
 * 					
 * 
 * 
 * 
 */

public class CollectionsFWEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ArrayList
		ArrayList list1 = new ArrayList(5);
		list1.add(5);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		System.out.println("list1 : " + list1);
		
		// 정렬
		Collections.sort(list1);
		System.out.println("list1 : " + list1);
		
		//다른 데이터 유형 저장
		list1.add(3, "A");
		System.out.println("list1 : " + list1);
		
		Collections.shuffle(list1);
		System.out.println("list1 : " + list1);
		
		
		
		
		// LinkedList // 데이터가 노드 구조로 연결됨. => 다음 데이터 탐색시 참조해서 이동.
		LinkedList ll = new LinkedList();
		
		// 탐색 속도 비교 대상 // 데이터의 시작과 끝 사이까지 전부 데이터
							//	다음 데이터 탐색시 참조해서 이동과 같은 탐색 작업이 없음.
							//  
							// 배열 단점 : 크기가 고정. 저장 공간의 확장성이 없음.
							// 
							// 그래서, 배열의 단점을 개선한 ArrayList 는
							// 저장 공간의 확장이 자유로움.
							// 
							// 단점 : 기존의 배열에 공간이 없으면,
							//		새로운 배열을 생성 후 기존 배열의 데이터를 복사
							// 
							// 고려사항
							//        저장된 대상의 데이터가 작으면 괜찮음.
							//		대량의 데이터의 경우는 고려해야 함.
							// 
							// 데이터 수정, 추가, 삭제 시 발생하는 성능과 관련해서 확장해서 물어볼 수 있음.
		
		ArrayList al = new ArrayList(100000);
		
		// list 에 데이터 저장
		add(ll);
		add(al);
		
		// 탐색 시간 확인
		System.out.println("LinkedList : " + access(ll) );
		System.out.println("ArrayList : " + access(al));
		
		
		
		//-------------------- Iterator 사용 -----------------------
		ArrayList list2 = new ArrayList();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		
		Iterator it = list2.iterator();
		
		// 표준화된 데이터 탐색이 가능해짐.
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		// ListIterator : Iterator 을 개선. 양방향 탐색이 가능.
		ListIterator lit = list2.listIterator();
		
		// 순방향 탐색
		while(lit.hasNext()) {
			System.out.println(lit.next());
		}
		
		System.out.println();
		
		// 역방향 탐색
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
		
		
		//-------------------- Comparator, Comparable -----------------------
		// 기본형 타입
		// 우리한테 의미 있는 것은 값이 10.
		int a = 10;
		
		// 참조형 타입
		// 우리한테 의미 있는 것은 값이 10.
		// 랩퍼 클래스 : 기본형 int 객체로 관리하고 싶은 경우 제공되는 클래스
		Integer ii = new Integer(10);
		
		ii.compareTo(ii);
		
		// 정렬
		String[] strArr = {"cat", "Dog", "loin", "tiger"};
		
		// sort() 메소드의 기본 정렬은 오름차순임.
		// 내림차순으로 정렬하려는 경우
		// 1. Comparator interface 를 구현 클래스 작성.
		//    compare 메소드를 내림차순 되도록 재정의
		// 2. Arrays 에서 제공되는 sort() 중에서
		//	  Comparator 타입의 매개변수가 있는 메소드를 선택.
		// 3. 구현된 Comparator 클래스를 이용해서
		//	  sort() 메소드의 매개변수로 적용해서 사용.
		
		Arrays.sort(strArr);
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		// 내림차순 정렬
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		
		
		
		
		//---------------- HashSet ------------------------
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4"};
		Set set = new HashSet();
		
		for(int i=0; i<objArr.length; i++) {
			set.add(objArr[i]);
		}
		
		System.out.println(set);
		
		
		
		//---------------- TreeSet ------------------------
		Set treeSet = new TreeSet();
		
		
		for (int i=0; treeSet.size() < 6 ; i++) {
			int num = (int)(Math.random()*45) + 1;
			treeSet.add(num);
		}
		
		System.out.println(treeSet);
		
		
		
		//---------------- HashMap ------------------------
		// HashMap을 사용한 데이터 탐색
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		
		String id = "myId";
		String password = "1234";
		
		if(!map.containsKey(id))// id 가 존재, 존재하지 않는 경우
		{
			System.out.println("입력된 ID 는 존재하지 않음.");
			//continue;
		} else {
			if (!(map.get(id)).equals(password)) {
				System.out.println("비밀번호가 틀림.");
			} else {
				System.out.println("id 와 비밀번호가 일치.");
			}
		}	
		
		
		
		// HashMap에서 Iterator 사용.
		HashMap map2 = new HashMap();
		map2.put("김자바", 90); // 90 정수 상수 -> Object
								// 형변환 : 작은 -> 큰것 (자동형변환)
								// 90 -> Integer
								// Integer : int 도 객체로 사용하고 싶은 경우.
								// Integer 도 클래스이기 때문에, 
								// 자동으로 Object 를 상속 받게 됨.
		map2.put("이자바", 99);
		map2.put("박자바", 70);
		map2.put("홍자바", 60);
		map2.put("안자바", 100);
		
		// iterator 사용하기 위해서
		// 1. HashMap 에서 set 을 가져옴.
		// 2. set에서 iterator 를 가져옴.
		Set set2 = map2.entrySet();
		Iterator it2 = set2.iterator();
		
		while(it2.hasNext()) {
			// map에서 key, value 를 함께 사용하기 위한 타입 : Entry
			Map.Entry entry = (Map.Entry)it2.next();
			System.out.println("이름 : " + entry.getKey() + 
					", 점수 : " + entry.getValue());
		}
		
		// HashMap 에서 value 만 출력.
		// 점수 집합 => 총점계산 으로 활용
		// 학생 집합 => 학생 명수 로 활용
		
		// 총점 계산
		Collection values = map2.values();
		it2 = values.iterator();
		
		int total = 0;
		
		while(it2.hasNext()) {
			Integer grade = (Integer)it2.next();// down casting
			total += grade.intValue();
		}
		
		System.out.println("총점 : " + total);
		
		// 학생 집합 처리
		set = map2.keySet();
		System.out.println("학생 명부 : " + set);
		
		// set.size() : 요소 개수.
		System.out.println("평균 : " + (float)total/set.size());
		
		// 최고점수
		System.out.println("최고 점수 : " + Collections.max(values));
		
		// 최하점수
		System.out.println("최하 점수 : " + Collections.min(values));
		
		// 학원관리 서비스
		// 1. 학생리스트 메모리에 두고 계속 사용할 것인가? (in memory)
		// 2. 학생리스트 를 DB에 두고 계속 사용할 것이가? (out memory)
		// 3. 학생리스트 를 in memory 와 out memory 를 함께 사용할 것인가?
		// 		in memory 와 out memory 의 데이터의 동기화는 어떻게 할 것인가?
		// 4. 서비스별로 in memory 와 out memory 를 사용이 필요한가?
		//    MSA( MicroServiceArchitecture )
		// 5. 모놀리식의 MSA 를 할 것인가? 아니면, 클라우드 기반의 MSA 를 할 것인가?
		//    엄청난 서비스이면서, 고객수가 엄청남, 글로벌 서비스 => 클라우드 기반의 MSA
		//    DDD, TDD, 애자일 등등등.....
		
		
		// ERP( 전사적 자원 관리 시스템, 회계 시스템 ) => sap, 더존, 영림원, oracle
		//												메가존 클라우드, 베스핀
		// 더존 도 클라우드 기반의 ERP
		// 쿠팡, 삼성전자, CJ 대한통운
		
		// ERP 정보관리사 1급( 업무지식, 더존 ERP ) 
		// 회계, 생산, 물류, 인사
		
		
		
		
		//---------------- TreeMap ------------------------
		
		String[] data = {"A","K","A","K","D","K","A","Z","K","K","Z","D","D","D"};
		
		TreeMap treeMap = new TreeMap();
		
		// 문자별 빈도수 결과
		/**
		 * A : 3
		 * K : 5
		 * D : 2
		 * Z : 2
		 */
		
		TreeMap treeMap2 = new TreeMap();
		
		for(int i=0; i < data.length; i++) {
			// 배열의 문자가 map 에 key 로 존재?
			if(treeMap2.containsKey(data[i])) {
				// 빈도수 증가를 위해서 현재의 빈도수 조회
				Integer value = (Integer)treeMap2.get(data[i]);
				// 현재의 빈도수 + 1 한 값을 해당의 key에 저장.
				treeMap2.put(data[i], new Integer(value.intValue() + 1));
				
				// http 통신시 put 함수 역할.
				// get(조회), post(등록), put(수정), delete(삭제)
				
			} else {
				// treeMap2 의 키로 등록
				treeMap2.put(data[i], new Integer(1));
			}
		}
		
		// Iterator 를 활용해서 출력.
		Iterator it3 = treeMap2.entrySet().iterator();
		
		while(it3.hasNext()) {
			Map.Entry entry = (Map.Entry)it3.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 빈도수를 내림차순으로 정렬해서 출력.
		// 1. Collections.sort()
		//    sort() 의 기본 정렬은 오름차순임.
		// 2. Comparator 인터페이스를 구현. ( 오름차순의 반대 )
		// 3. Collections.sort() 에 매개변수로 구현한 Comparator을 매개변수로 대입.
		// 4. Collections.sort() 의 첫 번째 매개변수가 List 임.
		//    따라서, map 을 list 로 변경.
		//    List 의 구현체인 ArrayList 가 되도록 함. => ArrayList 의 복사 생성자.
		
		/**
		 * 1. map -> list
		 * 		list 는 인터페이스 임.
		 * 		복사생성자를 활용. 구현체가 있어야 복생성자를 활용.
		 * 		ArrayList 클래스에서 복사생성자 가 있는지 확인.
		 * 
		 * 		ArrayList(Collection<? extends E> c)
		 * 
		 * 		복사생성자의 매개변수가 Collection 임. 바로 사용 못함.
		 * 		Collection - List - ArrayList
		 * 					- Set 
		 * 
		 * 		map -> Collection(list or set) -> list 
		 * 				entrySet() -> set
		 * 
		 */
		
		Set set3 = treeMap2.entrySet();
		List list = new ArrayList(set3);
		
		// 내림차순 정렬
		Collections.sort(list, new Descending2());
		
		it3 = list.iterator();
		
		while(it3.hasNext()) {
			Map.Entry entry = (Map.Entry)it3.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// Properties
		Properties prop = new Properties();
		
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "20");
		prop.setProperty("timeout", "30");
		
		Enumeration e = prop.propertyNames();
		
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();
			System.out.println(element + " - " + prop.getProperty(element));
		}
		
	}

	// list 에 데이터 저장.
	public static void add(List list) {
		for (int i=0; i<100000;i++) list.add(i+"");
	}
	
	// list 를 탐색.
	public static long access(List list) {
		long start = System.currentTimeMillis();
		
		// 시작 노드에서 마지막 노드까지 이동하면서 탐색
		for(int i=0; i<100000; i++) list.get(i);
		
		long end = System.currentTimeMillis();
		
		//탐색 시간(조회 시간)
		return end - start;
	}
	
}


// 역방향 정렬을 위한 클래스. Comparator interface 를 구현하면 됨.
class Descending implements Comparator {
	public int compare(Object o1, Object o2) {
		if ( o1 instanceof Comparable && o2 instanceof Comparable )	{
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			return c1.compareTo(o2) * -1;
		}
		
		return -1;
	}
}

class Descending2 implements Comparator {
	public int compare(Object o1, Object o2) {
		//Map 의 key, value 중에서 의미있게 정렬하려면, 비교 대상이 value 로 해야 함.
		if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
			// key, value 의 한 쌍 => Entry
			Map.Entry e1 = (Map.Entry)o1;
			Map.Entry e2 = (Map.Entry)o2;
			
			Integer v1 = (Integer)e1.getValue();
			Integer v2 = (Integer)e2.getValue();
			
			return v1.compareTo(v2) * -1;
			
		}
		
		return -1;
	}
}


