package vo.day1;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복을 사용합니다.
@Getter
@Setter
@ToString
@AllArgsConstructor  // 커스텀 생성자  -- App.java 에서 오류남
@NoArgsConstructor   // 기본 생성자 -- App.java 에서 오류 없어짐
public class Customer {
    private String customId;
    private String name;
    private String email;
    private int age;
    private Date regDate;

}

// ORM 프레임웍을 사용하면 기본생성자, Setter 가 필요합니다. 
