package day1;

import java.sql.Connection;
import java.sql.PreparedStatement;

// 예시 : 고객 정보(이메일)를 수정하는 메뉴를 구현하기
public class CustomerMenu1 {

    public static void main(String[] args) {
        System.out.println("==========고객 정보(이메일)를 수정하는 메뉴 입니다.============");
        System.out.println("아이디 입력 >>> ");
        String customid = System.console().readLine();      // ID는 조건식에 쓴다.
        System.out.println("수정할 이메일 주소 입력 >>> ");
        String email = System.console().readLine();

        String sql="UPDATE TBL_CUSTOMER SET email = ? WHERE custom_id = ?";    // update sql.

        // db 연결하여 update 실행하기
        Connection connection = OracleConnectionUtil.getConnection();

        
        // 2) 실행. 매개변수값 전달. 매개변수 인덱스는 sql 문의 ? 의 순서
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, customid);
           
            int result = pstmt.executeUpdate();
            System.out.println("result : " + result);
            if(result ==1)
                System.out.println("고객님 정보가 업데이트 완료했습니다.");
            else
                System.out.println("고객님 아이디 정보가 없습니다.");

        } catch (Exception e) {
            System.out.println("Update 예외 : " + e.getMessage());
        }

        OracleConnectionUtil.close(connection);

    }

}
