package object.day8;

import java.util.ArrayList;

public class ShapeTest {

    public static void main(String[] args) {
        
        Shape triangle = new Shape();
        Shape rectangle = new Shape();
        Shape circle = new Shape();
        

        ArrayList<Shape> farm = new ArrayList<>();

        farm.add(triangle);
        farm.add(rectangle);
        farm.add(circle);

        System.out.println("도형 : " + farm.size() + "cm");
        for(Shape sh : farm){
            System.out.println(sh);
            sh.area();
            sh.length();
            System.out.println("=====");
        }

    }

}
