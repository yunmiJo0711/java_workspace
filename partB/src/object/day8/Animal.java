package object.day8;

// 재정의를 할 때에는 super 를 꼭 사용해야한다. 부모가 물려준걸 그대로 써야한다. 
public class Animal {

    protected String aniName;
    protected int age;
    protected String color;

    public void sound(){
        System.out.println("동물 소리 들어보기//");
    }

    // 부모 클래스에서 toString 은 자식 클래스에 상속.
    @Override
    public String toString() {
        return "Animal [aniName=" + aniName + ", age=" + age + ", color=" + color + ", hashCode()=" + hashCode() + "]";
    }

}

class Eagle extends Animal{
    // 물려받은 인스턴스 필드의 초기값 저장 
    Eagle(){
        this.aniName="독수리"; // 여기서는 this, super 모두 가능.
        this.age=15;
        this.color="brown";
    }

    // 1. 자식 클래스(Eagle)의 인스턴스 메소드 
    public void fly(){
        System.out.println("시속 100km 로 날 수 있습니다. ");
    }
    // 2. 부모 클래스(sound())의 인스턴스 메소드 재정의
    @Override
    //  ㄴ 애노테이션으로 재정의 메소드의 문법(형식) 체크
    public void sound() {
        super.sound();
        System.out.println("🦅 휘이이잉");
    }
}

class Frog extends Animal{
    // 물려받은 인스턴스 필드의 초기값 저장 
    Frog(){
        this.aniName="청개구리";
        this.age=1;
        this.color="초록점박이";
    }

    // 1. 자식 클래스의 인스턴스 메소드 
    public void jump(){
        System.out.println("높이 1m 로 점프 할 수 있습니다. ");
    }
    // 2. 부모 클래스의 인스턴스 메소드 재정의
    @Override
    public void sound() {
        super.sound();
        System.out.println("🐸개굴개굴");
    }
}

class Dog extends Animal{
    // 물려받은 인스턴스 필드의 초기값 저장 
    Dog(){
        this.aniName="푸들";
        this.age=5;
        this.color="밀키브라운";
    }

    // 1. 자식 클래스의 인스턴스 메소드 
    public void home(){
        System.out.println("집을 잘 지킵니다. ");
    }
    // 2. 부모 클래스의 인스턴스 메소드 재정의
    @Override
    public void sound() {
        super.sound();
        System.out.println("🐶멍멍멍멍");
    }

}