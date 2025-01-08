package object.day10;

public abstract class AbstractAnimal {
    protected String aniName;
    protected String color;

    AbstractAnimal(String aniName, String color){
        this.aniName = aniName;
        this.color = color;
    }

    public abstract void sound();
    public abstract boolean isFly();
    public abstract String todo(String task);

    @Override
    public String toString() {
        return "AbstractAnimal [aniName=" + aniName + ", color=" + color + ", isFly()=" + isFly() + "]";
    }

}

    class ACat extends AbstractAnimal{
        ACat(String aniName, String color){
          super(aniName, color);
        }
        @Override
        public void sound() {
            System.out.println("미야아옹🐱");
        }
        @Override
        public boolean isFly() {
            return false;
        }
        @Override
        public String todo(String task) {
            return "할 일 :" + task;
        }
    }

    class ADog extends AbstractAnimal{
        ADog(String aniName, String color){
            super(aniName, color);
        }
        @Override
        public void sound() {
            System.out.println("멍멍월월🐶");
        }
        @Override
        public boolean isFly() {
            return false;
        }
        @Override
        public String todo(String task) {
            return "할 일 :" + task;
        }
    }

    class AFrog extends AbstractAnimal{
        AFrog(String aniName, String color){
            super(aniName, color);
        }
        @Override
        public void sound() {
            System.out.println("개굴개굴🐸");
        }
        @Override
        public boolean isFly() {
            return false;
        }
        @Override
        public String todo(String task) {
            return "할 일 :" + task;
        }
    }



    

    
    
