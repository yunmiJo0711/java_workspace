package object.day7;

public class B16ToStringTest {

    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("사나");
        System.out.println("stu1 : " + stu1); // object.day7.Student@2f92e0f4  => toString() 이 없을 때 이렇게 출력됌.
        System.out.println("stu1.toStudent() : " + stu1.toStudent());
        
    }

}

class Student {

    private String name;
    public void setName(String name){
        this.name = name;
    }

    public String toStudent(){
        return "학생 이름은 " + this.name + " 입니다.";
    }

    // toString() 은 특별한 메소드입니다. 
    // toString() 메소드가 있으면 객체변수를 출력할 때, 참조값이 아니라 메소드에서 리턴한 문자열 출력
    public String toString(){
        return "My name is" + this.name;
    }

}
