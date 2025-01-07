package object.day9;

// abstaract 부모 클래스
public abstract class AbstractShape {
    // 필드, 생성자, 인스턴스 메소드 동일하게 정의 가능 합니다. 
    protected int width;
    protected int height;

    AbstractShape(int width, int height){  // 커스텀 생성자 만들었음. (기본 생성자 x)
        this.width=width;
        this.height=height;
    }

    // ※ 형식만 선언한 추상 메소드가 있는 클래스가 추상 클래스
    public abstract long area();
    public abstract long length();

    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    

}

// 추상 클래스 상속할 때 반드시 모든 추상 메소드 재정의 해야함.
class ARectangle extends AbstractShape{

    ARectangle(int width, int height){
        super(width, height);      // 부모의 기본 생성자 없으므로 기본 생성자 대신에 '부모의 커스텀 생성자 호출하기' 
    }

    @Override
    public long area() {
        return this.width * this.height;
    }

    @Override
    public long length() {
        return (this.width+this.height)*2;
    }

}

class ATriangle extends AbstractShape{

    ATriangle(int width, int height){
        super(width, height);
    }

    @Override
    public long area() {
        return (width * height)/2;
    }

    @Override
    public long length() {
        long halfwidth = (long)(width/2.0);
        long sideLength = (long)Math.sqrt(Math.pow(halfwidth, 2) + Math.pow(height, 2));

        // 둘레 계산
        return width + 2 * sideLength;
    }
}
