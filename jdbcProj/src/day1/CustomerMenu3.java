package day1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerMenu3 {

    public static void main(String[] args) {
        System.out.println("==========고객 등록 (회원 가입) 메뉴 입니다.============");
        System.out.println("아이디 입력 >>> ");
        String customid = System.console().readLine();
        System.out.println("이름 입력 >>> ");
        String name = System.console().readLine();
        System.out.println("이메일 입력 >>> ");
        String email = System.console().readLine();
        System.out.println("나이 입력 >>> ");
        int age = Integer.parseInt(System.console().readLine());

        Connection connection = OracleConnectionUtil.getConnection();

        String sql = "INSERT INTO TBL_CUSTOMER(custom_id, name, email, age, reg_date) " +
                    "VALUES (?,?,?,?,sysdate)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "yunmi66");
            pstmt.setString(2, "조윤미");
            pstmt.setString(3, "yunmi66@naver.com");
            pstmt.setInt(4, 23);

            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("SQL 실행 예외 : " + e.getMessage());
        }
        OracleConnectionUtil.close(connection);



    }

}
