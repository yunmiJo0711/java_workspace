package basic.day04;

// 배열 활용 예시
public class A25ArrayExample {

    public static void main(String[] args) {

        int[] scores = {87,67,99,56,72};

        int sum = 0;  // 누적 합계. 초기값 꼭 정의하기.
        int avg;    // 평균
        // 1) 배열 요소의 모든 겂 합계와 평균 구하기
        for(int i=0;i<scores.length;i++){
            sum += scores[i];
        }
        System.out.println("합계 : " + sum);  //381
        System.out.println("평균 : " + (double)sum/scores.length);  //76.2


        // 2) 배열 요소에서 가장 큰값 (또는 작은 값) 구하기
        int max = scores[0];  // max 는 배열의 첫번째 값으로 초기화
        int min = scores[0]; 
        for(int i=1;i<scores.length;i++){
            if(max < scores[i]){
                max = scores[i];  // 99
            }
            if(min > scores[i])
               min = scores[i];  // 56
        }
        System.out.println("max : " + max);
        System.out.println("min : " + min);

        // 3) 배열을 메소드의 인자로 전달할 수 있습니다.
        long result = arraysMul(scores);
        System.out.println("배열 요소의 곱 : " + result);  // 2326750272


    }

    // 배열을 전달받아서 배열 요소를 모두 곱합니다. 
    // 인자 선언은 지역변수 선언. 배열할당은 호출할 때 전달.
    public static long arraysMul(int[] array){
        long result = 1;
        for(int i=0;i<array.length;i++)
            result*=array[i];  // 반복명령어 1개일 때 { } 생략.
        return result;
    }

}
