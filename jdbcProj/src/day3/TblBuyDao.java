package day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TblBuyDao {

   // db 연결 정보를 상수로 정의합니다.
   private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
   private static final String USERNAME = "c##idev";
   private static final String PASSWORD = "1234";

   // db 연결 객체 만드는 메소드 dao 에서만 사용할 수 있도록 정의
   private Connection getConnection() throws SQLException{
       return DriverManager.getConnection(URL, USERNAME, PASSWORD);
   }

   public int insertOne(BuyVo vo){
    int result=0;
    String sql="INSERT INTO tbl_buy VALUES(tbl_buy_sql.nextval, ?, ?, ?, sysdate)";
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getCustom_id());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());
            result=pstmt.executeUpdate();
        
    } catch (Exception e) {
        System.out.println(" 예외  : " + e.getMessage());
    }
        return result;
   }



}
