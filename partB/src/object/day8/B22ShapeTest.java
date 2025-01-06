package object.day8;

public class B22ShapeTest {

    public static void main(String[] args) {
        
        Triangle tri = new Triangle(300, 400);
        System.out.println(tri);
        System.out.println("tri 넚이 =" + tri.area() + ", 삼각형의 둘레길이 =" + tri.length());

        Rectangle rec = new Rectangle(100, 50);
        System.out.println(rec);
        System.out.println("rec 넚이 =" + rec.area() + ", 직사각형의 둘레길이 =" + rec.length());
        
        Circle cir = new Circle(30);
        System.out.println(cir);
        System.out.println("cir 넚이 =" + cir.area() + ", 원의 둘레길이 =" + cir.length());

    }

}
