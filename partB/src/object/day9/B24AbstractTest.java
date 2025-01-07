package object.day9;

public class B24AbstractTest {
// Shape 과 AbstractShape 비교

    public static void main(String[] args) {
        
        // 1. 부모 객체 생성
        Shape sh = new Shape();
        System.out.println(sh + ", 넓이 =" + sh.area());

        // 2. 부모 객체 생성 불가 : AbstractShape 는 추상 클래스라서 추상 메소드 정의가 안되어 있기 때문에. =>추상 메소드가 있어야함.
        // AbstractShape absh = new AbstractShape();  // 오류

        System.out.println("추상 클래스 테스트 // ");
        AbstractShape tri = new ATriangle(45, 34);
        System.out.println(tri);

        AbstractShape rec = new ARectangle(45, 34);
        System.out.println(rec);

        // 3. 추상 클래스로 익명 클래스 정의
        // AbstractShape 클래스 기본 생성자가 없었으므로 커스텀 생성자로 만듭니다. 인자에 임의의 값 2개 줌. (쓸모는 없음)
        // 익명 클래스 : '이름이 없는 자식 클래스'. 추상 클래스의 추상 메소드를 new 연산에서 정의 합니다. 
        //              -> 클래스 정의를 하면서 객체를 생성합니다. 
        AbstractShape absh = new AbstractShape(0,0) 
        // AbstractShape 의 자식 클래스 (익명(이름이 없음) 클래스 정의 부분) - 이름이 없어서 재사용 못함.(1회용)
        {  
            int radius = 20;  // 반지름. 익명 클래스에서 추가로 필드(지역변수) 정의 가능.
            @Override  
            public long area() {  // 원의 넓이 
                return (long)((this.radius * this.radius) *3.1419);
            }

            @Override
            public long length() {  // 원의 둘레 
                return (long)(2*3.1419*this.radius);
            }

            // 익명 클래스 내용에 맞게 toString 재정의 하기 
            @Override
            public String toString() {
                return "AbstractShape [반지름 =" + radius + ", 원의 둘레 =" + length() + 
                ", area()=" + area() + ", getClass()=" + getClass() + "]";
            }


        };  // 익명 클래스 end

        System.out.println(absh);
        // AbstractShape [width=230, height=450, area()=1256, getClass()=class object.day9.B24AbstractTest$1]

    } // main end

}
