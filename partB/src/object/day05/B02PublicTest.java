package object.day05;

public class B02PublicTest {

    public static void main(String[] args) {
        MyClass1 cls1 = new MyClass1();
        MyClass2 cls2 = new MyClass2();

        System.out.println("참조형 변수에 저장된 값 확인 ---");
        System.out.println(cls1);  // object.day05.MyClass1@28a418fc
        System.out.println(cls2);  // object.day05.MyClass2@5305068a
    }
}
