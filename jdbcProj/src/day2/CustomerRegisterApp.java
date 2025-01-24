package day2;

import dao.day2.TblCustomerDao;
import oracle.net.aso.l;
import vo.day1.Customer;

public class CustomerRegisterApp {

  public static void main(String[] args) {
    // remove();
    // modify();
    System.out.println("[[고객 관리 APP]]");
    boolean run = true;
    while (run) {
      System.out.println("선택 메뉴 : 1. 고객 등록   2. 고객 정보 조회   3. 고객 정보 수정");
      System.out.println("            4. 고객 회원 탈퇴    5. 종료");
      System.out.println("메뉴 선택 >>> ");
      String menu = System.console().readLine();
      switch (menu) {
        case "1":
          register();
          break;
        case "2":
          inquiry();
          break;
        case "3":
          modify();
          break;
        case "4":
          remove();
          break;
        case "5":
          run=false;
          break;
      
        default:
          break;
      }
      
    }
    System.out.println("프로그램 종료합니다.");
  }

  public static void inquiry(){
    System.out.println("====고객 정보 조회 메뉴 입니다. ====");
    System.out.println("아이디 입력 >>> ");
    String customid = System.console().readLine();
    // TblCustomerDao customerDao = new TblCustomerDao();  // 오류 싱클톤 패턴에서 사용하면 오류.
    TblCustomerDao customerDao = TblCustomerDao.getInstance();

    Customer customer = customerDao.selectByPk(customid);
    System.out.println(customer);
  }

  public static void remove(){
    System.out.println("=====회원(고객) 탈퇴 메뉴 입니다.======");
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine(); 

    TblCustomerDao customerDao = TblCustomerDao.getInstance();
    int result = customerDao.delect(customid);

    if(result==0){
      System.out.println("회원 탈퇴 실패");
    }else{
      System.out.println("회원 탈퇴 성공!!");
    }

  }
  
  public static void modify(){

    TblCustomerDao customerDao = TblCustomerDao.getInstance();

    System.out.println("=====고객 정보 수정 메뉴 입니다.======");
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine();   
    
    System.out.println("~~~ 고객님의 현재 정보 입니다. ~~~");
    Customer customer = customerDao.selectByPk(customid);
    System.out.println(customer);
    
    System.out.println("~~~ 이메일, 우편번호 수정해주세요. ~~~");
    System.out.print(" 이메일 입력 >>> ");
    String email = System.console().readLine();
    System.out.print(" 우편번호 입력 >>> ");
    String postcode = System.console().readLine();

    // dao 클래스 메소드 사용하기
    customer = new Customer(customid, null, email, 0, null, postcode);
    
    int result = customerDao.update(customer);
    if(result==0){
      System.out.println("고객 정보 수정 실패");
    }else{
      System.out.println("고객 정보 수정 성공!!");
      customer = customerDao.selectByPk(customid);
      System.out.println(customer);
    }
  }

  public static void register(){
    TblCustomerDao customerDao = TblCustomerDao.getInstance();
    System.out.println("=====고객 등록 (회원 가입) 메뉴 입니다.======");
    boolean run = true;
    String custom_id = null;
    while (run) {
      System.out.println("사용할 아이디 입력 >>> ");
      custom_id = System.console().readLine();
      if (customerDao.selectByPk(custom_id)!=null) {
        System.out.println("중복된 아이디가 있습니다.");
      }else{
        System.out.println("사용가능 합니다. 해당 아이디를 사용하시겠습니까? (Y/N)");
        if(System.console().readLine().toUpperCase().equals("Y")) break;
      }
      
    }
    System.out.print(" 아이디 입력 >>> ");
    String customid = System.console().readLine();     
    System.out.print(" 이름 입력 >>> ");
    String name = System.console().readLine();
    System.out.print(" 이메일 입력 >>> ");
    String email = System.console().readLine();
    System.out.print(" 나이 입력 >>> ");
    int age = Integer.parseInt(System.console().readLine());   

    // Customer 객체 만들기
    Customer customer = new Customer(customid, name, email, age, null);

    // dao 클래스 사용하기
    
    int result = customerDao.insert(customer);

    if(result==0){
      System.out.println("고객 등록 실패");
    }else{
      System.out.println("고객 등록 성공!!");
    }
  }

}
