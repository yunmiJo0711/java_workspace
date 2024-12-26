package basic.day01;

// 숙제
public class A05ForTest {
    // javascript for문을 그대로 적용
    //              ㄴ for(i=0;i<100;i++){   }

    public static void main(String[] args) {
        // 1부터 100까지 더하는 for문을 찾아서 변형하시면 됩니다. A09WhileTest.java 참고.
        long result = sumNtoM(4,10);
        System.out.println("sumNtoM(4,10) = " + result);


        int n = 4;
        int m = 10;
        sum=0;
        while (n<=m) {
            sum += n++;   
        }
        System.out.println("n=4부터 m=10 까지의 합 = " + sum);

    }

    // 메소드 정의 sumNtoM(4,10) => 4부터 10까지 더하기
    
}
