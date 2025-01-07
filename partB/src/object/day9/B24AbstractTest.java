package object.day9;

public class B24AbstractTest {
// Shape 과 AbstractShape 비교

    public static void main(String[] args) {
        
        // 1. 부모 객체 생성
        Shape sh = new Shape();
        System.out.println(sh + ", 넓이 =" + sh.area());

        // 2. 부모 객체 생성 불가
        // AbstractShape absh = new AbstractShape();  // 오류

        // 추상 클래스로 익명 클래스 정의
        // AbstractShape 클래스 기본 생성자가 없었으므로 커스텀 생성자로 만듭니다. 인자에 임의의 값 2개 줌.
        // 익명 클래스 : 이름이 없는 클래스. 추상 클래스의 추상 메소드를 new 연산에서 정의 합니다. 
        AbstractShape absh = new AbstractShape(230,450) {

            int radius;  // 반지름. 익명클래스에서 추가로 필드 정의 가능.

            @Override
            public long area() {  // 원의 넓이 
                return (long)((this.radius * this.radius) *3.1419);
            }

            @Override
            public long length() {  // 원의 둘레 
                return (long)(2*3.1419*this.radius);
            }

            public void setRadius(int radius) {
                this.radius = radius;
            }
        };



    }

}
