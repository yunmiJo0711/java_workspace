package object.day05;

public class Rectangle {

    String shapeName;
    int width;
    int height;

    public int getArea(){
        return width * height;
    }
    public int getLength(){
        return(width+height)*2;
    }
    
    public String draw(String emogi){
        return String.format("%s %s (%d x %d) 를 그립니다.", 
                            this.shapeName,emogi,this.width,this.height);
    }

}
