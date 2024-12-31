package object.day05;

public class B03MyMathTest {

    public static void main(String[] args) {

        MyMath myMath = new MyMath();
        myMath.first = 234;
        myMath.second = 456;
        System.out.println("myMath.add() : " + myMath.add());  // 690
        System.out.println("myMath.substract() : " + myMath.substract());  // -222

        System.out.println("=== print 메소드 : type 에 따라 +,-,* 중에서 연산 선택하고 출력 === ");
        myMath.print(1); // 234 + 456 = 690
        myMath.print(2); // 234 - 456 = -222
        myMath.print(3); // 234 * 456 = 106704

        System.out.println("=== 메소드 호출할 때 연산 선택하면 문자열 리턴 ===");
        System.out.println(myMath.mathToString(myMath.ADD));
        System.out.println(myMath.mathToString(myMath.SUB));
        System.out.println(myMath.mathToString(myMath.MUL));

        System.out.println("=== 초기값 테스트 ===");
        MyMath temp = new MyMath();  // first, second 필드값이 처음부터 0으로 저장. 
        System.out.println("temp.add() : " + temp.add());  // 0
        System.out.println("temp.add() : " + temp.substract());  // 0
        
    }

}
