package object.day8;

import java.util.ArrayList;

public class B22ShapeTest {

    public static void main(String[] args) {
        
        Triangle tri = new Triangle(300, 400);
        System.out.println(tri);
        System.out.println("tri 넓이 =" + tri.area() + ", 삼각형의 둘레길이 =" + tri.length());

        Rectangle rec = new Rectangle(100, 50);
        System.out.println(rec);
        System.out.println("rec 넓이 =" + rec.area() + ", 직사각형의 둘레길이 =" + rec.length());
        
        Circle cir = new Circle(30);
        System.out.println(cir);
        System.out.println("cir 넓이 =" + cir.area() + ", 원의 둘레길이 =" + cir.length());

        // 위의 3개의 객체를 모두 하나의 자료구조(배열 또는 리스트)에 저장해야 한다면
        //  => UpCasting
        ArrayList<Shape> list = new ArrayList<>();
        list.add(tri);
        list.add(rec);
        list.add(cir);

        System.out.println("// 인덱스 지정해서 가져오기 //");  // add 가 들어간 순서대로 인덱스 순서 정해짐.
        System.out.println(list.get(0).toString() + "넓이 =" + list.get(0).area());
        System.out.println(list.get(1).toString() + "넓이 =" + list.get(1).area());
        System.out.println(list.get(2).toString() + "넓이 =" + list.get(2).area());

        System.out.println("//for문 반복///");
        for(Shape temp : list){
            System.out.println(temp.toString() + "둘레 길이 =" + temp.length());
        }

    }

}
