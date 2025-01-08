package object.day10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class B33FunctionalInterface {

    public static void main(String[] args) {

        // 1. Runnable 타입 익명 클래스를 람다식으로 정의
        //     ㄴ 리턴과 인자가 둘 다 없는 추상메소드 run()를 갖는다.
        Runnable runnable = () -> System.out.println("현재 시간 : " +  new Date());
        // 실행
        runnable.run();

        // 2. Consumer<T> 타입 익명 클래스를 람다식으로 정의
        //        ㄴ T 는 인자의 타입 설정. void accpet(T t) 추상 메소드를 갖는다.
        Consumer<String> consumer = (message) -> System.out.println("메시지 = " + message);
        // 실행
        consumer.accept("굿바이~~");

        // 3. Supplier<T> 타입 익명 클래스를 람다식으로 정의
        //         ㄴ T 는 리턴 타입. T get() 추상 메소드를 갖는다.
        Supplier<Long> supplier = () -> System.currentTimeMillis();   // return 생략
        // 실행
        System.out.println(supplier.get());

        // 4. Function<T,R> 타입 익명 클래스를 람다식으로 정의
        //         ㄴ T는 인자 타입, R은 리턴 타입. R apply(T t) 추상 메소드를 갖는다.
        Function<Double,Double> function = (d) -> Math.pow(2, d);   // return 생략
        // Math.pow(a,b) 는 a 의 b승 구합니다. 
        // 실행
        System.out.println(function.apply(10.0));  // 2의 10승


        System.out.println("함수형 인터페이스가 인자인 예시//");
        List<String> members = new ArrayList<>();
        members.add("사나"); members.add("모모"); members.add("나연"); members.add("다현");
        System.out.println(" // for 문 //");
        for(String temp : members){
            System.out.println(temp);
        }

        System.out.println("// 리스트의 forEach 메소드 //");
        members.forEach(consumer);  // members 리스트의 항목을 순서대로 consumer의 인자로 전달.

        members.forEach(
            (item) -> System.out.println("*" + item + "*")  // 인자를 받아서 출력하는 추상메소드 구현.
        );
    }

}
