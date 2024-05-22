package ch4;

/**
 * 조건문
 * - if, switch
 * - if - else if - else
 * - 중첩 조건문 => 가독성을 고려해야 함. 리팩토링을 고려해야 함.
 * 
 *   OOP > 클래스 설계 ( DDD, TDD )
 * 
 *   if
 *      코드가 1000 line
 *      
 *      if
 *          코드가 1000 line
 *      else
 *          코드가 1000 line
 *   else
 *      코드가 1000 line
 * 
 * 
 * 반복문
 * - for, while 
 *   => foreach, stream, 람다 를 적용할 수 없는지 고려.(리팩토링)
 *   => 코드 품질이 향상됨.
 * - for
 *   for( 초기화; 조건식; 증감식){
 *   }
 * - 향상된 for
 * - while
 *   while(조건식) { }
 *   반복 처리 실행하기 전에 조건이 만족하는지 확인.
 *   
 * - do while(조건식)
 *   조건 확인 없이 한 번 실행한 후 반복 조건이 만족하는지 확인.
 * - 반복문 제어
 *   break : 반복문 종료 용도
 *   continue : 반복은 유지하되 조건에 해당되면 건너뛰기 용도.
 *   이름 붙은 반복문 : 가독성이 낮음. 리팩토링 대상.
 * - 무한반복
 *   for(;;) {
 *   	경우에 따라 무한반복 조건 체크 후 종료.
 *   }
 *   
 *   
 *   while(true) {
 *   	경우에 따라 무한반복 조건 체크 후 종료.
 *   }
 *   
 */
public class FlowEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (0 < 10) {
			System.out.println("0은 10보다 작음.");
		} else {
			System.out.println("0은 10보다 작지 않음.");
		}
		
		if (0 < 10) {
			System.out.println("0은 10보다 작음.");
		}
		
		if (0 > 10) {
			System.out.println("0은 10보다 작음.");
		}
		
		int a = 10;
		
		if (a == 10) {
			
		} else if (a > 10) {
			
		} else if (a > 100) {
			
		} else {
			
		}
		
		if (0 < 10) {
			System.out.println("0은 10보다 작음.");
			
			if (0 < 100) {
				
			}
		}
		
		// switch
		// 1. 조건식을 계산 
		//    조건식의 결과는 정수 상수 또는 문자열
		// 2. 조건의 결과와 맞는 case 로 이동
		// 3. 이후의 문장을 실행
		// 4. break 를 만나기 전까지 실행.
		
		// 중첩 switch는 가독성을 악화시킴.
		switch (3) {
		case 3 :
			System.out.println("3");
			break;
		case 2 :
			System.out.println("2");
		case 1 :
			System.out.println("1");
		}
		
		
		// for 반복문
		for(int i = 1; i<=5; i++)
			System.out.println(i);

		
		for(int i = 1; i<=5; i++) {
			System.out.println(i);
			
			if (i == 3) break;
		}
		
		// 배열 처리하는 경우 => for 활용
		int[] arr = {1,2,3,4,5}; // 배열의 요소가 5개. 요소의 위치값. 정수
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		// 배열 처리하는 경우 => 향상된 for 활용
		// 배열과 collection 에서 활용.
		for(int tmp : arr)
			System.out.println(tmp);
		
		// while 문
		int i = 1;//반복의 초기화
		
		while(i<=5) {//조건식
			System.out.println(i);
			i++;//증감식
		}
		
		i = 5;
		
		// 후위형 : 참조 후에 증감 
		while(i--!=0) { // 4, 3, 2, 1, 0
			System.out.println(i);// 먼저 참조 후 조건판단.
		}
		
		i = 5;
		
		// 전위형 : 참조 전에 증감
		while(--i!=0) { // 4, 3, 2, 1
			System.out.println(i);// 증감 후 조건 판단.
		}
		
		// 어쩌다 보니 이런 경우가....
		for(i = 0; i<5; i++);// 괄호 뒤에 ; 가 있음.
		
		
		{ // for 문의 block 이라고 생각하지만, ; 인해서 그냥 block로.
			System.out.println(i);
		}
		
		// continue 사용
		for(i = 0; i <= 10; i++)
		{
			//반복제어
			if (i%3 == 0) 
				continue; //건너뛰기 용도
			
			System.out.println(i);
		}
		
		// 이름 붙은 반복문
		for(i = 2; i <= 9; i++)
			if(i==7) break;
		
		// 가능하면 다른 방법으로 구현.
		Loop1 :for(i = 2; i <= 9; i++)
			if(i==7) break Loop1;
		
	}

}
