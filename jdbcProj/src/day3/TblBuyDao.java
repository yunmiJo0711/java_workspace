package day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TblBuyDao {

   // db 연결 정보를 상수로 정의합니다.
   private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
   private static final String USERNAME = "c##idev";
   private static final String PASSWORD = "1234";

   // db 연결 객체 만드는 메소드 dao 에서만 사용할 수 있도록 정의
   private Connection getConnection() throws SQLException{
       return DriverManager.getConnection(URL, USERNAME, PASSWORD);
   }

   public int insertMany(List<BuyVo> cart){  // 장바구니 목록을 인자로 받기 
    int count=0;
    String sql="INSERT INTO tbl_buy VALUES(tbl_buy_sql.nextval, ?, ?, ?, sysdate)";
    Connection connection = null;
    try  {
        connection=getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
            // 수동 커밋으로 변경
            connection.setAutoCommit(false);
            
            // batch(일괄) 실행 
            for(BuyVo vo : cart){  // 장바구니 목록의 항목 갯수만큼 반복
            pstmt.setString(1, vo.getCustom_id());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());
            pstmt.addBatch();      // * 일괄처리할 파라미터 값을 추가. 모아두었다가 한 번에 처리.
            count++;
            }
            pstmt.executeBatch();  // * 모아둔 파라미터 값 목록으로 일괄 실행
            // 저장할 행 데이터는 n개, 오라클서버에 처리 요청은 한 번만 한다.

            // result=pstmt.executeUpdate();  // 이 명령어 반복은 요청을 n 번하게 된다.
            connection.commit();   // 데이터베이스에 영구 저장
        
    } catch (SQLException e) {
        // System.out.println(" 예외  : " + e.getMessage());
        try {
            connection.rollback();
            count=0;
        } catch (SQLException e1) {  }
    }
            return count;
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
        
    } catch (SQLException e) {
        System.out.println(" 예외  : " + e.getMessage());
    }
        return result;
   }



}
