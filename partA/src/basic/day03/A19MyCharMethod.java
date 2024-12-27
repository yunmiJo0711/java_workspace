package basic.day03;

public class A19MyCharMethod {

    public static void main(String[] args) {
        
        // Hello World~!! Hi, Java~!!
        // 문자열 검사 : 대문자, 소문자, 숫자, 그 외 문자 몇 개인가?
        String message = "Hello World~!! 9to6 Hi, Java~!!";
        int upper_count=0; 
        int lower_count=0; 
        int number_count=0; 
        int symbol_count=0; 

        for (int i=0;i<message.length();i++){
            char temp = message.charAt(i);
            System.out.println(
                String.format("문자: %c 대문자 : %5s 소문자 : %5s 숫자 : %5s",
                 temp, isUpperCase(temp),isLowerCase(temp),isNumberic(temp))
            );
            if(isUpperCase(temp)){
                upper_count++;
            }else if(isLowerCase(temp)){
                lower_count++;
            }else if(isNumberic(temp)){
                number_count++;
            }else {
                symbol_count++;
            }
        }  // for문 end

        System.out.println("대문자의 갯수 : " + upper_count);  // 4
        System.out.println("소문자의 갯수 : " + lower_count);  // 14
        System.out.println("숫자의 갯수 : " + number_count);  // 2
        System.out.println("그 외 문자의 갯수 : " + symbol_count);  // 11
        System.out.println("문자열 총 길이 : " + message.length());  // 31
    
    }  // main end
    
    // 문자를 검사하는 코드가 자주 필요하여 다음과 메소드를 정의
    // 하여 사용 하려고 합니다.
    
    // 대문자 검사 메소드 : isUpperCase
    public static boolean isUpperCase(char c){
        return(c >= 'A' && c <='Z');
    }
    // 소문자 검사 메소드 : isLowerCase
    public static boolean isLowerCase(char c){
        return(c >= 'a' && c <='z');
    }
    // 영문자 검사 메소드 : isAlphabet
    public static boolean isAlphabet(char c){
        return(c >= 'A' && c <='Z') || (c >= 'a' && c <='z');
    }
    // 숫자 검사 메소드 : isNumberic
    public static boolean isNumberic(char c){
        return(c >= '0' && c <='9');
    }
    // 아스키코드 기준으로 하기 위해 코드값이 126 보다 작은지 검사 추가
    public static boolean isSymbal(char c){
        return !isAlphabet(c) && !isNumberic(c) && (int) c <= 126;
    }

}
