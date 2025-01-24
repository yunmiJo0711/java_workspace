package dao.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.day1.Product;

public class TblProductDao {
    // 싱글톤 패턴 정의
    private static TblProductDao dao = new TblProductDao();
    private TblProductDao(){ }
    public static TblProductDao getInstance(){
        return dao;
    }

    // db 연결 정보를 상수로 정의합니다.
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    // db 연결 객체 만드는 메소드 dao 에서만 사용할 수 있도록 정의
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // SQL 메소드 정의 각 sql connection 만들어서 사용하고 sql 실행 후 close()
    // 상품 등록하기 
    public int insert(Product vo){
        int result =0;
        String sql = "INSERT INTO TBL_PRODUCT(pcode, category, pname, price)" + 
                        "VALUES(?, ?, ?, ?)";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, vo.getPcode());
                pstmt.setString(2, vo.getCategory());
                pstmt.setString(3, vo.getPname());
                pstmt.setInt(4, vo.getPrice());

                result = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return result;
    }

    // 상품명, 가격 업데이트
    public int update(Product vo){
        int result =0;
        String sql ="UPDATE TBL_PRODOCT SET pname = ?, price = ? WHERE pcode = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, vo.getPname());
                pstmt.setInt(2, vo.getPrice());
                pstmt.setString(3, vo.getPcode());

                result = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return result;
    }

    // 기본키 값으로 삭제
    public int delect(String pname){
        int result=0;
        String sql = "DELETE FROM tbl_product WHERE pname = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, pname);

                result = pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return result;
    }

    // 기본키 값으로 조회
    public Product selectByPk(String pname){
        String sql = "SELECT * FROM TBL_PRODUCT WHERE pname = ?";
        Product product = null;
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, pname);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    product = new Product(rs.getString(1),
                                          rs.getString(2),
                                          rs.getString(3),
                                          rs.getInt(4));
                }
            
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return product;
    }

    // 상품 키워드로 조회
    public Product searchByKeyword(String pname){
        String sql = "SELECT * FROM TBL_PRODUCT LIKE '%' || ? || '%' ";
        List<Product> list = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
                pstmt.setString(1, pname);

                ResultSet rs = pstmt.executeQuery();
                Product product = null;
            while (rs.next()) {
                product = new Product(rs.getString(1),
                                      rs.getString(2),
                                      rs.getString(3),
                                      rs.getInt(4));
                list.add(product);
            }
            for(Product p : list){
                System.out.println(String.format("%-10s  %-5s  %5s  %9d",
                                                p.getPcode(), p.getCategory(), p.getPname(), p.getPrice()));
            }
            
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return null; 
    }
}
