package basic.day01;

public class A04Quiz {
    public static void main(String[] args) {
    
    // 환율 : 1달러 1450원
    // 1. 여행을 갑니다. 여행 경비 50만원을 환전하려고 합니다.
    // 달러로 환전 금액은 얼마인가? 
    int money = 500000;  // 원
    int rateWon = 1450;

    // 환전금액 구하는 메소드 wonToDollar(money,rateWon) 
    // => 리턴 값(int)으로 환전금액 출력하기  = 344 달러
    int result = wonToDollar(money,rateWon);
    System.out.println("wonToDollar(money,rateWon) : "+ result+" 달러");
    
    // 344 달러 소수점까지 출력하기
    double resultDouble = wonToDollarDouble(money, rateWon);
    System.out.println("wonToDollarDouble(money, rateWon) : "+ resultDouble);


    // 2. 여행을 다녀와서 귀국했습니다. 여행 경비가 12달러가 남았습니다.
    // 원화로 환전 금액은 얼마인가?
    money = 12;  // 달러
    // 환전금액 구하는 메소드 dollarToWon(money,rateWon)
    // => 리턴 값(int)으로 환전금액 출력하기  = 17400 원
    result = dollarToWon(money,rateWon);
    System.out.println("dollarToWon(money, rateWon) : "+ result+" 원");
    
    // 17400 원 소수점까지 출력하기
    resultDouble = dollarToWonDouble(money, rateWon);
    System.out.println("dollarToWonDouble(money, rateWon) : "+ resultDouble);

}//main end


// wonToDollar 메소드 정의
// money, rateWon 은 wonToDollar 메소드 { } 스콥에서만 사용하는 지역변수
public static int wonToDollar(int money, int rateWon){
    return money/rateWon;
}

// dollarToWon 메소드 정의 
// money, rateWon 은 dollarToWon 메소드 { } 스콥에서만 사용하는 지역변수
public static int dollarToWon(int money, int rateWon){
    return money*rateWon;
}


// 요구사항 : 인자의 형식은 int 로 합니다. 
public static double wonToDollarDouble(int money, int rateWon){
    return (double)money/rateWon;
}

public static double dollarToWonDouble(int money, int rateWon){
    return (double)money*rateWon;
}

}//클래스 end
