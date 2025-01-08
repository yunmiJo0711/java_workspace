package object.day10;

// day8 Shape 과 동일한 소스파일
public class Shape{

    protected String shName;
    protected int width;
    protected int height;

    public long area(){
        return 0;
    }

    public long length(){
        return 0;
    }

    @Override
    public String toString() {
        return "Shape [shName=" + shName + ", width=" + width + ", height=" + height + "]";
    }
}

class Triangle extends Shape{
    Triangle(int width, int height){
        this.shName="삼각형";
        this.width=width;
        this.height=height;
    }

    @Override
    public long area() {
        // 넓이 계산 
        return (width*height)/2;
    }

    @Override
    public long length() {
        long halfwidth = (long)(width/2.0);  // 반폭
        long sideLength = (long)Math.sqrt(Math.pow(halfwidth, 2) + Math.pow(height, 2));  // 변의 길이
        // 둘레 계산
        return width + 2 * sideLength;
    }
    
}


class Rectangle extends Shape{
    Rectangle(int width, int height){
        this.shName="직사각형";
        this.width=width;
        this.height=height;
    }

    @Override
    public long area() {
        return width * height;
        
    }

    @Override
    public long length() {
        return (width+height)*2;
    }
}


class Circle extends Shape{
    protected int radius; 

    public Circle(int radius){
        this.shName="원형";
        this.radius=radius;
    }

    @Override
    public long area() {
        return (long)(3.1419*radius*radius);
    }

    @Override
    public long length() {
        return (long)(2*3.1419*radius);
    }

    @Override
    public String toString() {
        return "Circle [shName=" + shName + ", radius=" + radius + "]";
    }
}
