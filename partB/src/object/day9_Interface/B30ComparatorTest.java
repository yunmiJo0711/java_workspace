package object.day9_Interface;

import java.util.Arrays;
import java.util.List;

public class B30ComparatorTest {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("sana",23),
            new Member("momo", 27),
            new Member("nayeon", 33),
            new Member("dahyeon", 25)
        );

            // Member[] members = new Member[4];
            // members[0] = new Member("sana",23);
            // members[1] = new Member("momo", 27);
            // members[2] = new Member("nayeon", 33);
            // members[3] = new Member("dahyeon", 25);

        members.sort((m1, m2) -> m2.getAge() - m1.getAge());
        System.out.println(members);



        // members.sort(Comparator.comparing(Member::getName));

        // for(Member member : members){
        //     System.out.println(member.getName() + ":" + member.getAge());
        // }
        
    }

}

class Member {
    private String name;
    private int age;

    Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    
}



