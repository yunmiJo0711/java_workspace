package day1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PreparedStatementTest {

    public static void main(String[] args) {
        
        Connection connection = OracleConnectionUtil.getConnection();

        String sql="INSERT INTO TBL_CUSTOMER(custom_id, name, email, age, reg_date )" + 
                   "VALUES (?, ?, ?, ?, sysdate)";
                   //           sql 명령문은 미리컴파일하여 PreparedStatement 객체가 생성됩니다. 
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {    // 컴파일을 먼저한다. 

            // sql 실행에 필요한 값은 파라미터로 전달. ? 는 파라미터(또는 매개변수) 기호입니다. 
            // ? (파라미터) 의 순서와 타입을 지정. 타입은 setXXX 메소드로 정합니다. 
            pstmt.setString(1, "nayeon");
            pstmt.setString(2, "최나연");
            pstmt.setString(3, "nay@gmail.com");
            pstmt.setInt(4, 24);

            pstmt.executeUpdate();  // sql 실행 

        } catch (Exception e) {
           System.out.println("SQL 실행 예외 : " + e.getMessage());
        }

        OracleConnectionUtil.close(connection);

    }

}
