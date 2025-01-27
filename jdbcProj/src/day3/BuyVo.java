package day3;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 구매 테이블과 매핑할 vo 클래스
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BuyVo {
    private int buy_seq;
    private String custom_id;
    private String pcode;
    private int quantity;
    private Date buy_date;

}
