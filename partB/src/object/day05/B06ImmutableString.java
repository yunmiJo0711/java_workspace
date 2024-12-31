package object.day05;

import java.net.Socket;

// 3, 3.14, 'a', "hello" 값은 불변값 (자바스크립트 등 일반적 언어)
// 메모리의 변수에 저장된 값은 변경 가능.
public class B06ImmutableString {

        // 자바에서는 문자열이 String 클래스 타입. => 불변성을 갖는 객체
        //            일반적으로 객체는 요소값을 변경할 수 있습니다. (불변성 아님)

        public static void main(String[] args) {
            
            String massage = "Hello";
            System.out.println("massage 변수의 주소참조값");
            System.out.println(Integer.toHexString(massage.hashCode()));

            massage += " java";
            System.out.println("massage 변수의 주소참조값");
            System.out.println(Integer.toHexString(massage.hashCode()));

            // massage 변수가 저장한 주소 참조값이 변경. -> 저장된 메모리 위치 변경됌.
            // 한 번 저장된 문자열이 연산으로 바뀌면 같은 주소에 저장하지 않는다.
            // => 불변성

            System.out.println("이름 : " + "홍길동" + ", 나이 : " + 23);

            // 1) + 연산을 대체하는 다른 방법 첫번째 
            System.out.println(String.format("이름 : %s, 나이 : %d", 
                    "홍길동",23));

            // 2) + 연산을 대체하는 다른 방법 두번째 - 문자열 추가를 반복할 때
            System.out.println("=== 값이 변할 수 있는 객체 사용하기 ===");
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<4;i++){
                sb.append("Hello ");  // 문자열 연결 + 연산과 동일
                System.out.println("sb 참조값: " + Integer.toHexString((sb.hashCode())));
            }
            System.out.println(sb);
            System.out.println(sb.toString());
        }

}
